package j2os.org.controller;

import j2os.org.common.JSON;
import j2os.org.domain.Person;
import j2os.org.error.InputValidationException;
import j2os.org.error.WrapperMessage;
import j2os.org.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
@Path("/person")
public class PersonController {
    @Path("/save")
    @Produces("text/plain")
    @GET
    public String save(@QueryParam("name") String name,@QueryParam("family") String family, @QueryParam("sin") String sin) throws InputValidationException {
        if (name == null || family == null) {
            throw new InputValidationException();
        }
        try {
            PersonService.getInstance().save(new Person().setName(name).setFamily(family).setSin(Long.parseLong(sin)));
            return findAll();
        }
        catch (Exception e){
            return JSON.getString(WrapperMessage.getErrorMessage(e));

        }
    }

    @Path("/update")
    @Produces("text/plain")
    @GET
    public String update(@QueryParam("id") String id,@QueryParam("name") String name, @QueryParam("family")String family, @QueryParam("sin") String sin)
    {
        try {
            PersonService.getInstance().update(new Person().setId(Long.parseLong(id)).setName(name).setFamily(family).setSin(Long.parseLong(sin)));
            return findAll();
        } catch (Exception e) {
            return JSON.getString(WrapperMessage.getErrorMessage(e));
        }
    }
    @Path("/remove")
    @Produces("text/plain")
    @GET

    public String remove(@QueryParam("id") String id )
    {
        try {
            PersonService.getInstance().remove(Long.parseLong(id));
            return findAll();
        } catch (Exception e) {
            return JSON.getString(WrapperMessage.getErrorMessage(e));
        }
    }

    @Path("/findAll")
    @Produces("text/plain")
    @GET
    public String findAll(){
        try {
            return JSON.getString(PersonService.getInstance().findAll());
        } catch (Exception e) {
            return JSON.getString(WrapperMessage.getErrorMessage(e));
        }
    }

}


