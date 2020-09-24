package club.yuit.beans;

import club.yuit.annotation.Ignore;
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
@Ignore
public class Work {

   private DocumentService documentService;



    public Work() {

    }

    public void parse() throws ParserConfigurationException, SAXException, IOException {
        this.documentService.parse();
    }


    public IUser getWorker(){
        return new IUser() {
            @Override
            public void doWork() {
                System.out.println("IUser Working");
            }
        };
    }



    public void doWork(){
        this.getWorker().doWork();
    }



}
