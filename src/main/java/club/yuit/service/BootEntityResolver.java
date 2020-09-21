package club.yuit.service;

import org.springframework.core.io.ClassPathResource;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

public class BootEntityResolver implements EntityResolver {

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {

        System.out.println(systemId);

        if (systemId!=null){
            ClassPathResource resource = new ClassPathResource("root.xsd");
            InputSource source =  new InputSource(resource.getInputStream());
            source.setPublicId(publicId);
            source.setSystemId(systemId);
            return source;
        }

        return null;
    }
}

