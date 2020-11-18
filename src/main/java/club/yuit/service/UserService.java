package club.yuit.service;

import club.yuit.beans.Person;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService implements BaseService<Person> {


    @Override
    public Person getById(Serializable id) {
        return null;
    }
}
