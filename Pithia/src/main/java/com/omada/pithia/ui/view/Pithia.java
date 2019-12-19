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

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Pithia extends JFrame {

    private final XrhstesService xrhstesService;
    private final ThewriesService thewriesService;
    private final ErgasthrioService ergasthrioService;

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
    private static final String ERGASTHRIO_PAGE_CARD_NAME = "ERGASTHRIO_PAGE";
    private static final String PROAPAITOUMENA_PAGE_CARD_NAME = "PROAPAITOUMENA_PAGE";
    private static final String EISAGWGH_VATHMOLOGIAS_THEWRIA = "EISAGWGH_VATHMOLOGIAS_THEWRIAS_PAGE";
    private static final String EISAGWGH_VATHMOLOGIAS_ERGASTHRIO = "EISAGWGH_VATHMOLOGIAS_ERGASTHRIO_PAGE";
    private static final String PROSTHIKI_FOITITWN_STO_ERGASTHRIO = "PROSTHIKI_FOITITWN_STO_ERGASTHRIO_PAGE";
    private static final String DIAXEIRISH_APOUSIWN = "DIAXEIRISH_APOUSIWN_PAGE";
    private static final String PROSTHIKI_ERGASTHRIOU = "PROSTHIKI_ERGASTHRIOU";
    private static final String PROSTHIKI_THEWRIAS = "PROSTHIKI_THEWRIAS";

    private final ParagwghFoititwnPageUI paragwghFoititwnPageUI;
    private final LoginPageUI loginPageUI;
    private final MathimataMouPageUI mathimataMouPageUI;
    private final ProsthikiMathimatosPageUI prosthikiMathimatosPageUI;

    private final ViewController viewController;
    private final MathimataMouController mathimataMouController;
    private final ParagwghFoititwnController paragwghFoititwnController;
    private final LoginController loginController;
    private final ThewriesController thewriesController;
    private final ErgasthriaController ergasthriaController;
    private final ProsthikiMathimatosController prosthikiMathimatosController;
    private final ProsthikiErgasthriouController prosthikiErgasthriouController;
    private final GeneralServiceController generalServiceController;
    private final ProsthikiThewriasController prosthikiThewriasController;

    private final CardLayout cardLayout = new CardLayout();

    private final JPanel mainPanel = new JPanel();

    private final MyAction backToHomeAction;


    public Pithia(XrhstesService xrhstesService, ThewriesService thewriesService, ErgasthrioService ergasthrioService) {
        this.xrhstesService = xrhstesService;
        this.thewriesService = thewriesService;
        this.ergasthrioService = ergasthrioService;

        this.viewController = new ViewController(this);
        this.mathimataMouController = new MathimataMouController(viewController);
        this.loginController = new LoginController(viewController,xrhstesService);
        this.thewriesController = new ThewriesController(viewController,thewriesService,xrhstesService);
        this.ergasthriaController = new ErgasthriaController(viewController,ergasthrioService,xrhstesService);
        this.paragwghFoititwnController = new ParagwghFoititwnController(viewController, xrhstesService);
        this.prosthikiMathimatosController = new ProsthikiMathimatosController(viewController);
        this.generalServiceController = new GeneralServiceController(ergasthrioService,thewriesService,xrhstesService);
        this.prosthikiErgasthriouController = new ProsthikiErgasthriouController(viewController, generalServiceController);
        this.prosthikiThewriasController = new ProsthikiThewriasController(viewController,generalServiceController);
        this.backToHomeAction = this::switchToHomePageGUI;

        this.loginPageUI = new LoginPageUI(loginController);
        this.paragwghFoititwnPageUI = new ParagwghFoititwnPageUI(paragwghFoititwnController, backToHomeAction);
        this.mathimataMouPageUI = new MathimataMouPageUI(mathimataMouController, backToHomeAction);
        this.prosthikiMathimatosPageUI = new ProsthikiMathimatosPageUI(prosthikiMathimatosController);

    }


    public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException {
        XrhstesService xrhstesService = new XrhstesServiceInMemor();
        ThewriesService thewriesService = new ThewriesServiceInMemory();
        ErgasthrioService ergasthrioService = new ErgasthrioServiceInMemory();
        Pithia pithia = new Pithia(xrhstesService,thewriesService,ergasthrioService);
        pithia.start();
    }

    public void start() throws InvocationTargetException, InterruptedException, IOException {
        prepareData();

        SwingUtilities.invokeAndWait(() -> {

            mainPanel.setLayout(cardLayout);

            mainPanel.add(loginPageUI, LOGIN_PAGE_CARD_NAME);
            mainPanel.add(paragwghFoititwnPageUI, FOITITES_PAGE_CARD_NAME);
            mainPanel.add(mathimataMouPageUI, MATHIMATA_MOU_PAGE_CARD_NAME);
            mainPanel.add(prosthikiMathimatosPageUI, PROSTHIKI_MATHIMATOS_PAGE_CARD_NAME);

            this.getContentPane().setBackground(GeneralStyle.DARK_COLOR);
            this.setContentPane(mainPanel);
            this.setSize(500, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.pack();
        });
    }

    public void switchToHomePageGUI() {
        HomePageUI view = new HomePageUI(viewController,xrhstesService);
        mainPanel.add(view, HOME_PAGE_CARD_NAME);
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
        LogariasmosController controller = new LogariasmosController(viewController,xrhstesService);
        LogariasmosUI view = new LogariasmosUI(controller);
        mainPanel.add(view, LOGARIASMOS_MOU_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, LOGARIASMOS_MOU_PAGE_CARD_NAME);
    }

    public void logout() {
        cardLayout.show(mainPanel, LOGIN_PAGE_CARD_NAME);
    }

    public void switchToThewriesGUI() {
        ThewriesPageUI thewriesPageUI = new ThewriesPageUI(thewriesController);
        mainPanel.add(thewriesPageUI, THEWRIES_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, THEWRIES_PAGE_CARD_NAME);

    }

    public void switchToErgasthriaGUI() {
        ErgasthriaPageUI ergasthriaPageUI = new ErgasthriaPageUI(ergasthriaController);
        mainPanel.add(ergasthriaPageUI, ERGASTHRIA_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, ERGASTHRIA_PAGE_CARD_NAME);
    }

    public void switchToThewriaGUI(Thewria thewria) {
        ThewriaController controller = new ThewriaController(viewController,thewria);
        ThewriaPageUI view = new ThewriaPageUI(controller);
        mainPanel.add(view, THEWRIA_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, THEWRIA_PAGE_CARD_NAME);
    }

    public void switchToErgasthrioGUI(Ergasthrio ergasthrio) {
        ErgasthrioController controller = new ErgasthrioController(viewController,ergasthrio);
        ErgasthrioPageUI view = new ErgasthrioPageUI(controller);
        mainPanel.add(view, ERGASTHRIO_PAGE_CARD_NAME);
        cardLayout.show(mainPanel, ERGASTHRIO_PAGE_CARD_NAME);
    }


    public void switchToProsthikiProapaitoumenou(Thewria thewria) {
        ProapaitoumenaController controller = new ProapaitoumenaController(viewController,thewria,thewriesService);
        ProapaitoumenaPageUI view = new ProapaitoumenaPageUI(controller);
        mainPanel.add(view, PROAPAITOUMENA_PAGE_CARD_NAME);
        cardLayout.show(mainPanel,PROAPAITOUMENA_PAGE_CARD_NAME);
    }

    public void switchToEisagwghVathmologias(Thewria thewria) {
        EisagwghVathmologiasThewriasController controller = new EisagwghVathmologiasThewriasController(viewController, thewria);
        EisagwghVathmologiasThewriasPageUI view = new EisagwghVathmologiasThewriasPageUI(controller);

        mainPanel.add(view, EISAGWGH_VATHMOLOGIAS_THEWRIA);
        cardLayout.show(mainPanel, EISAGWGH_VATHMOLOGIAS_THEWRIA);
    }

    public void switchToEisagwghVathmologias(Ergasthrio ergasthrio) {
        EisagwghVathmologiasErgasthrioController controller = new EisagwghVathmologiasErgasthrioController(viewController, ergasthrio);
        EisagwghVathmologiasErgasthrioPageUI view = new EisagwghVathmologiasErgasthrioPageUI(controller);

        mainPanel.add(view, EISAGWGH_VATHMOLOGIAS_ERGASTHRIO);
        cardLayout.show(mainPanel, EISAGWGH_VATHMOLOGIAS_ERGASTHRIO);
    }

    public void switchToProsthikiFoititwnStoErgasthrio(Ergasthrio ergasthrio, Thewria thewria) {
        ProsthikiFoititwnStoErgasthrioController controller
                = new ProsthikiFoititwnStoErgasthrioController(viewController, thewria, ergasthrio);

        ProsthikiFoititwnStoErgasthrioUI view = new ProsthikiFoititwnStoErgasthrioUI(controller);

        mainPanel.add(view,PROSTHIKI_FOITITWN_STO_ERGASTHRIO);
        cardLayout.show(mainPanel, PROSTHIKI_FOITITWN_STO_ERGASTHRIO);
    }


    public void switchToDiaxeirishApousiwn(Ergasthrio ergasthrio) {
        DiaxeirishApousiwnController controller = new DiaxeirishApousiwnController(viewController,ergasthrio);

        DiaxeirishApousiwnPageUI view = new DiaxeirishApousiwnPageUI(controller);

        mainPanel.add(view, DIAXEIRISH_APOUSIWN);
        cardLayout.show(mainPanel,DIAXEIRISH_APOUSIWN);
    }


    public void switchToProsthikiErgasthriou() {
        ProsthikiErgasthriouPageUI view = new ProsthikiErgasthriouPageUI(prosthikiErgasthriouController);
        mainPanel.add(view, PROSTHIKI_ERGASTHRIOU);
        cardLayout.show(mainPanel, PROSTHIKI_ERGASTHRIOU);
    }

    public void switchToProsthikiThewrias() {
        ProsthikiThewriasPageUI view = new ProsthikiThewriasPageUI(prosthikiThewriasController);
        mainPanel.add(view, PROSTHIKI_THEWRIAS);
        cardLayout.show(mainPanel, PROSTHIKI_THEWRIAS);
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
                ergasthrioService.add(ergasthrio);
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

        Xrhsths admin = new Xrhsths("ADMIN", "ADMIN", LocalDate.now().minusYears(20),
                "admin", "admin", "admin@academia.gr");
        admin.addRolo(Rolos.DIAXEIRISTIS);

        xrhstesService.add(admin);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this,message,"Message",JOptionPane.PLAIN_MESSAGE);
    }



}
