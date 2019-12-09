package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.*;
import com.omada.pithia.ui.controller.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Pithia extends JFrame {

    private volatile XrhstesService xrhstesService;
    private volatile ThewriesService thewriesService;
    private  volatile ErgasthrioService ergasthrioService;

    private static final String LOGIN_PAGE_CARD_NAME = "LOGIN_PAGE";
    private static final String HOME_PAGE_CARD_NAME = "HOME_PAGE";
    private static final String MATHIMATA_MOU_PAGE_CARD_NAME = "MATHIMATA_MOU_PAGE";
    private static final String PROSTHIKI_MATHIMATOS_PAGE_CARD_NAME = "PROSTHIKI_MATHIMATOS_PAGE";
    private static final String KATSTASH_PAGE_CARD_NAME = "KATSTASH_PAGE";
    private static final String DHLWSH_MATHIMATWN_PAGE_CARD_NAME = "DHLWSH_MATHIMATWN_PAGE";
    private static final String FOITITES_PAGE_CARD_NAME = "FOITITES_PAGE";
    private static final String LOGARIASMOS_MOU_PAGE_CARD_NAME = "LOGARIASMOS_MOU_PAGE";
    private static final String THEWRIES_PAGE_CARD_NAME = "THEWRIES_PAGE";
    private static final String ERGASTHRIA_PAGE_CARD_NAME = "ERGASTHRIA_PAGE";
    private static final String THEWRIA_PAGE_CARD_NAME = "THEWRIA_PAGE";

    private final HomePageUI homePageUI;
    private final MathimataMouPageUI mathimataMouPageUI;
    private final FoititesPageUI foititesPageUI;
    private final LoginPageUI loginPageUI;
    private final ThewriesPageUI thewriesPageUI;
    private final ErgasthriaPageUI ergasthriaPageUI;

    private final ViewSwitchController viewSwitchController;
    private final MathimataMouController mathimataMouController;
    private final FoititesController foititesController;
    private final LoginController loginController;
    private final ThewriesController thewriesController;
    private final ErgasthriaController ergasthriaController;

    private final CardLayout cardLayout = new CardLayout();

    private final JPanel mainPanel = new JPanel();

    private final MyAction backToHomeAction;

    public Pithia() {
        this.viewSwitchController = new ViewSwitchController(this);
        this.mathimataMouController = new MathimataMouController(viewSwitchController);
        this.loginController = new LoginController(viewSwitchController);
        this.thewriesController = new ThewriesController(viewSwitchController);
        this.ergasthriaController = new ErgasthriaController(viewSwitchController);
        this.foititesController = new FoititesController();
        this.backToHomeAction = this::switchToHomePageGUI;

        loginPageUI = new LoginPageUI(loginController);
        homePageUI = new HomePageUI(viewSwitchController);
        mathimataMouPageUI = new MathimataMouPageUI(mathimataMouController, backToHomeAction);
        foititesPageUI = new FoititesPageUI(foititesController, backToHomeAction);
        thewriesPageUI = new ThewriesPageUI(thewriesController);
        ergasthriaPageUI = new ErgasthriaPageUI(ergasthriaController);
    }


    public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException {
        Pithia pithia = new Pithia();
        pithia.start();
    }

    public void start() throws InvocationTargetException, InterruptedException, IOException {
        prepareData();

        SwingUtilities.invokeAndWait(() -> {
            mainPanel.setLayout(cardLayout);

            mainPanel.add(loginPageUI, LOGIN_PAGE_CARD_NAME);
            mainPanel.add(homePageUI, HOME_PAGE_CARD_NAME);
            mainPanel.add(mathimataMouPageUI, MATHIMATA_MOU_PAGE_CARD_NAME);
            mainPanel.add(foititesPageUI, FOITITES_PAGE_CARD_NAME);
            mainPanel.add(thewriesPageUI, THEWRIES_PAGE_CARD_NAME);
            mainPanel.add(ergasthriaPageUI, ERGASTHRIA_PAGE_CARD_NAME);

            this.getContentPane().setBackground(GeneralStyle.GENERAL_BACKGROUND_COLOR);
            this.setContentPane(mainPanel);
            this.setSize(500, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.pack();
        });
    }

    public void switchToHomePageGUI() {
        cardLayout.show(mainPanel, HOME_PAGE_CARD_NAME);
    }

    public void switchToMathimataMouGUI() {
        cardLayout.show(mainPanel, MATHIMATA_MOU_PAGE_CARD_NAME);
    }

    public void switchToProsthikiMathimatosGUI() {
        cardLayout.show(mainPanel, PROSTHIKI_MATHIMATOS_PAGE_CARD_NAME);
    }

    public void switchToKatastashGUI() {
        cardLayout.show(mainPanel, KATSTASH_PAGE_CARD_NAME);
    }

    public void switchToDhlwshMathimatwnGUI() {
        cardLayout.show(mainPanel, DHLWSH_MATHIMATWN_PAGE_CARD_NAME);
    }

    public void switchToFoititesGUI() {
        cardLayout.show(mainPanel, FOITITES_PAGE_CARD_NAME);
    }

    public void switchToLogariasmosMouGUI() {
        cardLayout.show(mainPanel, LOGARIASMOS_MOU_PAGE_CARD_NAME);
    }

    public void logout() {
        cardLayout.show(mainPanel, LOGIN_PAGE_CARD_NAME);
    }

    public void switchToThewriesGUI() {
        cardLayout.show(mainPanel, THEWRIES_PAGE_CARD_NAME);
    }

    public void switchToErgasthriaGUI() {
        cardLayout.show(mainPanel, ERGASTHRIA_PAGE_CARD_NAME);
    }

    public void switchToThewriaGUI(Thewria thewria) {
        ThewriaController controller = new ThewriaController(viewSwitchController);
        ThewriaPageUI thewriaPageUI = new ThewriaPageUI(controller, thewria);
        mainPanel.add(thewriaPageUI, THEWRIA_PAGE_CARD_NAME);
        cardLayout.show(mainPanel,THEWRIA_PAGE_CARD_NAME);
    }


    private void prepareData() throws IOException {
        File foititesFile = new File("foitites.txt");
        File thewriesFile = new File("thewries.txt");
        File kathigitesFile = new File("kathigites.txt");

        foititesFile.createNewFile();
        thewriesFile.createNewFile();
        kathigitesFile.createNewFile();

        PrintWriter foititesOutputStream = new PrintWriter(new FileOutputStream(foititesFile));
        PrintWriter thewriesOutputStream = new PrintWriter(new FileOutputStream(thewriesFile));
        PrintWriter kathigitesOutputStream = new PrintWriter(new FileOutputStream(kathigitesFile));

        xrhstesService = new XrhstesServiceInMemor();
        thewriesService = new ThewriesServiceInMemory();
        ergasthrioService = new ErgasthrioServiceInMemory();

        String[] onomata = {
                "Μαρια", "Νικος","Πετρος","Βασιλης","Ολγα","Αννα"
                ,"Μανωλης","Γιωργος","Φιλιππος","Αλεξανδρος","Ραδιον","Τζεραρ",
                "Τζον","Νατασσα","Ελισαβετ","Ελλη","Εση",
                "Τζουλια"
        };

        String[] epitheta = {
            "Παδαποδουλος/ου","Αριουνουλος/ου","Καθαριος/ου","Αλεγαγλου","Μανουλιδου","Κασιναδρου",
            "Μακρινος/ου","Παλιδος/ου","Παρασκευοπουλος/ου","Ανταμιδης/ου","Αντονιδης/ου","Πετριδης/δου",
                "Αννουλιδης/ου","Ολιρηνος/ου"
        };

        //Dhmiourgia ~1000 foititwn(sto peripou,epeidh an enas foititis tuxh idio onoma xrhsth,aporriptete)
        for (int i = 0; i < 1000; i++) {

            String onoma = onomata[ThreadLocalRandom.current().nextInt(onomata.length)];

            String epitheto = epitheta[ThreadLocalRandom.current().nextInt(epitheta.length)];

            LocalDate birthDate = LocalDate.now().minusYears(18).plusYears(ThreadLocalRandom.current().nextInt(5));

            StringBuilder onomaXrhsth = new StringBuilder();
            StringBuilder kwdikos = new StringBuilder();

            //dhmoiourgia 7-pshfiou onomatos xrhsth
            for (int j = 0; j < 6; j++) {
                onomaXrhsth.append(ThreadLocalRandom.current().nextInt(10));
            }

            //dhmiourgia 7-pshfiou kwdikou
            for (int j = 0; j < 6; j++) {
                kwdikos.append(ThreadLocalRandom.current().nextInt(10));
            }

            xrhstesService.add(new Foititis(onoma, epitheto, birthDate,
                    onomaXrhsth.toString(), kwdikos.toString(), "acdem" + onomaXrhsth.toString() + "@academia.gr"));
        }

        for (Foititis foititis : xrhstesService.getFoitites()) {
            foititesOutputStream.println(foititis.toString());
            foititesOutputStream.println("\n");
        }

        Kathigitis adamidis = new Kathigitis("Παναγιωτης", "Αδαμιδης", LocalDate.now().minusYears(35),
                "88888888", "093909230", "adamidis@academia.gr");

        Kathigitis vitsas = new Kathigitis("Βασιλης", "Βιτσας", LocalDate.now().minusYears(38),
                "77777777", "1023901023", "vitsas@academia.gr");

        Kathigitis ignatios = new Kathigitis("Ιγνατιος", "Δεληγιαννης", LocalDate.now().minusYears(40),
                "66666666", "209910092", "ignatios@academia.gr");

        Kathigitis dervos = new Kathigitis("Δημητριος", "Δερβος", LocalDate.now().minusYears(42),
                "55555555", "201909910275", "dervos@academia.gr");

        Kathigitis diamantaras = new Kathigitis("Κωνσταντινος", "Διαμανταρας", LocalDate.now().minusYears(43),
                "44444444", "300019242", "diamantaras@academia.gr");

        Kathigitis hlioudis = new Kathigitis("Χρηστος", "Ηλιουδης", LocalDate.now().minusYears(45),
                "33333333", "1653452234", "hlioudis@academia.gr");

        Kathigitis kwstoglou = new Kathigitis("Βασιλειος", "Κωστογλου", LocalDate.now().minusYears(46),
                "22222222", "2100990129305", "kwstoglou@academia.gr");

        Kathigitis dhmosthenhs = new Kathigitis("Σταματησ", "Δημοσθενης", LocalDate.now().minusYears(47),
                "11111111", "00929312312", "kwstoglou@academia.gr");

        Kathigitis xatzhmisios = new Kathigitis("Περικλης", "Χατζημισιος", LocalDate.now().minusYears(48),
                "00000000", "14091029401", "xatzimisios@academia.gr");

        xrhstesService.add(adamidis);
        xrhstesService.add(vitsas);
        xrhstesService.add(ignatios);
        xrhstesService.add(dervos);
        xrhstesService.add(diamantaras);
        xrhstesService.add(hlioudis);
        xrhstesService.add(kwstoglou);
        xrhstesService.add(dhmosthenhs);
        xrhstesService.add(xatzhmisios);

        Thewria mathimatikaEna = new Thewria("Μαθηματικα Ι", xatzhmisios, Eksamhno.A);
        Thewria domhmenosProgrammatismos = new Thewria("Δομημενος Προγραμματισμος Ι", dhmosthenhs, Eksamhno.A);
        Thewria eisagwghSthnEpistimhYpologistwn = new Thewria("Εισαγωγη Στην Επιστημη των Υπολογιστων", hlioudis, Eksamhno.A);
        Thewria antikeimenostrefhsProgrammatismos = new Thewria("Αντικειμενοστρεφής Προγραμματισμός", dhmosthenhs, Eksamhno.B);
        Thewria domesDedomenwn = new Thewria("Δομές Δεδομένων και Ανάλυση Αλγορίθμων", dhmosthenhs, Eksamhno.B);
        Thewria thlepikoinwniakaSusthmata = new Thewria("Τηλεπικοινωνιακά Συστήματα", vitsas, Eksamhno.C);
        Thewria thewriaPithanotitwn = new Thewria("Θεωρία Πιθανοτήτων και Στατιστική", kwstoglou, Eksamhno.D);
        Thewria eisagwghStaLeitourgikaSusthmata = new Thewria("Εισαγωγή στα Λειτουργικά Συστήματα", xatzhmisios, Eksamhno.D);
        Thewria allhlepidrashAnthrouMixanhs = new Thewria("Αλληλεπίδραση Ανθρώπου-Μηχανής", ignatios, Eksamhno.E);
        Thewria mikroelegktes = new Thewria("Μικροελεγκτές", diamantaras, Eksamhno.E);
        Thewria texnuthNohmosunhDedomenwn = new Thewria("Τεχνητή Νοημοσύνην Δεδομένων", adamidis, Eksamhno.F);
        Thewria enswmatwmenaSusthmata = new Thewria("Ενσωματωμένα Συστήματα", dervos, Eksamhno.F);
        Thewria optikesEpikoinwnies = new Thewria("Οπτοηλεκτρονική και Οπτικές Επικοινωνίες", vitsas, Eksamhno.F);
        Thewria diktuaYpologistwn = new Thewria("Δίκτυα Υπολογιστών", ignatios, Eksamhno.G);
        Thewria susthmataAutomatouElegxou = new Thewria("Συστήματα Αυτομάτου Ελέγχου", ignatios, Eksamhno.G);
        Thewria programmatizomenoiElegktes = new Thewria("Προγραμματιζόμενοι Λογικοί Ελεγκτές", diamantaras, Eksamhno.G);
        Thewria mhxanikhLogismikou = new Thewria("Μηχανική Λογισμικού", ignatios, Eksamhno.G);
        Thewria texnologiaVasewnDedomenwn = new Thewria("Τεχνολογία Βάσεων Δεδομένων", dervos, Eksamhno.G);
        Thewria asfaleiaPlhroforiakwnSusthmatwn = new Thewria("Ασφάλεια Πληροφοριακών Συστημάτων", hlioudis, Eksamhno.H);
        Thewria organwshEksorhkshPlhroforias = new Thewria("Οργάνωση Δεδομένων και Εξόρυξη Πληροφορίας", hlioudis, Eksamhno.H);
        Thewria asurmataDiktua = new Thewria("Ασύρματα Δίκτυα", vitsas, Eksamhno.H);

        thewriesService.add(mathimatikaEna);
        thewriesService.add(domhmenosProgrammatismos);
        thewriesService.add(eisagwghSthnEpistimhYpologistwn);
        thewriesService.add(antikeimenostrefhsProgrammatismos);
        thewriesService.add(domesDedomenwn);
        thewriesService.add(thlepikoinwniakaSusthmata);
        thewriesService.add(thewriaPithanotitwn);
        thewriesService.add(eisagwghStaLeitourgikaSusthmata);
        thewriesService.add(allhlepidrashAnthrouMixanhs);
        thewriesService.add(mikroelegktes);
        thewriesService.add(texnuthNohmosunhDedomenwn);
        thewriesService.add(enswmatwmenaSusthmata);
        thewriesService.add(optikesEpikoinwnies);
        thewriesService.add(diktuaYpologistwn);
        thewriesService.add(susthmataAutomatouElegxou);
        thewriesService.add(programmatizomenoiElegktes);
        thewriesService.add(mhxanikhLogismikou);
        thewriesService.add(texnologiaVasewnDedomenwn);
        thewriesService.add(asfaleiaPlhroforiakwnSusthmatwn);
        thewriesService.add(organwshEksorhkshPlhroforias);
        thewriesService.add(asurmataDiktua);

        Kathigitis[] kathigites = xrhstesService.getKathigites().toArray(new Kathigitis[0]);
        Thewria[] thewries = thewriesService.getAll().toArray(new Thewria[0]);

        for (Thewria thewria : thewries) {
            for (int i = 0; i < ThreadLocalRandom.current().nextInt(7); i++) {
                Kathigitis kathigitisErgasthriou = kathigites[ThreadLocalRandom.current().nextInt(kathigites.length)];
                Ergasthrio ergasthrio = new Ergasthrio(thewria.getOnomaMathimatos() + " ε" + i, kathigitisErgasthriou, thewria);
                thewria.addErgasthrio(ergasthrio);
            }
            thewriesOutputStream.println(thewria.toString()+"\n");
        }

        for (Kathigitis kathigitis : kathigites) {
            kathigitesOutputStream.println(kathigites.toString()+"\n");
        }

        foititesOutputStream.flush();
        thewriesOutputStream.flush();
        kathigitesOutputStream.flush();

        foititesOutputStream.close();
        thewriesOutputStream.close();
        kathigitesOutputStream.close();


    }



}
