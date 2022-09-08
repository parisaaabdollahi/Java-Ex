package j2os.org.controller;

import j2os.org.common.JSON;
import j2os.org.domain.Car;
import j2os.org.error.ErrorWrapper;
import j2os.org.error.InputVallidationException;
import j2os.org.service.CarService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/tehran")
public class CarController {
    @Path("/entry")
    @GET
    @Produces("text/plain")
    public String save(@QueryParam("model") String model, @QueryParam("code") String code, @QueryParam("indoor") String inDoor, @QueryParam("outdoor") String outDoor) {
        try{
if(model==null || code==null || inDoor==null || outDoor==null) {
    throw new InputVallidationException();
}
CarService.getInstance().save(new Car().setModel(model).setCode(code).setInDoor(Integer.parseInt(inDoor)).setOutDoor(Integer.parseInt(outDoor)));
return findAll();
}
        catch (Exception e) {
return JSON.getString(ErrorWrapper.getErrorMessage(e));
        }
        }


    @Path("/findByCode")
    @GET
     @Produces("text/plain")
    public String findByCode(@QueryParam("code") String code) {
        try {
            return JSON.getString(CarService.getInstance().findByCode(code));
        } catch (Exception e) {
            return JSON.getString(ErrorWrapper.getErrorMessage(e));
        }
    }
    @Path("/findAll")
    @GET
    @Produces("text/plain")
    public String findAll(){
        try{
            return JSON.getString(CarService.getInstance().findAll());
        } catch (Exception e) {
            return JSON.getString(ErrorWrapper.getErrorMessage(e));
        }
    }
}
