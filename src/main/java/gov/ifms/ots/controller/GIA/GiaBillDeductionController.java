package gov.ifms.ots.controller.GIA;


import gov.ifms.ots.Request.GiaBillDeductionReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaBillDeductionRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("giaBillDeduction")
public class GiaBillDeductionController {


    @Inject
    private GiaBillDeductionRepo giaBillDeductionRepo;
    @Inject
    private OtsService otsService;


    @Path("ddlBillNo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaBillDeductionReq giaBillDeductionReq) {
        try {
          return otsService.request(giaBillDeductionRepo.ddlBillNo(giaBillDeductionReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlBillNo","SP_BILL_DEDUCTION",
                    "DD1~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaBillDeductionReq giaBillDeductionReq){
        try {
           return otsService.request(giaBillDeductionRepo.billMstDtl(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","billMstDtl","SP_BILL_DEDUCTION",
                    "MST~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("ddlMstBen")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlMstBen(GiaBillDeductionReq giaBillDeductionReq){
        try {
            return otsService.request(giaBillDeductionRepo.ddlMstBen(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlMstBen","SP_BILL_DEDUCTION",
                    "DD2~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlDeductionType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDeductionType(GiaBillDeductionReq giaBillDeductionReq){
        try {
           return otsService.request(giaBillDeductionRepo.ddlDeductionType(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlDeductionType","SP_BILL_DEDUCTION",
                    "DD3~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());

            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlBudgetHeadDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBudgetHeadDtl(GiaBillDeductionReq giaBillDeductionReq){
        try {
          return otsService.request(giaBillDeductionRepo.ddlBudgetHeadDtl(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlBudgetHeadDtl","SP_BILL_DEDUCTION",
                    "DD4~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("ddlBfcType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBfcType(GiaBillDeductionReq giaBillDeductionReq){
        try {
           return otsService.request(giaBillDeductionRepo.ddlBfcType(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlBfcType","SP_BILL_DEDUCTION",
                    "DD5~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("ddlHeadType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlHeadType(GiaBillDeductionReq giaBillDeductionReq){
        try {
            return  otsService.request(giaBillDeductionRepo.ddlHeadType(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlHeadType","SP_BILL_DEDUCTION",
                    "DD6~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlPdAc")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlPdAc(GiaBillDeductionReq giaBillDeductionReq){
        try {
           return otsService.request(giaBillDeductionRepo.ddlPdAc(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlPdAc","SP_BILL_DEDUCTION",
                    "DD7~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlDivision")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDivision(GiaBillDeductionReq giaBillDeductionReq){
        try {
            return  otsService.request(giaBillDeductionRepo.ddlDivision(giaBillDeductionReq));


        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","ddlDivision","SP_BILL_DEDUCTION",
                    "DD8~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("bindDG1Deduction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Deduction(GiaBillDeductionReq giaBillDeductionReq){
        try {
            return otsService.request(giaBillDeductionRepo.bindDG1Deduction(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","bindDG1Deduction","SP_BILL_DEDUCTION",
                    "DG1~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("insBillDeduction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insBillDeduction(GiaBillDeductionReq giaBillDeductionReq){
        try {
           return otsService.insRequest(giaBillDeductionRepo.insBillDeduction(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","insBenDtl","SP_BILL_DEDUCTION",
                    "INS~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("updBillDeduction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updBillDeduction(GiaBillDeductionReq giaBillDeductionReq) {
        try {
            return otsService.request(giaBillDeductionRepo.updBillDeduction(giaBillDeductionReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaBillDeductionController","updBillDeduction","SP_BILL_DEDUCTION",
                    "UPD~Ctrl",giaBillDeductionReq.getUserId(),giaBillDeductionReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
