package club.yuit;

import club.yuit.beans.Person;
import club.yuit.beans.User;
import club.yuit.config.ApplicationConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuit
 * @date 2019-12-01 21:03
 */
@RunWith(JUnit4.class)
public class Application {

    /**
     * 基于 annotation 的配置
     */
    @Test
    public void annotationConfigurationTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        System.out.println();

    }

    /**
     * 基于XML文件的配置
     */
    @Test
    public void xmlConfigurationTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");




        User u = context.getBean("p1",User.class);

        System.out.println(u.getUsername());

    }

}
