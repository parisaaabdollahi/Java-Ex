package j2os.org.controller;

import j2os.org.common.JSON;
import j2os.org.domain.Person;
import j2os.org.error.ErrorWrapper;
import j2os.org.error.inputVallidationException;
import j2os.org.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/personal")
public class PersonController {
    @Path("/save")
    @GET
    @Produces("application/json")

    public String save(@QueryParam("name")String name,@QueryParam("family")String family){

    try {
        if (name==null || family==null) {
            throw new inputVallidationException();
        }

        PersonService.getInstance().save(new Person().setName(name).setFamily(family));
        return findAll();
    } catch (Exception e) {
        return JSON.getString(ErrorWrapper.getErrorMessage(e));
    }
}

@Path("/update")
@GET
@Produces("application/json")
public String update(@QueryParam("id")String id, @QueryParam("name")String name,@QueryParam("family")String family)
{
    try {
        PersonService.getInstance().update(new Person().setId(Long.parseLong(id)).setName(name).setFamily(family));
        return findAll();
    } catch (Exception e) {
        return JSON.getString(ErrorWrapper.getErrorMessage(e));
    }

}
@Path("/remove")
@GET
@Produces("application/json")
public String remove(@QueryParam("id")String id){
    try {
        PersonService.getInstance().remove(Long.parseLong(id));
        return findAll();
    } catch (Exception e) {
        return JSON.getString(ErrorWrapper.getErrorMessage(e));
    }
}
@Path("/findById")
@GET
@Produces("application/json")
public String findById(@QueryParam("id")String id){
    try {
        return JSON.getString(PersonService.getInstance().findById(Long.parseLong(id)));
    } catch (Exception e) {
       return JSON.getString(ErrorWrapper.getErrorMessage(e));
    }
}

    @Path("/findByName")
    @GET
    @Produces("application/json")
    public String findByName(@QueryParam("name")String name){
        try {
            return JSON.getString(PersonService.getInstance().findByName(name));
        } catch (Exception e) {
            return JSON.getString(ErrorWrapper.getErrorMessage(e));
        }
    }
@Path("/findAll")
@GET
@Produces("application/json")
    public String findAll(){
    try {
        return  JSON.getString(PersonService.getInstance().findAll());
    } catch (Exception e) {
        return JSON.getString(ErrorWrapper.getErrorMessage(e));
    }
}
}
