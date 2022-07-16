package j2os.org.main;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
import j2os.org.entity.Person;
import j2os.org.error.WrapperMessage;
import j2os.org.service.PersonService;
import sun.net.httpserver.HttpServerImpl;

import java.util.List;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        try {
            ResourceConfig resourceConfig= new PackagesResourceConfig("j2os.org.main");
            HttpServer httpServer= HttpServerFactory.create("http://localhost:8081/",resourceConfig);
            httpServer.start();
        } catch (Exception e) {
            WrapperMessage.getErrorMessage(e);
        }

    }

}
