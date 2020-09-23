package club.yuit;

import club.yuit.beans.Person;
import club.yuit.beans.User;
import club.yuit.config.ApplicationConfiguration;
import club.yuit.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.setConfigLocation("classpath:application.xml");
        context.refresh();
        User user = context.getBean(User.class);

        try {
            user.parse();
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void xmlBeanFactoryTest(){

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        ClassPathResource resource = new ClassPathResource("application.xml");

        ConfigurableEnvironment ev = new StandardEnvironment();
        ev.setActiveProfiles("dev");
        reader.setEnvironment(ev);
        reader.loadBeanDefinitions(resource);

        System.out.println("ccc");

    }


    @Test
    public void parseXmlTest() throws Exception {
      new DocumentService().parse();
    }


    @Test
    public void otherTest(){

        Object o = null;
        Object o1 = o;
        o= new Object();

        System.out.println(o1);
        System.out.println(o);


    }


}
