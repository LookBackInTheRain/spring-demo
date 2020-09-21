package club.yuit;

import club.yuit.beans.Person;
import club.yuit.beans.User;
import club.yuit.config.ApplicationConfiguration;
import club.yuit.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.rmi.server.ExportException;

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

        DocumentService documentService = context.getBean(DocumentService.class);

        try {
            documentService.parse();
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void parseXmlTest() throws Exception {
      new DocumentService().parse();
    }


}
