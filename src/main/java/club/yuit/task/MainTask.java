package club.yuit.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainTask {


    public void doWork(){
        System.out.println("task working");
    }


    public Double aDouble(){
        return 12D;
    }
}
