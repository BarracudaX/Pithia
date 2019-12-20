package com.omada.pithia.model.xrhstes;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

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

}