package club.yuit.service;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

@Service
public class DocumentService {


    public Map<Object,Object> parse() throws IOException, SAXException, ParserConfigurationException {
        Document doc = this.loadDocument();

        Element e = doc.getDocumentElement();


        return null;
    }

    private Document loadDocument() throws ParserConfigurationException, IOException, SAXException {
        ClassPathResource resource = new ClassPathResource("classpath:root.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(resource.getInputStream());
    }


}
