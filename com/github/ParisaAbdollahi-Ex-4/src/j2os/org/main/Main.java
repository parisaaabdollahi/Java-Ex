package j2os.org.main;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
import j2os.org.entity.Person;
import j2os.org.error.WrapperMessage;
import j2os.org.service.PersonService;
import sun.net.httpserver.HttpServerImpl;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws IOException {

            ResourceConfig resourceConfig = new PackagesResourceConfig("org.j2os.erp.controller");
            HttpServer httpServer = HttpServerFactory.create("http://localhost:8081/",resourceConfig);
            httpServer.start();


    }

}
