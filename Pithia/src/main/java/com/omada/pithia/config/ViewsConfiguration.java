package com.omada.pithia.config;

import com.omada.pithia.service.ErgasthriaService;
import com.omada.pithia.service.ThewriesService;
import com.omada.pithia.service.XrhstesService;
import com.omada.pithia.ui.controller.*;
import com.omada.pithia.ui.view.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ServicesConfiguration.class})
@Configuration
@ComponentScan("com.omada.pithia.ui")
public class ViewsConfiguration {

    @Bean
    public ViewController viewController(Pithia pithia){
        return new ViewController(pithia);
    }

    @Bean
    public GeneralServiceController generalServiceController(ErgasthriaService ergasthriaService,
                                                             ThewriesService thewriesService,
                                                             XrhstesService xrhstesService) {
        return new GeneralServiceController(ergasthriaService,thewriesService, xrhstesService);
    }

    @Bean
    public LoginController loginController(ViewController viewController, XrhstesService xrhstesService){
        return new LoginController(viewController,xrhstesService);
    }

    @Bean
    public LoginView loginView(LoginController controller){
        return new LoginView(controller);
    }

    @Bean
    public ThewriesController thewriesController(ThewriesService thewriesService,ViewController viewController,
                                                 XrhstesService xrhstesService) {
        return new ThewriesController(viewController,thewriesService, xrhstesService);
    }

    @Bean
    public ErgasthriaController ergasthriaController(ErgasthriaService ergasthriaService,ViewController viewController,
                                                     XrhstesService xrhstesService) {
        return new ErgasthriaController(viewController, ergasthriaService, xrhstesService);
    }

    @Bean
    public ProsthikiMathimatosController prosthikiMathimatosController(ViewController viewController){
        return new ProsthikiMathimatosController(viewController);
    }

    @Bean
    public ProsthikiMathimatosView prosthikiMathimatosView(ProsthikiMathimatosController controller) {
        return new ProsthikiMathimatosView(controller);
    }

    @Bean
    public ProsthikiThewriasController prosthikiThewriasController(ViewController viewController,
                                                                   GeneralServiceController generalServiceController){
        return new ProsthikiThewriasController(viewController, generalServiceController);
    }

    @Bean
    public ProsthikiThewriasView prosthikiThewriasView(ProsthikiThewriasController controller) {
        return new ProsthikiThewriasView(controller);
    }

    @Bean
    public ProsthikiErgasthriouController prosthikiErgasthriouController(
            ViewController viewController,
            GeneralServiceController generalServiceController){
        return new ProsthikiErgasthriouController(viewController, generalServiceController);
    }

    @Bean
    public ProsthikiErgasthriouView prosthikiErgasthriouView(ProsthikiErgasthriouController controller){
        return new ProsthikiErgasthriouView(controller);
    }


    @Bean
    public DhmiourgiaFoititwnController dhmiourgiaFoititwnController(ViewController viewController,
                                                                     XrhstesService xrhstesService){
        return new DhmiourgiaFoititwnController(viewController, xrhstesService);
    }

    @Bean
    public DhmiourgiaFoititwnView dhmiourgiaFoititwnView(DhmiourgiaFoititwnController controller) {
        return new DhmiourgiaFoititwnView(controller);
    }

    @Bean
    public MathimataKathigitiController mathimataKathigitiController(ViewController viewController){
        return new MathimataKathigitiController(viewController);
    }

    @Bean
    public MathimataKathigitiView mathimataKathigitiView(MathimataKathigitiController controller) {
        return new MathimataKathigitiView(controller);
    }

    @Bean
    public KatastashFoitithController katastashFoitithController(ViewController viewController,
                                                                 XrhstesService xrhstesService){
        return new KatastashFoitithController(viewController,xrhstesService);
    }

    @Bean
    public DhlwshMathimatwnController dhlwshMathimatwnController(ViewController viewController,
                                                                 XrhstesService xrhstesService,
                                                                 ThewriesService thewriesService){
        return new DhlwshMathimatwnController(viewController,xrhstesService,thewriesService);
    }

    @Bean
    public LanguageController languageController(ViewController viewController){
        return new LanguageController(viewController);
    }

    @Bean
    public LanguageView languageView(LanguageController controller) {
        return new LanguageView(controller);
    }


}
