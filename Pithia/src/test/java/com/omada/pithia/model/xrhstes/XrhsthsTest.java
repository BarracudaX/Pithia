package com.omada.pithia.model.xrhstes;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class XrhsthsTest {

    @Test
    @DisplayName("Πρεπει να πεταξει NullPointerException οταν καποιο απο τα ορισματα του δομητη ειναι null.")
    public void prepeiNaPetakseiNPEOtanKapoioOrismaDomhthEinaiNull(){
        assertThrows(NullPointerException.class, () -> {
            Xrhsths xrhsths = new Xrhsths(null, "epwnumo", LocalDate.now().minusYears(18),
                "12345678", "kwdikos121", "email@edu.com");
        });
        assertThrows(NullPointerException.class, () -> {
            Xrhsths xrhsths = new Xrhsths("onoma", null, LocalDate.now().minusYears(18),
                "12345678", "kwdikos121", "email@edu.com");
        });
        assertThrows(NullPointerException.class, () -> {
            Xrhsths xrhsths = new Xrhsths("onoma", "epwnumo", null,
                "12345678", "kwdikos121", "email@edu.com");
        });
        assertThrows(NullPointerException.class, () -> {
            Xrhsths xrhsths = new Xrhsths("onoma", "epwnumo", LocalDate.now().minusYears(18),
                null, "kwdikos121", "email@edu.com");
        });
        assertThrows(NullPointerException.class, () -> {
            Xrhsths xrhsths = new Xrhsths("onoma", "epwnumo", LocalDate.now().minusYears(18),
                "12345678", null, "email@edu.com");
        });
        assertThrows(NullPointerException.class, () -> {
            Xrhsths xrhsths = new Xrhsths("onoma", "epwnumo", LocalDate.now().minusYears(18),
                "12345678", "kwdikos121", null);
        });

    }

    @Test
    @DisplayName("Πρεπει να πεταξει IllegalArgumentException οταν το ονομα ειναι κενο.")
    public void prepeiNaPetakseiIAEOtanToOnomaEinaiKeno(){
        assertThrows(IllegalArgumentException.class,()->{
            Xrhsths xrhsths = new Xrhsths("", "epwnumo", LocalDate.now().minusYears(18),
                    "12345678", "kwdikos121", "email@edu.com");
        });
    }

    @Test
    @DisplayName("Πρεπει να πεταξει IllegalArgumentException οταν το επωνυμο ειναι κενο.")
    public void prepeiNaPetakseiIAEOtanToEpwnumoEinaiKeno(){
        assertThrows(IllegalArgumentException.class,()->{
            Xrhsths xrhsths = new Xrhsths("Μαρια", "", LocalDate.now().minusYears(18),
                    "12345678", "kwdikos121", "email@edu.com");
        });
    }


    @Test
    @DisplayName("Πρεπει να πεταξει IllegalArgumentException οταν ο χρηστης ειναι ανηλικος")
    public void prepeiNaPetakseiIAEOtanOXrhsthsEinaiAnhlikos(){
        assertThrows(IllegalArgumentException.class,()->{
            Xrhsths xrhsths = new Xrhsths("Μαρια", "Maria", LocalDate.now().minusYears(17),
                    "12345678", "kwdikos121", "email@edu.com");
        });
    }

    @ParameterizedTest
    @DisplayName("Πρεπει να πεταξει IllegalArgumentException οταν το ονομα χρηστη δεν εχει σωστο μηκος.")
    @MethodSource("getStringMikroterou8Xarakthrwn")
    public void prepeiNaPetakseiIAEOtanToOnomaXrhsthDenExeiSwstoMhkos(String lathosOnomaXrhsth){
        assertThrows(IllegalArgumentException.class,()->{
            Xrhsths xrhsths = new Xrhsths("Μαρια", "Maria", LocalDate.now().minusYears(20),
                    lathosOnomaXrhsth, "kwdikos121", "email@edu.com");
        });
    }

    @ParameterizedTest
    @DisplayName("Πρεπει να πεταξει IllegalArgumentException οταν ο κωδικος δεν εχει σωστο μηκος.")
    @MethodSource("getStringMikroterou8Xarakthrwn")
    public void prepeiNaPetakseiIAEOtanOKwdikosDenExeiSwstoMhkos(String lathosKwdikos){
        assertThrows(IllegalArgumentException.class,()->{
            Xrhsths xrhsths = new Xrhsths("Μαρια", "Maria", LocalDate.now().minusYears(20),
                    "onomaXrhsth12", lathosKwdikos, "email@edu.com");
        });
    }

    @ParameterizedTest
    @DisplayName("Πρεπει να πεταξει IllegalArgumentException οταν το εμαιλ δεν ειναι σωστο.")
    @MethodSource("getLathosEmail")
    public void prepeiNaPetakseiIAEOtanToEmailDenKaneiMatchToGenikoPatternTouEmail(String lathosEmail){
        assertThrows(IllegalArgumentException.class,()->{
            Xrhsths xrhsths = new Xrhsths("Μαρια", "Maria", LocalDate.now().minusYears(20),
                    "onomaXrhsth12", "122334124124", lathosEmail);
        });
    }


    private static Stream<String> getStringMikroterou8Xarakthrwn(){
        return Stream.of("        ","7charac", "6chara", "5char", "4cha", "3ch", "2c", "1", "");
    }

    private static Stream<String> getLathosEmail(){
        return Stream.of("","      ","@","@mail.ru","gmail.com","gmail.com@onoma122");
    }

}