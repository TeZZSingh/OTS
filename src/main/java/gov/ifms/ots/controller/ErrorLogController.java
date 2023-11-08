package gov.ifms.ots.controller;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.repository.ErrorLogRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("errorLog/")
public class ErrorLogController {
    @Inject
    private ErrorLogRepo errorLogRepo;

    @Inject
    private OtsService otsService;


    @POST
    @Path("bindDG1Error")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Error(ErrorLogReq errorLogReq) {
            try {
            return otsService.request(errorLogRepo.bindDG1Error(errorLogReq));
        } catch (Exception e) {
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }

    @POST
    @Path("insErrorLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insErrorLog(ErrorLogReq errorLogReq) {
         try {
           return otsService.insRequest( errorLogRepo.insErrorLog(errorLogReq));

        } catch (Exception e) {
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }


    @POST
    @Path("delErrorLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delErrorLog(ErrorLogReq errorLogReq) {
       try {
            return otsService.insRequest(errorLogRepo.delErrorLog(errorLogReq));

        } catch (Exception e) {
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }
}
