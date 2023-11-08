package gov.ifms.ots.controller;

import gov.ifms.ots.Request.CreateLinkReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.CreateLinkRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("createLink/")
public class CreateLinkController {
    @Inject
    private CreateLinkRepo createLinkRepo;
    @Inject
   private OtsService otsService;
    @POST
    @Path("ddlMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ddlMenuMaster(CreateLinkReq createLinkReq) {
             try {
               return otsService.request(createLinkRepo.ddlMenuMaster(createLinkReq));
        } catch (OtsException e) {
                 otsService.errorRequest(e.getExceptionMsg(), "CreateLinkController","ddlMenuMaster","SP_CREATE_LINK",
                         "DDL~Ctrl",createLinkReq.getUserId(),createLinkReq.getIp() );
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("bindDG1Menu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bindDG1Menu(CreateLinkReq createLinkReq) {
          try {
              return otsService.request(createLinkRepo.bindDG1Menu(createLinkReq));
        } catch (OtsException e) {
              otsService.errorRequest(e.getExceptionMsg(), "CreateLinkController","bindmenumaster","SP_CREATE_LINK",
                      "DG1~Ctrl",createLinkReq.getUserId(),createLinkReq.getIp() );
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("insMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insMenuMaster(CreateLinkReq createLinkReq) {
            try {
               return otsService.insRequest(createLinkRepo.insMenuMaster(createLinkReq));
            } catch (OtsException e) {
                otsService.errorRequest(e.getExceptionMsg(), "CreateLinkController","insMenuMaster","SP_CREATE_LINK",
                        "ins~Ctrl",createLinkReq.getUserId(),createLinkReq.getIp() );
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("updMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updMenuMaster(CreateLinkReq createLinkReq) {
              try {
                  return otsService.insRequest(createLinkRepo.updMenuMaster(createLinkReq));
              } catch (OtsException e) {
                  otsService.errorRequest(e.getExceptionMsg(), "CreateLinkController","updMenuMaster","SP_CREATE_LINK",
                          "UPD~Ctrl",createLinkReq.getUserId(),createLinkReq.getIp() );
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
