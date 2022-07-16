package j2os.org.controller;

import j2os.org.common.JSON;
import j2os.org.entity.Person;
import j2os.org.service.PersonService;
import jdk.security.jarsigner.JarSigner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/person")
public class PersonController {
    @Path("/save")
    @Produces("text/plain")
    @GET
    public String save(@QueryParam("name") String name,@QueryParam("family") String family, @QueryParam("sin") String sin) throws Exception {
if (name== null || family==null){
throw new InputValidationException();
}
        PersonService.getInstance().save(new Person().setName(name).setFamily(family).setSin(Long.parseLong(sin)));
return JSON.getString()

}
