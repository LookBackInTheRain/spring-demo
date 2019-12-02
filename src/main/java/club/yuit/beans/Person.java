package club.yuit.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;

/**
 * @author yuit
 * @date 2019/12/2 9:53
 **/
@Getter
@Setter
@Component
public class Person {
    private String name;
    private String gender;

    public void init(){
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);

    }

}
