package org.j2os.controller;

import org.j2os.Exception.InputValidatorException;
import org.j2os.common.ErrorWrapper;
import org.j2os.common.JSON;
import org.j2os.dto.CarInfoDto;
import org.j2os.entity.CarInfo;
import org.j2os.service.CarInfoService;

import javax.ws.rs.*;
import java.util.List;

@Path("/tehran")
public class CarInfoController {
    @Path("/entry")
    @GET
    @Produces("application/json")
    public String save(@QueryParam("model") String model, @QueryParam("code") String code, @QueryParam("indoor") String indoor, @QueryParam("outdoor") String outdoor) {
        try {
            if (model == null || code == null || indoor == null || outdoor == null)
                throw new InputValidatorException();
            CarInfoService.getInstance().add(new CarInfo(model, code, Integer.parseInt(indoor), Integer.parseInt(outdoor)));
        } catch (Exception ex) {
            return JSON.getString(ErrorWrapper.getError(ex));
        }
        return findAll(code);
    }

    @Path("/findAll")
    @GET
    @Produces("application/json")
    public String findAll(@QueryParam("code") String code) {
        try {
            if (code == null)
                throw new InputValidatorException();
            return JSON.getString(CarInfoService.getInstance().findAll(code));
        } catch (Exception ex) {
            return JSON.getString(ErrorWrapper.getError(ex));
        }
    }

    @Path("/sum")
    @GET
    @Produces("application/json")
    public String sum(@QueryParam("code") String code) {
        try {
            if (code == null)
                throw new InputValidatorException();
            List<CarInfo> carInfoList = CarInfoService.getInstance().findAll(code);
            CarInfoDto carInfoDto = new CarInfoDto().setCode(code).setTotalEntry(carInfoList.size()).setTotalCost(carInfoList.stream().mapToLong(i->i.getCost()).sum());
            return JSON.getString(carInfoDto);
        } catch (Exception ex) {
            return JSON.getString(ErrorWrapper.getError(ex));
        }
    }
}
