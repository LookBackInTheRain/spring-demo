package club.yuit.beans;

import club.yuit.annotation.Ignore;
import org.springframework.stereotype.Component;

@Component
public class AdminUser implements IUser {
    @Override
    public void doWork() {
        System.out.println("AdminUser Working");
    }
}
