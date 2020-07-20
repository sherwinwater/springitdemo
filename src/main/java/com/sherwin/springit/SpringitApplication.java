package com.sherwin.springit;

import com.sherwin.springit.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

//    @Autowired
//    private SpringitProperties springitProperties;
//
//    @Autowired
//    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

//    @Bean
//    @Profile("dev")
//    CommandLineRunner runner(){
//        return args -> {
//            System.out.println("only in dev");
//            System.out.println("Welcome message: "+springitProperties.getWelcomeMsg());
//
//            String [] beans = applicationContext.getBeanDefinitionNames();
//            System.out.println("all bean names in application context.");
//            Arrays.sort(beans);
//            for(String bean:beans){
//                System.out.println(bean);
//            }
//            System.out.println(beans.length);
//        };
//    }


    @Bean
    CommandLineRunner runner(){
        return args -> {
          log.error("CommandLineRunner.run();");
          log.warn("CommandLineRunner.run();");
          log.info("CommandLineRunner.run();");
          log.debug("CommandLineRunner.run();");
          log.trace("CommandLineRunner.run();");
        };
    }

}
