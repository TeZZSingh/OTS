package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.GiaAddBenReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaAddBenRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("giaAddBen/")
public class GiaAddBenController {
    @Inject
    private GiaAddBenRepo giaPayeeRepo;
    @Inject
    private OtsService otsService;
    @POST
    @Path("ddlBillNo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaAddBenReq giaAddBenReq){
        try {
       return otsService.request(giaPayeeRepo.ddlBillNo(giaAddBenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaAddBenController","ddlBillNo","SP_GIA_ADD_BEN",
                    "DD1~Ctrl",giaAddBenReq.getUserId(),giaAddBenReq.getIp());;
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaAddBenReq giaAddBenReq){
    try {
            return otsService.request(giaPayeeRepo.billMstDtl(giaAddBenReq));

        } catch (OtsException e) {
        otsService.errorRequest(e.getExceptionMsg(),"GiaAddBenController","billMstDtl","SP_GIA_ADD_BEN",
                "MST~Ctrl",giaAddBenReq.getUserId(),giaAddBenReq.getIp());;
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlMstBen")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlMstBen(GiaAddBenReq giaAddBenReq){
        try {
           return  otsService.request(giaPayeeRepo.ddlMstBen(giaAddBenReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaAddBenController","ddlMstBen","SP_GIA_ADD_BEN",
                    "DD2~Ctrl",giaAddBenReq.getUserId(),giaAddBenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("bindDG1Ben")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Ben(GiaAddBenReq giaAddBenReq){
    try {
           return otsService.request(giaPayeeRepo.bindDG1Ben(giaAddBenReq));

        } catch (OtsException e) {
        otsService.errorRequest(e.getExceptionMsg(),"GiaAddBenController","bindDG1Ben","SP_GIA_ADD_BEN",
                "DG1~Ctrl",giaAddBenReq.getUserId(),giaAddBenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("insBenDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insBenDtl(GiaAddBenReq giaAddBenReq){
     try {
            return otsService.insRequest(giaPayeeRepo.insBenDtl(giaAddBenReq));
        } catch (OtsException e) {
         otsService.errorRequest(e.getExceptionMsg(),"GiaAddBenController","insBenDtl","SP_GIA_ADD_BEN",
                 "INS~Ctrl",giaAddBenReq.getUserId(),giaAddBenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("updBenDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updBenDtl(GiaAddBenReq giaAddBenReq){
    try {
         return otsService.insRequest(giaPayeeRepo.updBenDtl(giaAddBenReq));

        } catch (OtsException e) {
        otsService.errorRequest(e.getExceptionMsg(),"MenuMasterController","updBenDtl","SP_MENU_MASTER",
                "UPD~Ctrl",giaAddBenReq.getUserId(),giaAddBenReq.getIp());;
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("delBenDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBenDtl(GiaAddBenReq giaAddBenReq){
        try {
         return otsService.insRequest(giaPayeeRepo.delBenDtl(giaAddBenReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"MenuMasterController","delBenDtl","SP_MENU_MASTER",
                    "DEL~Ctrl",giaAddBenReq.getUserId(),giaAddBenReq.getIp());;
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
