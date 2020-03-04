package com.omada.pithia.ui;

import com.omada.pithia.config.ServicesConfiguration;
import com.omada.pithia.config.ViewsConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StartPithia {

    public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ViewsConfiguration.class);
    }

}
