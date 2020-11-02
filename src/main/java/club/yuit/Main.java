package club.yuit;

import club.yuit.beans.Work;
import club.yuit.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.setConfigLocation("application.xml");
        context.refresh();
        Work work = context.getBean(Work.class);
        work.doWork();*/

        System.out.println(Math.floor(-8.5));

    }
}
