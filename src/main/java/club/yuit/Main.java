package club.yuit;

import club.yuit.beans.Work;
import club.yuit.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Main {
    public static void main(String[] args) {

        MT<Integer> mt = new MT<>(3);

        TypeVariable[] tv = (mt.getClass()).getTypeParameters();


        for (TypeVariable t: tv){
            System.out.println(t.getName());
        }




    }
}


class MT<T> {

   private T t;

    public MT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
