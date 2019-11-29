/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omada.pithia.domain.mathimata;

import com.omada.pithia.domain.xrhstes.Foititis;
import com.omada.pithia.domain.xrhstes.Kathigitis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.DoubleStream;
import com.omada.pithia.domain.mathimata.Thewria;
import static org.junit.jupiter.api.Assertions.*;

public class ThewriaTest {

    private Thewria sut;

    private Kathigitis kathigitisThewrias = new Kathigitis("VALID_ONOMA",
            "VALID_EPWNUMO", LocalDate.now().minusYears(40), "VALID_ONOMA_X", "VALID_KWDIKOS",
            "VALID_EMAIL@EMAI.COM");

    private Kathigitis kathigitisErgasthriou = new Kathigitis("VALID_ONOMA",
            "VALID_EPWNUMO", LocalDate.now().minusYears(40), "VALID_ONOMA_X2", "VALID_KWDIKOS2",
            "VALID_EMAIL@EMAI.COM");

    private Foititis foititis = new Foititis("VALID_ONOMA",
            "VALID_EPWNUMO", LocalDate.now().minusYears(40), "VALID_ONOMA_X", "VALID_KWDIKOS",
            "VALID_EMAIL@EMAI.COM");


    private Ergasthrio ergasthrio ;

    @BeforeEach
    public void setUp(){
        sut = new Thewria("VALID_ONOMA", kathigitisThewrias, Eksamhno.A);
        ergasthrio = new Ergasthrio("VALID_ONOMA", kathigitisErgasthriou,sut);
    }

    @Test
    @DisplayName("Πρεπει να προσθεσει την θεωρία στον καθηγητη που περναμε ως παράμετρο στον constructor.")
    public void prepeiNaProstheseiStonKathigitiThewriaPouDidaskei(){
        Thewria thewria = new Thewria("VALID_ONOMA", kathigitisThewrias,Eksamhno.E);

        assertTrue(kathigitisThewrias.getThewries().contains(thewria));
    }

    @Test
    @DisplayName("Πρέπει να προσθέσε καινούριο φοιτιτή στην θεωρία.")
    public void prepeiNaProstheseiKainourioFoititiSthThewria(){
        assertFalse(foititis.getThewries().contains(sut));
        assertFalse(sut.getFoitites().contains(foititis));

        sut.addFoititi(foititis);

        assertTrue(foititis.getThewries().contains(sut));
        assertTrue(sut.getFoitites().contains(foititis));
    }

    @Test
    @DisplayName(
            "Πρέπει να πετάξει IllegalArgumentException όταν καλούμε addVathmoThewrias " +
            "με παράμετρο φοιτιτή που δεν παρακολουθεί την θεωρία."
    )
    public void prepeiNaPetakseiIllegalArgumentExceptionOtanProsthetoumeVathmoSeFoititiPouDenParakoloutheiThewria(){
        assertThrows(IllegalArgumentException.class, () -> sut.addVathmoThewrias(9, foititis));

        sut.addFoititi(foititis);

        assertDoesNotThrow(() -> sut.addVathmoThewrias(9,foititis));
    }

    @Test
    @DisplayName(
            "Πρέπει να επιστρέψει κενό βαθμό όταν ζητάμε βαθμό φοιτιτή που δεν παρακολουθεί την θεωρία."
    )
    public void prepeiNaEpistrepseiKenoVathmoOtanZhtamVathmoFoititiPouDenParakoloutheiThnThewria(){
        assertFalse(sut.getVathmoThewrias(foititis).isPresent());

        sut.addFoititi(foititis);

        assertTrue(sut.getVathmoThewrias(foititis).isPresent());
    }

    @Test
    @DisplayName(
            "Πρέπει να προσθέσει αρχικό βαθμό στον φοιτιτή ίσο με το μήδεν."
    )
    public void prepeiNaProstheseiArxikoVathmoStoFoititiIsoMeToMhden(){
        sut.addFoititi(foititis);

        assertEquals(0,sut.getVathmoThewrias(foititis).get());
    }

    @Test
    @DisplayName(
            "Πρέπει να αλλάζει τον βαθμό του φοιτιτή."
    )
    public void prepeiNaAllazeiTonVathmoTouFoititi(){
        double kainouriosVathmos = 8.7;

        sut.addFoititi(foititis);
        assertEquals(0,sut.getVathmoThewrias(foititis).get());

        sut.addVathmoThewrias(kainouriosVathmos,foititis);

        assertEquals(kainouriosVathmos,sut.getVathmoThewrias(foititis).get(),0.1);
    }

