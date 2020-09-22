package club.yuit.beans;

import club.yuit.service.DocumentService;
import club.yuit.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Getter
@Setter
@Component
public class User {

   private DocumentService documentService;



    public User() {

    }

    public void parse() throws ParserConfigurationException, SAXException, IOException {
        this.documentService.parse();
    }

}
