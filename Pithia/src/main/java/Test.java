
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Barracuda
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(com.omada.pithia.config.Configurus.class);
        
        context.getBean("kathigitisService");
    }
}
