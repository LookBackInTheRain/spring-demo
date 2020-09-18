package club.yuit.beans;

import club.yuit.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class User {

    private String username;
    private String addr;
    private int age;

    @Autowired
    private UserService userService;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }
}
