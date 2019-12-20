package com.omada.pithia;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Kathigitis;

import java.time.LocalDate;
import java.util.Map;

public class DeuteroParadotaio {

    //KATHIGITES
    private static Kathigitis kathigitis ;
    //ΦΟΙΤΗΤΕΣ/ΤΡΙΕΣ
    //Επειδη εβαλα το ονομα χρηστη(που για φοιτητες/τριες ειναι και ο αμ τους) να ειναι τουλαχιστον 8 χαρακτηρες,
    //συμπληρωανα με μηδενικα.
    private static Foititis foititisKimwn ;
    private static Foititis foititriaAndromaxh ;
    private static Foititis foititisAlkis ;
    //ΜΑΘΗΜΑΤΑ
    private static Thewria antikeimenostrefhsProgrammatimosThewria;
    private static Thewria domesDedomenwnKaiAnalushAlgorithmwnThewria;
    private static Thewria mhxanikhLogismikouThewria ;
    private static Ergasthrio antikeimenostrefhsProgrammatimosErgasthrio;


    public static void main(String[] args) {


        System.out.println(
                "*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*\n" +
                        "Κληση Μεθοδου Δηλωση Μαθηματων\n" +
                        "*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*\n");
        prepareData();
        dhlwshMathimatwn();

        System.out.println(
                "*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*\n" +
                        "Κληση Μεθοδου Κατασταση Φοιτητων\n" +
                        "*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*\n");
        prepareData();
        katastashFoititwn();
    }

    private static void katastashFoititwn() {
        antikeimenostrefhsProgrammatimosThewria.addFoititi(foititisKimwn);
        antikeimenostrefhsProgrammatimosThewria.addVathmoThewrias(8.0, foititisKimwn);

        antikeimenostrefhsProgrammatimosThewria.addFoititi(foititisAlkis);
        antikeimenostrefhsProgrammatimosThewria.addVathmoThewrias(7.0,foititisAlkis);
        domesDedomenwnKaiAnalushAlgorithmwnThewria.addFoititi(foititisAlkis);
        domesDedomenwnKaiAnalushAlgorithmwnThewria.addVathmoThewrias(4.0, foititisAlkis);

        System.out.println("Κατασταση του/της φοιτητη/τρια με ονομα χρηστη = "+foititisKimwn.getOnomaXrhsth());
        showKatastashFoititi(foititisKimwn);
        System.out.println("\n");

        System.out.println("Κατασταση του/της φοιτητη/τρια με ονομα χρηστη = "+foititisAlkis.getOnomaXrhsth());
        showKatastashFoititi(foititisAlkis);
        System.out.println("\n");
    }

    private static void showKatastashFoititi(Foititis foititis) {
        for (Map.Entry<String, Double> vathmos : foititis.getVathmous().entrySet()) {
            System.out.println(vathmos.getKey() + " = " + vathmos.getValue());
        }
    }

    private static void dhlwshMathimatwn() {

        //Dhlwsh Mathimatwn
        System.out.println("Δηλως μαθηματος Αντικειμενοστρεφής Προγραμματισμός (Θ) απο φοιτητη/τρια με ονομα χρηστη = " +
                foititisKimwn.getOnomaXrhsth());
        antikeimenostrefhsProgrammatimosThewria.addFoititi(foititisKimwn);//1h grammh pinaka
        System.out.println("Επιτυχης.\n");


        antikeimenostrefhsProgrammatimosThewria.addVathmoThewrias(8.0, foititisKimwn);//2h grammh pinaka


        System.out.println("Δηλως μαθηματος Δομές Δεδομένων και Ανάλυση Αλγορίθμων απο φοιτητη/τρια με ονομα χρηστη = " +
                foititisKimwn.getOnomaXrhsth());
        domesDedomenwnKaiAnalushAlgorithmwnThewria.addFoititi(foititisKimwn);//3h grammh
        System.out.println("Επιτυχης.\n");


        try {
            System.out.println("Δηλως μαθηματος Μηχανική Λογισμικού απο φοιτητη/τρια με ονομα χρηστη = " +
                    foititisKimwn.getOnomaXrhsth());
            mhxanikhLogismikouThewria.addFoititi(foititisKimwn);//4h grammh
            System.out.println("Επιτυχης.");
        } catch (IllegalArgumentException e) {
            System.out.println("Μη επιτυχης.Ακολουθει μηνυμα λαθους : ");
            showErrorMessage(e);
            System.out.println("\n");
        }

        try {
            System.out.println("Δηλως μαθηματος Αντικειμενοστρεφής Προγραμματισμός (Ε) απο φοιτητη/τρια με ονομα χρηστη = " +
                    foititriaAndromaxh.getOnomaXrhsth());
            antikeimenostrefhsProgrammatimosThewria
                    .addFoititiStoErgasthrio(foititriaAndromaxh, antikeimenostrefhsProgrammatimosErgasthrio);//5h grammh
            System.out.println("Επιτυχης.");
        } catch (IllegalArgumentException e) {
            System.out.println("Μη επιτυχης.Ακολουθει μηνυμα λαθους : ");
            showErrorMessage(e);
            System.out.println("\n");
        }


        try {
            System.out.println("Δηλως μαθηματος Δομές Δεδομένων και Ανάλυση Αλγορίθμων απο φοιτητη/τρια με ονομα χρηστη = " +
                    foititriaAndromaxh.getOnomaXrhsth());
            domesDedomenwnKaiAnalushAlgorithmwnThewria.addFoititi(foititriaAndromaxh);//6h grammh
            System.out.println("Επιτυχης.");
        } catch (IllegalArgumentException e) {
            System.out.println("Μη επιτυχης.Ακολουθει μηνυμα λαθους : ");
            showErrorMessage(e);
            System.out.println("\n");
        }

        try {
            System.out.println("Δηλως μαθηματος Μηχανική Λογισμικού απο φοιτητη/τρια με ονομα χρηστη = " +
                    foititriaAndromaxh.getOnomaXrhsth());
            mhxanikhLogismikouThewria.addFoititi(foititriaAndromaxh);//7h grammh
            System.out.println("Επιτυχης.");
        } catch (IllegalArgumentException e) {
            System.out.println("Μη επιτυχης.Ακολουθει μηνυμα λαθους : ");
            showErrorMessage(e);
            System.out.println("\n");
        }

        System.out.println("Δηλως μαθηματος Αντικειμενοστρεφής Προγραμματισμός (Θ) απο φοιτητη/τρια με ονομα χρηστη = " +
                foititisAlkis.getOnomaXrhsth());
        antikeimenostrefhsProgrammatimosThewria.addFoititi(foititisAlkis);//8h grammh
        System.out.println("Επιτυχης.\n");

        antikeimenostrefhsProgrammatimosThewria.addVathmoThewrias(7.0, foititisAlkis);//9h  grammh

        System.out.println("Δηλως μαθηματος Δομές Δεδομένων και Ανάλυση Αλγορίθμων απο φοιτητη/τρια με ονομα χρηστη = " +
                foititisAlkis.getOnomaXrhsth());
        domesDedomenwnKaiAnalushAlgorithmwnThewria.addFoititi(foititisAlkis);//10h grammh
        System.out.println("Επιτυχης.\n");

        domesDedomenwnKaiAnalushAlgorithmwnThewria.addVathmoThewrias(4.0, foititisAlkis);//11h grammh

        try {
            System.out.println("Δηλως μαθηματος Μηχανική Λογισμικού απο φοιτητη/τρια με ονομα χρηστη = " +
                    foititisAlkis.getOnomaXrhsth());
            mhxanikhLogismikouThewria.addFoititi(foititisAlkis);
        } catch (IllegalArgumentException e) {
            System.out.println("Μη επιτυχης.Ακολουθει μηνυμα λαθους : ");
            showErrorMessage(e);
            System.out.println("\n");
        }
    }

