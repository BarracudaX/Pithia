/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omada.pithia.domain.mathimata;

import static org.junit.jupiter.api.Assertions.*;

import com.omada.pithia.domain.xrhstes.Foititis;
import com.omada.pithia.domain.xrhstes.Kathigitis;
import java.time.LocalDate;
import java.util.stream.DoubleStream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
/**
 *
 * @author Barracuda
 */
public class ErgasthrioTest {
    
    private Thewria thewriaErgasthriou ;

    private Kathigitis kathigitisThewrias = new Kathigitis("VALID_ONOMA",
            "VALID_EPWNUMO", LocalDate.now().minusYears(40), "VALID_ONOMA_X", "VALID_KWDIKOS",
            "VALID_EMAIL@EMAI.COM");

    private Kathigitis kathigitisErgasthriou = new Kathigitis("VALID_ONOMA",
            "VALID_EPWNUMO", LocalDate.now().minusYears(40), "VALID_ONOMA_X2", "VALID_KWDIKOS2",
            "VALID_EMAIL@EMAI.COM");

    private Foititis foititis = new Foititis("VALID_ONOMA",
            "VALID_EPWNUMO", LocalDate.now().minusYears(40), "VALID_ONOMA_X", "VALID_KWDIKOS",
            "VALID_EMAIL@EMAI.COM");

    private Ergasthrio sut;

    @BeforeEach
    public void setUp(){
        thewriaErgasthriou = new Thewria("VALID_ONOMA", kathigitisThewrias, Eksamhno.B);
        sut = new Ergasthrio("VALID_ONOMA", kathigitisErgasthriou,thewriaErgasthriou);
        thewriaErgasthriou.addErgasthrio(sut);
        thewriaErgasthriou.addFoititi(foititis);
    }

    @Test
    public void prepeiNaProstheseiKainourioFoititiStoErgasthrio(){
        assertFalse(thewriaErgasthriou.getErgasthrioFoititi(foititis).isPresent());

        sut.addFoititi(foititis);

        assertEquals(sut, thewriaErgasthriou.getErgasthrioFoititi(foititis).get());
        assertTrue(sut.getFoitites().contains(foititis));
    }

    @Test
    public void prepeiNaEpistrepseiTonVathmoTouFoititi(){
        assertFalse(sut.getVathmoErgasthriou(foititis).isPresent());

        sut.addFoititi(foititis);

        assertEquals(0,sut.getVathmoErgasthriou(foititis).get());

        double kainouriosVathmoErgasthriou = 5.8;
        sut.addVathmoErgasthriou(foititis,kainouriosVathmoErgasthriou);

        assertEquals(kainouriosVathmoErgasthriou,sut.getVathmoErgasthriou(foititis).get(),0.1);
    }

    @Test
    public void prepeiNaEpistrepseiTisApousiesTouFoititi(){
        assertFalse(sut.getApousiesFoititi(foititis).isPresent());

        sut.addFoititi(foititis);

        Apousia apousiesFoititi = sut.getApousiesFoititi(foititis).get();

        assertEquals(0, apousiesFoititi.getArithmosApousiwn());
    }

    @Test
    public void prepeiNaPetakseiIllegalArgumentExceptionOtanZhtameVathmoFoititiPouDenParakoloutheiThnThewria(){
        assertThrows(IllegalArgumentException.class, () -> sut.addVathmoErgasthriou(foititis,5.8));
        sut.addFoititi(foititis);
        assertDoesNotThrow(() -> sut.addVathmoErgasthriou(foititis,5.8));
    }

    @Test
    public void prepeiNaPetakseiNullPointerExceptionOtanKaloumeMethodousProsthikisMeNull(){
        assertThrows(NullPointerException.class, () -> sut.addVathmoErgasthriou(null, 5.8));
        assertThrows(NullPointerException.class, () -> sut.addFoititi(null));
    }

    @ParameterizedTest
    @MethodSource("getLathosVathmous")
    public void prepeiNaPetakseiIllegalArgumentExceptionOtanProsthetoumeLathosVathmos(double lathosVathmos) {
        sut.addFoititi(foititis);
        assertThrows(IllegalArgumentException.class, () -> sut.addVathmoErgasthriou(foititis, lathosVathmos));
    }

    private static DoubleStream getLathosVathmous(){
        return DoubleStream.of(-100, -1, -0.99, Double.NaN, 10.01, 11, 100);
    }
    
}
