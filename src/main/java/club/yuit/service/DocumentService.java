package club.yuit.service;

import club.yuit.service.parse.AbstractParse;
import club.yuit.service.parse.BeanParse;
import club.yuit.service.parse.ImportParse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

@Service
public class DocumentService {

    private BeanParse beanParse;

    public Map<Object, Object> parse() throws IOException, SAXException, ParserConfigurationException {
        Document doc = this.loadDocument();

        this.doParse(doc.getDocumentElement());

        return null;
    }

    private void doParse(Element root) {

        NodeList nl = root.getChildNodes();

        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                if (isBean(ele)) {
                    parseBean(ele);
                }
                if (isImport(ele)) {
                    parseImport(ele);
                }
                if (isBeans(ele)) {
                    doParse(ele);
                }
            }
        }
    }

    private Document loadDocument() throws ParserConfigurationException, IOException, SAXException {
        ClassPathResource resource = new ClassPathResource("root.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

        DocumentBuilder builder = factory.newDocumentBuilder();

        BootEntityResolver resolver = new BootEntityResolver();

        builder.setEntityResolver(resolver);
        builder.setErrorHandler(new BootErrorHandler());

        return builder.parse(new InputSource(resource.getInputStream()));
    }


    public boolean isBean(Element ele) {
        return defaultLabelCheck(ele, AbstractParse.BEAN_LABEL_NAME);
    }

    public boolean isImport(Element ele) {
        return defaultLabelCheck(ele, AbstractParse.IMPORT_LABEL_NAME);
    }

    public boolean isBeans(Element ele) {
        return defaultLabelCheck(ele, AbstractParse.BEANS_LABEL_NAME);
    }


    public boolean defaultLabelCheck(Element ele, String labelName) {
        return ele.getTagName().equals(labelName);
    }

    public void parseBean(Element ele) {

    }

    public void parseImport(Element ele) {
    }




}



