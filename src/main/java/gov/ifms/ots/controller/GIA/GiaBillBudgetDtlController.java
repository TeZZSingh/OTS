package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.*;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaBillBudgetDtlRepo;
import gov.ifms.ots.service.OtsService;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("giaBillBudgetDtl/")
public class GiaBillBudgetDtlController {

    @Inject
    private GiaBillBudgetDtlRepo giaBillBudgetDtlRepo;
    @Inject
    private OtsService otsService;
    @Path("ddlBillNo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaBillBudgetDtlReq giaBillBudgetDtlReq) {
        try {
            return  otsService.request(giaBillBudgetDtlRepo.ddlBillNo(giaBillBudgetDtlReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","ddlBillNo","SP_BILL_BUDGET_DTL",
                    "DD1~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
           return otsService.request(giaBillBudgetDtlRepo.billMstDtl(giaBillBudgetDtlReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","billMstDtl","SP_BILL_BUDGET_DTL",
                    "MST~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @Path("ddlBFCType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBFCType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) {
        try {
            return  otsService.request(giaBillBudgetDtlRepo.ddlBFCType(giaBillBudgetDtlReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","ddlBFCType","SP_BILL_BUDGET_DTL",
                    "DD2~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @Path("ddlHeadType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlHeadType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) {
        try {
            return otsService.request(giaBillBudgetDtlRepo.ddlHeadType(giaBillBudgetDtlReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","ddlHeadType","SP_BILL_BUDGET_DTL",
                    "DD3~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlPdAc")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlPdAc(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
            return otsService.request(giaBillBudgetDtlRepo.ddlPdAc(giaBillBudgetDtlReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","ddlPdAc","SP_BILL_BUDGET_DTL",
                    "DD4~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("ddlDivision")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDivision(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
            return otsService.request(giaBillBudgetDtlRepo.ddlDivision(giaBillBudgetDtlReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","ddlDivision","SP_BILL_BUDGET_DTL",
                    "DD5~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("bindDG1Budget")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response bindDG1Budget(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
     try {
            return  otsService.request(giaBillBudgetDtlRepo.bindDG1Budget(giaBillBudgetDtlReq));
        } catch (OtsException e) {
         otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","bindDG1Budget","SP_BILL_BUDGET_DTL",
                 "DG1~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }


    @POST
    @Path("insBillBudgetDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response insBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
    try {
           return  otsService.insRequest(giaBillBudgetDtlRepo.insBillBudgetDtl(giaBillBudgetDtlReq));
    } catch (OtsException e) {
        otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","insBillBudgetDtl","SP_BILL_BUDGET_DTL",
                "INS~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("delBillBudgetDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
          return otsService.insRequest(giaBillBudgetDtlRepo.delBillBudgetDtl(giaBillBudgetDtlReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillBudgetDtlCtrl","delBillBudgetDtl","SP_BILL_BUDGET_DTL",
                    "DEL~Ctrl",giaBillBudgetDtlReq.getUserId(),giaBillBudgetDtlReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

}
