package com.sherwin.springit;

import com.sherwin.springit.config.SpringitProperties;
import com.sherwin.springit.domain.Comment;
import com.sherwin.springit.domain.Link;
import com.sherwin.springit.repository.CommentRepository;
import com.sherwin.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Bean
    CommandLineRunner runner2
            (LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("This is the first blog title soul", "https://courses.danvega.dev/p/spring-boot-2");
            Link link2 = new Link("12 blog title soul", "https://courses.danvega.dev/p/spring-boot-2");
            Link link3 = new Link(" blog title soul", "https://courses.danvega.dev/p/spring-boot-2");
            Link link4 = new Link("This title soul", "https://courses.danvega.dev/p/spring-boot-2");
            linkRepository.save(link);
            linkRepository.save(link2);
            linkRepository.save(link3);
            linkRepository.save(link4);

            Comment comment = new Comment("book2", link);
            commentRepository.save(comment);
            link.addComment(comment);

            System.out.println("add one link--------");

//            Link firstLink = linkRepository.findByTitleContaining("sou");
//            System.out.println(firstLink.getTitle());

//            ArrayList<Link> links = linkRepository.findAllByTitleContaining("sou");
            List<Link> links = linkRepository.findAllByTitleContainingOrderByCreationDateDesc("sou");

            for (Link linkone : links) {
                System.out.println(linkone.getTitle());
            }

        };
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


//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//            log.error("CommandLineRunner.run();");
//            log.warn("CommandLineRunner.run();");
//            log.info("CommandLineRunner.run();");
//            log.debug("CommandLineRunner.run();");
//            log.trace("CommandLineRunner.run();");
//        };
//    }


}