    @Test
    @DisplayName(
            "Πρέπει να προσθέσει καινούριο εργαστήριο στην θεωρία."
    )
    public void prepeiNaProstheseiKainouioErgasthrioSthnThewria(){
        assertFalse(kathigitisErgasthriou.getErgasthria().contains(ergasthrio));

        sut.addErgasthrio(ergasthrio);

        assertTrue(kathigitisErgasthriou.getErgasthria().contains(ergasthrio));
    }

    @Test
    @DisplayName(
            "Πρέπει να επιστρέφει όλα τα εργαστήρια του καθηγητή που ζητήθηκε."
    )
    public void prepeiNaEpistrefeiOlesTaErgasthriaTouKathigiti(){
        Ergasthrio deuteroErgasthrio = new Ergasthrio("VALID_ERGASTHRIO1", kathigitisErgasthriou,sut);
        Ergasthrio tritorErgasthrio = new Ergasthrio("VALID_ERGASTHRIO2", kathigitisThewrias,sut);

        sut.addErgasthrio(ergasthrio);
        sut.addErgasthrio(deuteroErgasthrio);
        sut.addErgasthrio(tritorErgasthrio);

        Collection<? extends Ergasthrio> ergasthriaKathigitiErgasthriou = sut.getErgasthriaKathigiti(kathigitisErgasthriou);

        assertEquals(2, ergasthriaKathigitiErgasthriou.size());
        assertTrue(ergasthriaKathigitiErgasthriou.contains(ergasthrio));
        assertTrue(ergasthriaKathigitiErgasthriou.contains(deuteroErgasthrio));

        Collection<? extends Ergasthrio> ergasthriaKathigitiThewrias = sut.getErgasthriaKathigiti(kathigitisThewrias);

        assertEquals(1, ergasthriaKathigitiThewrias.size());
        assertTrue(ergasthriaKathigitiThewrias.contains(tritorErgasthrio));
    }


    @Test
    @DisplayName(
            "Πρέπει να επιστρέφει εργαστήριο στο οποίιο ανήκει ο φοιτιτής.Ή να επιστρέφει κενό."
    )
    public void prepeiNaEpistrfeiToErgasthrioStoOpoioAnhkeiOFoititis(){
        assertFalse(sut.getErgasthrioFoititi(foititis).isPresent());

        sut.addFoititi(foititis);//Προσθηκη του φοιτιτη στην θεωρια.
        assertFalse(sut.getErgasthrioFoititi(foititis).isPresent());

        sut.addErgasthrio(ergasthrio);
        ergasthrio.addFoititi(foititis);

        assertEquals(ergasthrio,sut.getErgasthrioFoititi(foititis).get());
    }

    @Test
    @DisplayName(
            "Πρέπει να επιστρέψει φοιτιτές/τριες που δεν παρακολουθούν κανένα εργαστήριο θεωρίας."
    )
    public void prepeiNaEpistrepseiFoititesXwrisErgasthrio(){
        Foititis deuterosFoititis = new Foititis("VALID_ONOMA",
                "VALID_EPWNUMO", LocalDate.now().minusYears(40), "VALID_ONOMA_X233", "VALID_KWDIKOS",
                "VALID_EMAIL@EMAI.COM");

        Collection<Foititis> foititesXwrisErgasthrio = sut.getFoititesXwrisErgasthrio();

        assertTrue(foititesXwrisErgasthrio.isEmpty());

        sut.addFoititi(foititis);
        sut.addFoititi(deuterosFoititis);

        foititesXwrisErgasthrio = sut.getFoititesXwrisErgasthrio();

        assertEquals(2,foititesXwrisErgasthrio.size());
        assertTrue(foititesXwrisErgasthrio.contains(foititis));
        assertTrue(foititesXwrisErgasthrio.contains(deuterosFoititis));

        sut.addErgasthrio(ergasthrio);
        ergasthrio.addFoititi(foititis);

        foititesXwrisErgasthrio = sut.getFoititesXwrisErgasthrio();

        assertEquals(1,foititesXwrisErgasthrio.size());
        assertTrue(foititesXwrisErgasthrio.contains(deuterosFoititis));
        assertFalse(foititesXwrisErgasthrio.contains(foititis));
    }

