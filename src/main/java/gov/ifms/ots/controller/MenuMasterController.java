package gov.ifms.ots.controller;

import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.Request.MenuMasterReq;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.MenuMasterRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("menuMaster/")
public class MenuMasterController {
    @Inject
    private MenuMasterRepo menuMasterRepo;
     @Inject
     private OtsService otsService;

    @POST
    @Path("getMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenuMaster(MenuMasterReq menuMasterReq){
                   try {
                    return otsService.request(menuMasterRepo.getMenuMaster(menuMasterReq));
        }
        catch (OtsException e ) {
                       otsService.errorRequest(e.getExceptionMsg(),"MenuMasterController","getMenuMaster","SP_MENU_MASTER",
                               "MNU~Ctrl",menuMasterReq.getUserId(),menuMasterReq.getIp());;
            return Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }


}



