package club.yuit.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class DocumentService {


  public Map<Object, Object> parse() throws IOException, SAXException, ParserConfigurationException {
    Document doc = this.loadDocument();

    Element root = doc.getDocumentElement();

    String lazyInitValue =  root.getAttribute("lazy-init");



    return null;
  }

  private Document loadDocument() throws ParserConfigurationException, IOException, SAXException {
    ClassPathResource resource = new ClassPathResource("root.xml");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(resource.getInputStream());
    return document;
  }


}
