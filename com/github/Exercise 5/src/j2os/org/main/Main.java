package j2os.org.main;
import j2os.org.controller.*;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
import j2os.org.error.WrapperMessage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
try {
    ResourceConfig resourceConfig = new PackagesResourceConfig("j2os.org.controller");
    HttpServer httpServer = HttpServerFactory.create("http://localhost:8081/", resourceConfig);
    httpServer.start();
}
catch (Exception e){
    WrapperMessage.getErrorMessage(e);
}


    }

}
