package gov.ifms.ots.controller.GIA;


import gov.ifms.ots.Request.GiaBillDocsReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaBillDocsRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("giaBillDocs/")
public class GiaBillDocsController {
    @Inject
    private GiaBillDocsRepo giaBillDocsRepo;
    @Inject
    private OtsService otsService;

    @POST
    @Path("ddlBillNo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaBillDocsReq giaBillDocsReq){
        try {
            return otsService.request(giaBillDocsRepo.ddlBillNo(giaBillDocsReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","ddlBillNo","SP_GIA_BILL_DOCS",
                    "DD1~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("bindDG1Ben")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Ben(GiaBillDocsReq giaBillDocsReq){
        try {
            return otsService.request(giaBillDocsRepo.bindDG1Ben(giaBillDocsReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","ddlMstBen","SP_GIA_BILL_DOCS",
                    "DD2~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("bindDG2Ded")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG2Ded(GiaBillDocsReq giaBillDocsReq){
        try {
            return otsService.request(giaBillDocsRepo.bindDG2Ded(giaBillDocsReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","bindDeductions","SP_GIA_BILL_DOCS",
                    "DG2~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaBillDocsReq giaBillDocsReq){
        try {
           return otsService.request(giaBillDocsRepo.billMstDtl(giaBillDocsReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","billMstDtl","SP_GIA_BILL_DOCS",
                    "MST~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlDocType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDocType(GiaBillDocsReq giaBillDocsReq){
        try {
           return otsService.request(giaBillDocsRepo.ddlDocType(giaBillDocsReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","ddlDocType","SP_GIA_BILL_DOCS",
                    "DD3~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("bindDG3Docs")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG3Docs(GiaBillDocsReq giaBillDocsReq){
        try {
            return otsService.request(giaBillDocsRepo.bindDG3Docs(giaBillDocsReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","bindDG1Ben","SP_GIA_BILL_DOCS",
                    "DG1~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }


    @POST
    @Path("insDocsDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insDocsDtl(GiaBillDocsReq giaBillDocsReq){
        try {
            return otsService.insRequest(giaBillDocsRepo.insDocsDtl(giaBillDocsReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","insDocsDtl","SP_GIA_BILL_DOCS",
                    "INS~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("delDocsDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delDocsDtl(GiaBillDocsReq giaBillDocsReq){
        try {
         return otsService.insRequest(giaBillDocsRepo.delDocsDtl(giaBillDocsReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDocsController","delBenDtl","SP_GIA_BILL_DOCS",
                    "DEL~Ctrl",giaBillDocsReq.getUserId(),giaBillDocsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
