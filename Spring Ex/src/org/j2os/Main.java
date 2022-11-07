package org.j2os;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext iocContainer = new ClassPathXmlApplicationContext("Spring.xml");
        Car s500 = (Car) iocContainer.getBean("myCar");
        s500.start();


    }
}
