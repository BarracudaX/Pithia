package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.model.xrhstes.Rolos;
import com.omada.pithia.model.xrhstes.Xrhsths;
import com.omada.pithia.service.*;
import com.omada.pithia.ui.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Pithia extends JFrame {

    private final XrhstesService xrhstesService;
    private final ThewriesService thewriesService;
    private final ErgasthriaService ergasthriaService;

    private static final String LANGUAGE_PAGE_CARD_NAME = "LANGUAGE_PAGE";
    private static final String LOGIN_PAGE_CARD_NAME = "LOGIN_PAGE";
    private static final String HOME_PAGE_CARD_NAME = "HOME_PAGE";
    private static final String MATHIMATA_MOU_PAGE_CARD_NAME = "MATHIMATA_MOU_PAGE";
    private static final String PROSTHIKI_MATHIMATOS_PAGE_CARD_NAME = "PROSTHIKI_MATHIMATOS_PAGE";
    private static final String KATASTASH_PAGE_CARD_NAME = "KATSTASH_PAGE";
    private static final String DHLWSH_MATHIMATWN_PAGE_CARD_NAME = "DHLWSH_MATHIMATWN_PAGE";
    private static final String FOITITES_PAGE_CARD_NAME = "FOITITES_PAGE";
    private static final String LOGARIASMOS_MOU_PAGE_CARD_NAME = "LOGARIASMOS_MOU_PAGE";
    private static final String THEWRIES_PAGE_CARD_NAME = "THEWRIES_PAGE";
    private static final String ERGASTHRIA_PAGE_CARD_NAME = "ERGASTHRIA_PAGE";
    private static final String THEWRIA_PAGE_CARD_NAME = "THEWRIA_PAGE";
    private static final String ERGASTHRIO_PAGE_CARD_NAME = "ERGASTHRIO_PAGE";
    private static final String PROAPAITOUMENA_PAGE_CARD_NAME = "PROAPAITOUMENA_PAGE";
    private static final String EISAGWGH_VATHMOLOGIAS_THEWRIA = "EISAGWGH_VATHMOLOGIAS_THEWRIAS_PAGE";
    private static final String EISAGWGH_VATHMOLOGIAS_ERGASTHRIO = "EISAGWGH_VATHMOLOGIAS_ERGASTHRIO_PAGE";
    private static final String PROSTHIKI_FOITITWN_STO_ERGASTHRIO = "PROSTHIKI_FOITITWN_STO_ERGASTHRIO_PAGE";
    private static final String DIAXEIRISH_APOUSIWN = "DIAXEIRISH_APOUSIWN_PAGE";
    private static final String PROSTHIKI_ERGASTHRIOU = "PROSTHIKI_ERGASTHRIOU";
    private static final String DHLWSH_ALGORITHMOU_VIEW = "DHLWSH_ALGORITHMOU_VIEW";
    private static final String PROSTHIKI_THEWRIAS = "PROSTHIKI_THEWRIAS";

    private LanguageView languageView;

    private ViewController viewController;
    private MathimataKathigitiController mathimataKathigitiController;
    private DhmiourgiaFoititwnController dhmiourgiaFoititwnController;
    private LoginController loginController;
    private ThewriesController thewriesController;
    private ErgasthriaController ergasthriaController;
    private ProsthikiMathimatosController prosthikiMathimatosController;
    private ProsthikiErgasthriouController prosthikiErgasthriouController;
    private GeneralServiceController generalServiceController;
    private ProsthikiThewriasController prosthikiThewriasController;
    private KatastashFoitithController katastashFoitithController;
    private DhlwshMathimatwnController dhlwshMathimatwnController;
    private LanguageController languageController;

    private final CardLayout cardLayout = new CardLayout();

    private final JPanel mainPanel = new JPanel();

    private Pithia(XrhstesService xrhstesService, ThewriesService thewriesService, ErgasthriaService ergasthriaService) {
        this.xrhstesService = xrhstesService;
        this.thewriesService = thewriesService;
        this.ergasthriaService = ergasthriaService;
    }

    @PostConstruct
    public void start() throws InvocationTargetException, InterruptedException, IOException {
        prepareData();

        SwingUtilities.invokeAndWait(() -> {

            mainPanel.setLayout(cardLayout);

            mainPanel.add(languageView, LANGUAGE_PAGE_CARD_NAME);

            this.getContentPane().setBackground(GeneralStyle.DARK_COLOR);
            this.setContentPane(mainPanel);
            this.setSize(500, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.pack();
        });
    }

    public void switchToHomePageGUI() {
        ArxikhView view = new ArxikhView(viewController,xrhstesService);
        mainPanel.add(view, HOME_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, HOME_PAGE_CARD_NAME);
    }

    public void switchToMathimataKathigitiView() {
        cardLayout.show(mainPanel, MATHIMATA_MOU_PAGE_CARD_NAME);
    }

    public void switchToProsthikiMathimatosView() {
        cardLayout.show(mainPanel, PROSTHIKI_MATHIMATOS_PAGE_CARD_NAME);
    }

    public void switchToKatastashView() {
        KatastashFoitithView view = new KatastashFoitithView(katastashFoitithController);
        mainPanel.add(view, KATASTASH_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, KATASTASH_PAGE_CARD_NAME);
    }

    public void switchToDhlwshMathimatwnView() {
        DhlwshMathimatwnView view = new DhlwshMathimatwnView(dhlwshMathimatwnController);
        mainPanel.add(view, DHLWSH_MATHIMATWN_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, DHLWSH_MATHIMATWN_PAGE_CARD_NAME);
    }

    public void switchToDhmiourgiaFoititwnView() {
        cardLayout.show(mainPanel, FOITITES_PAGE_CARD_NAME);
    }

    public void switchToLogariasmosView() {
        LogariasmosController controller = new LogariasmosController(viewController,xrhstesService);
        LogariasmosView view = new LogariasmosView(controller);
        mainPanel.add(view, LOGARIASMOS_MOU_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, LOGARIASMOS_MOU_PAGE_CARD_NAME);
    }

    public void logout() {
        cardLayout.show(mainPanel, LOGIN_PAGE_CARD_NAME);
    }

    public void switchToThewriesView() {
        ThewriesView thewriesView = new ThewriesView(thewriesController);
        mainPanel.add(thewriesView, THEWRIES_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, THEWRIES_PAGE_CARD_NAME);

    }

    public void switchToErgasthriaView() {
        ErgasthriaView ergasthriaView = new ErgasthriaView(ergasthriaController);
        mainPanel.add(ergasthriaView, ERGASTHRIA_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, ERGASTHRIA_PAGE_CARD_NAME);
    }

    public void switchToThewriaView(Thewria thewria) {
        ThewriaController controller = new ThewriaController(viewController,thewria);
        ThewriaView view = new ThewriaView(controller);
        mainPanel.add(view, THEWRIA_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, THEWRIA_PAGE_CARD_NAME);
    }

    public void switchToErgasthrioView(Ergasthrio ergasthrio) {
        ErgasthrioController controller = new ErgasthrioController(viewController,ergasthrio);
        ErgasthrioView view = new ErgasthrioView(controller);
        mainPanel.add(view, ERGASTHRIO_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, ERGASTHRIO_PAGE_CARD_NAME);
    }

    public void switchToProsthikiProapaitoumenwnView(Thewria thewria) {
        ProsthikiProapaitoumenwnController controller = new ProsthikiProapaitoumenwnController(viewController,thewria,thewriesService);
        ProsthikiProapaitoumenwnView view = new ProsthikiProapaitoumenwnView(controller);
        mainPanel.add(view, PROAPAITOUMENA_PAGE_CARD_NAME);
        cardLayout.show(mainPanel,PROAPAITOUMENA_PAGE_CARD_NAME);
    }

    public void switchToEisagwghVathmologiasThewriasView(Thewria thewria) {
        EisagwghVathmologiasThewriasController controller = new EisagwghVathmologiasThewriasController(viewController, thewria);
        EisagwghVathmologiasThewriasView view = new EisagwghVathmologiasThewriasView(controller);

        mainPanel.add(view, EISAGWGH_VATHMOLOGIAS_THEWRIA);
        cardLayout.show(mainPanel, EISAGWGH_VATHMOLOGIAS_THEWRIA);
    }

    public void switchEisagwghVathmologiasErgasthriouView(Ergasthrio ergasthrio) {
        EisagwghVathmologiasErgasthriouController controller = new EisagwghVathmologiasErgasthriouController(viewController, ergasthrio);
        EisagwghVathmologiasErgasthriouView view = new EisagwghVathmologiasErgasthriouView(controller);

        mainPanel.add(view, EISAGWGH_VATHMOLOGIAS_ERGASTHRIO);
        cardLayout.show(mainPanel, EISAGWGH_VATHMOLOGIAS_ERGASTHRIO);
    }

    public void switchToProsthikiFoititwnStoErgasthrioView(Ergasthrio ergasthrio, Thewria thewria) {
        ProsthikiFoititwnStoErgasthrioController controller
                = new ProsthikiFoititwnStoErgasthrioController(viewController, thewria, ergasthrio);

        ProsthikiFoititwnStoErgasthrioView view = new ProsthikiFoititwnStoErgasthrioView(controller);

        mainPanel.add(view,PROSTHIKI_FOITITWN_STO_ERGASTHRIO);
        cardLayout.show(mainPanel, PROSTHIKI_FOITITWN_STO_ERGASTHRIO);
    }

    public void switchToDiaxeirishApousiwnView(Ergasthrio ergasthrio) {
        DiaxeirishApousiwnController controller = new DiaxeirishApousiwnController(viewController,ergasthrio);

        DiaxeirishApousiwnView view = new DiaxeirishApousiwnView(controller);

        mainPanel.add(view, DIAXEIRISH_APOUSIWN);
        cardLayout.show(mainPanel,DIAXEIRISH_APOUSIWN);
    }

    public void switchToProsthikiErgasthriouView() {
        ProsthikiErgasthriouView view = new ProsthikiErgasthriouView(prosthikiErgasthriouController);
        mainPanel.add(view, PROSTHIKI_ERGASTHRIOU);
        cardLayout.show(mainPanel, PROSTHIKI_ERGASTHRIOU);
    }

    public void switchToProsthikiThewriasView() {
        ProsthikiThewriasView view = new ProsthikiThewriasView(prosthikiThewriasController);
        mainPanel.add(view, PROSTHIKI_THEWRIAS);
        cardLayout.show(mainPanel, PROSTHIKI_THEWRIAS);
    }

    public void switchToDhlwshAlgorithmou(Thewria thewria) {
        DhlwshAlgorithmouController controller = new DhlwshAlgorithmouController(viewController,thewria);
        DhlwsiAlgorithmouView view = new DhlwsiAlgorithmouView(controller);

        mainPanel.add(view, DHLWSH_ALGORITHMOU_VIEW);
        cardLayout.show(mainPanel,DHLWSH_ALGORITHMOU_VIEW);
    }

    public void switchToLoginView() {
        LoginView loginView = new LoginView(loginController);
        ProsthikiMathimatosView prosthikiMathimatosView = new ProsthikiMathimatosView(prosthikiMathimatosController);
        DhmiourgiaFoititwnView dhmiourgiaFoititwnView = new DhmiourgiaFoititwnView(dhmiourgiaFoititwnController);
        MathimataKathigitiView mathimataKathigitiView = new MathimataKathigitiView(mathimataKathigitiController);

        mainPanel.add(loginView, LOGIN_PAGE_CARD_NAME);
        mainPanel.add(dhmiourgiaFoititwnView, FOITITES_PAGE_CARD_NAME);
        mainPanel.add(mathimataKathigitiView, MATHIMATA_MOU_PAGE_CARD_NAME);
        mainPanel.add(prosthikiMathimatosView, PROSTHIKI_MATHIMATOS_PAGE_CARD_NAME);
        cardLayout.show(mainPanel,LOGIN_PAGE_CARD_NAME);
    }


    public void switchToLanguageView() {
        LoginView loginView = new LoginView(loginController);
        ProsthikiMathimatosView prosthikiMathimatosView = new ProsthikiMathimatosView(prosthikiMathimatosController);
        DhmiourgiaFoititwnView dhmiourgiaFoititwnView = new DhmiourgiaFoititwnView(dhmiourgiaFoititwnController);
        MathimataKathigitiView mathimataKathigitiView = new MathimataKathigitiView(mathimataKathigitiController);

        mainPanel.add(loginView, LOGIN_PAGE_CARD_NAME);
        mainPanel.add(dhmiourgiaFoititwnView, FOITITES_PAGE_CARD_NAME);
        mainPanel.add(mathimataKathigitiView, MATHIMATA_MOU_PAGE_CARD_NAME);
        mainPanel.add(prosthikiMathimatosView, PROSTHIKI_MATHIMATOS_PAGE_CARD_NAME);
        cardLayout.show(mainPanel,LANGUAGE_PAGE_CARD_NAME);
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

            LocalDate birthDate = LocalDate.now().minusYears(18).minusYears(ThreadLocalRandom.current().nextInt(5));

            StringBuilder onomaXrhsth = new StringBuilder();
            StringBuilder kwdikos = new StringBuilder();

            //dhmoiourgia 7-pshfiou onomatos xrhsth
            for (int j = 0; j < 8; j++) {
                onomaXrhsth.append(ThreadLocalRandom.current().nextInt(10));
            }

            //dhmiourgia 7-pshfiou kwdikou
            for (int j = 0; j < 8; j++) {
                kwdikos.append(ThreadLocalRandom.current().nextInt(10));
            }

            xrhstesService.add(new Foititis(onoma, epitheto, birthDate,
                    onomaXrhsth.toString(), kwdikos.toString(), "acdem" + onomaXrhsth.toString() + "@academia.gr"));
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

        Kathigitis dhmosthenhs = new Kathigitis("Σταματης", "Δημοσθενης", LocalDate.now().minusYears(47),
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
        Foititis[] foitites = xrhstesService.getFoitites().toArray(new Foititis[0]);
        for (Thewria thewria : thewries) {
            //prosthiki random arithmou ergasthriwn
            for (int i = 0; i < ThreadLocalRandom.current().nextInt(7); i++) {
                Kathigitis kathigitisErgasthriou = kathigites[ThreadLocalRandom.current().nextInt(kathigites.length)];
                Ergasthrio ergasthrio = new Ergasthrio(thewria.getOnomaMathimatos() + " ε" + i, kathigitisErgasthriou, thewria);
                ergasthriaService.add(ergasthrio);
                thewria.addErgasthrio(ergasthrio);
            }

            int arithmosFoithtwn = ThreadLocalRandom.current().nextInt(foitites.length / 2);
            for (int y = 0; y < arithmosFoithtwn; y++) {
                thewria.addFoititi(foitites[ThreadLocalRandom.current().nextInt(foitites.length)]);
            }
            thewriesOutputStream.println(thewria.toString()+"\n");
        }

        for (Thewria thewria : thewries) {

            if (thewria.getErgasthria().size() == 0 || thewria.getFoitites().size() == 0) {
                continue;
            }

            Ergasthrio[] ergasthria = thewria.getErgasthria().toArray(new Ergasthrio[0]);

            Foititis[] foititesThewrias = Arrays.copyOf(thewria.getFoitites().toArray(new Foititis[0]),
                    ThreadLocalRandom.current().nextInt(thewria.getFoitites().size()));

            for (Foititis foititis : foititesThewrias) {
                thewria.addFoititiStoErgasthrio(foititis,ergasthria[ThreadLocalRandom.current().nextInt(ergasthria.length)]);
            }

        }

        for (Kathigitis kathigitis : kathigites) {
            kathigitesOutputStream.println(kathigitis.toString()+"\n");
        }

        for (Foititis foititis : foitites) {
            foititesOutputStream.println(foititis.toString());
            foititesOutputStream.println("\n");
        }

        foititesOutputStream.flush();
        thewriesOutputStream.flush();
        kathigitesOutputStream.flush();

        foititesOutputStream.close();
        thewriesOutputStream.close();
        kathigitesOutputStream.close();

        Xrhsths admin = new Xrhsths("ADMIN1234567", "ADMIN1234567", LocalDate.now().minusYears(20),
                "ADMIN1234567", "ADMIN1234567", "admin@academia.gr");
        admin.addRolo(Rolos.DIAXEIRISTIS);

        xrhstesService.add(admin);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this,message,"Message",JOptionPane.PLAIN_MESSAGE);
    }

    public int requestForDialogBox(){
             int answer =    JOptionPane.showConfirmDialog(this,"Θελετε να αποθηκευθει;","Ναι",0,JOptionPane.YES_NO_OPTION);
             return answer;
    }

//    SETTERS

    @Autowired
    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    @Autowired
    public void setMathimataKathigitiController(MathimataKathigitiController mathimataKathigitiController) {
        this.mathimataKathigitiController = mathimataKathigitiController;
    }

    @Autowired
    public void setDhmiourgiaFoititwnController(DhmiourgiaFoititwnController dhmiourgiaFoititwnController) {
        this.dhmiourgiaFoititwnController = dhmiourgiaFoititwnController;
    }

    @Autowired
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Autowired
    public void setThewriesController(ThewriesController thewriesController) {
        this.thewriesController = thewriesController;
    }

    @Autowired
    public void setErgasthriaController(ErgasthriaController ergasthriaController) {
        this.ergasthriaController = ergasthriaController;
    }

    @Autowired
    public void setProsthikiMathimatosController(ProsthikiMathimatosController prosthikiMathimatosController) {
        this.prosthikiMathimatosController = prosthikiMathimatosController;
    }

    @Autowired
    public void setProsthikiErgasthriouController(ProsthikiErgasthriouController prosthikiErgasthriouController) {
        this.prosthikiErgasthriouController = prosthikiErgasthriouController;
    }

    @Autowired
    public void setGeneralServiceController(GeneralServiceController generalServiceController) {
        this.generalServiceController = generalServiceController;
    }

    @Autowired
    public void setProsthikiThewriasController(ProsthikiThewriasController prosthikiThewriasController) {
        this.prosthikiThewriasController = prosthikiThewriasController;
    }

    @Autowired
    public void setKatastashFoitithController(KatastashFoitithController katastashFoitithController) {
        this.katastashFoitithController = katastashFoitithController;
    }

    @Autowired
    public void setDhlwshMathimatwnController(DhlwshMathimatwnController dhlwshMathimatwnController) {
        this.dhlwshMathimatwnController = dhlwshMathimatwnController;
    }

    @Autowired
    public void setLanguageController(LanguageController languageController) {
        this.languageController = languageController;
    }

    @Autowired
    public void setLanguageView(LanguageView languageView) {
        this.languageView = languageView;
    }

}