    private static void showErrorMessage(IllegalArgumentException exception) {
        if (exception.getMessage() != null) {
            System.out.println(exception.getMessage());
        }
        for (Throwable throwable : exception.getSuppressed()) {
            System.out.println(throwable.getMessage());
        }
    }


    private static void prepareData() {
        //KATHIGITES
        Kathigitis kathigitis = new Kathigitis("KATHIGITIS", "KATHIGITIS",
                LocalDate.now().minusYears(20), "KATHIGITIS123", "KATHIGITIS123", "123@edu.com");

        //ΦΟΙΤΗΤΕΣ/ΤΡΙΕΣ
        //Επειδη εβαλα το ονομα χρηστη(που για φοιτητες/τριες ειναι και ο αμ τους) να ειναι τουλαχιστον 8 χαρακτηρες,
        //συμπληρωανα με μηδενικα.

        foititisKimwn = new Foititis("Κιμων", "Αθανασιου",
                LocalDate.now().minusYears(20), "15123400", "kwdikos121", "15123400@edu.com");
        foititriaAndromaxh = new Foititis("Ανδρομαχη", "Βασιλειαδου",
                LocalDate.now().minusYears(20), "16321700", "kwdikos121", "16321700@edu.com");
        foititisAlkis = new Foititis("Αλκης", "Γεωργιου",
                LocalDate.now().minusYears(20), "17227800", "kwdikos121", "17227800@edu.com");

        //ΜΑΘΗΜΑΤΑ
        antikeimenostrefhsProgrammatimosThewria
                = new Thewria("Αντικειμενοστρεφής Προγραμματισμός (Θ)", kathigitis, Eksamhno.A);
        domesDedomenwnKaiAnalushAlgorithmwnThewria
                = new Thewria("Δομές Δεδομένων και Ανάλυση Αλγορίθμων", kathigitis, Eksamhno.B);
        mhxanikhLogismikouThewria
                = new Thewria("Μηχανική Λογισμικού", kathigitis, Eksamhno.C);

        //Dhlwsh Ergasthriou
        antikeimenostrefhsProgrammatimosErgasthrio
                = new Ergasthrio("Αντικειμενοστρεφής Προγραμματισμός (Ε)", kathigitis, antikeimenostrefhsProgrammatimosThewria);
        antikeimenostrefhsProgrammatimosThewria.addErgasthrio(antikeimenostrefhsProgrammatimosErgasthrio);

        //Dhlwsh Proapaitoumenwn
        domesDedomenwnKaiAnalushAlgorithmwnThewria.addProapaitoumeno(antikeimenostrefhsProgrammatimosThewria);
        mhxanikhLogismikouThewria.addProapaitoumeno(antikeimenostrefhsProgrammatimosThewria);
        mhxanikhLogismikouThewria.addProapaitoumeno(domesDedomenwnKaiAnalushAlgorithmwnThewria);

    }


}