    @Test
    @DisplayName(
            "Πρέπει να πετάξει το NullPointerException όταν καλούμε μέθοδο add* με null αναφορα."
    )
    public void prepeiNaPetakseiNullPointerExceptionOtanKaloumeAddMethodousMeNullReferences(){
        sut.addErgasthrio(ergasthrio);
        sut.addFoititi(foititis);
        sut.addFoititiStoErgasthrio(foititis,ergasthrio);
        assertThrows(NullPointerException.class, () -> sut.addFoititi(null));
        assertThrows(NullPointerException.class, () -> sut.addErgasthrio(null));
        assertThrows(NullPointerException.class, () -> sut.addFoititiStoErgasthrio(null,ergasthrio));
        assertThrows(NullPointerException.class, () -> sut.addFoititiStoErgasthrio(foititis,null));
        assertThrows(NullPointerException.class, () -> sut.addVathmoThewrias(0,null));
    }

    @ParameterizedTest
    @MethodSource("getLathosVathmous")
    @DisplayName(
            "Πρέπει να πετάξει IllegalArgumentException όταν ο βαθμός θεωρίας είναι λάθος."
    )
    public void prepeiNaPetakseiIllegalArgumentExceptionOtanProsthetoumeLathosVathmo(double lathosVathmos) {
        sut.addFoititi(foititis);
        assertThrows(IllegalArgumentException.class, () -> sut.addVathmoThewrias(lathosVathmos, foititis));
    }

    @Test
    @DisplayName(
            "΄Πρέπει να πετάξει IllegalArgumentException όταν προσθέτουμε έναν φοιτιτή/τρια στο εργαστήριο " +
                    "αλλά αυτός/η δεν παρακολουθεί την θεωρία."
    )
    public void prepeiNaPetakseiIllegalArgumentExceptionOtanProsthetoumeFoititiStoErgasthrioOtanDenExeiDhlwshThnThewria(){
        sut.addErgasthrio(ergasthrio);
        assertThrows(IllegalArgumentException.class,() -> sut.addFoititiStoErgasthrio(foititis,ergasthrio));

        sut.addFoititi(foititis);
        assertDoesNotThrow(() -> sut.addFoititiStoErgasthrio(foititis,ergasthrio));
    }

    @Test
    @DisplayName(
            "Πρέπει να πετάξει IllegalArgumentException όταν προσθέτουμε έναν φοιτιτή/τρια στην θεωρία " +
                    "αλλά αυτός/η δεν έχει περάσει τα προαπαιτούμενα της θεωρίας."
    )
    public void prepeiNaPetakseiIllegalArgumentExceptionOtanProsthetoumeFoititiPouDenExeiPeraseiTaProapaitoumena(){
        Thewria proapaitoumeno1 = new Thewria("PROAPAITOUMENO", kathigitisThewrias, Eksamhno.F);
        Thewria proapaitoumeno2 = new Thewria("PROAPAITOUMENO2", kathigitisThewrias, Eksamhno.G);
        sut.addProapaitoumeno(proapaitoumeno1);
        sut.addProapaitoumeno(proapaitoumeno2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> sut.addFoititi(foititis));
        assertEquals(2,exception.getSuppressed().length);

        proapaitoumeno1.addFoititi(foititis);
        exception = assertThrows(IllegalArgumentException.class, () -> sut.addFoititi(foititis));
        assertEquals(2,exception.getSuppressed().length);

        proapaitoumeno1.addVathmoThewrias(4.9,foititis);
        exception = assertThrows(IllegalArgumentException.class, () -> sut.addFoititi(foititis));
        assertEquals(2,exception.getSuppressed().length);

        proapaitoumeno1.addVathmoThewrias(5.0,foititis);
        exception = assertThrows(IllegalArgumentException.class,() -> sut.addFoititi(foititis));
        assertEquals(1,exception.getSuppressed().length);

        proapaitoumeno2.addFoititi(foititis);
        proapaitoumeno2.addVathmoThewrias(9.0, foititis);

        assertDoesNotThrow(() -> sut.addFoititi(foititis));

    }


    private static DoubleStream getLathosVathmous(){
        return DoubleStream.of(-100, -1, -0.99, Double.NaN, 10.01, 11, 100);
    }

}