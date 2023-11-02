package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.*;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaBillBudgetDtlRepo;
import gov.ifms.ots.repository.ErrorLogRepo;
import org.json.JSONArray;
import org.json.JSONObject;
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
    private ErrorLogReq errorLogReq;

    @Inject
    ErrorLogRepo errorLogRepo;
    @Path("ddlBillNo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaBillBudgetDtlReq giaBillBudgetDtlReq) {
        try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.ddlBillNo(giaBillBudgetDtlReq);
            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            if (jsonArray.get(0).equals("SUCCESS")) {
                JSONArray json = new JSONArray(jsonArray.get(1).toString());
                return Response.ok(ApiResponse.success(json.toList(), jsonArray.get(0).toString())).build();
            }
            if (jsonArray.get(0).equals("ERROR"))
            {
                JSONObject oRespObj = new JSONObject();
                oRespObj.put("oRESP",jsonArray.get(1).toString());
                JSONArray oRespArray = new JSONArray();
                oRespArray.put(oRespObj);
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS
            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("ddlBillNo");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("DD1");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.billMstDtl(giaBillBudgetDtlReq);

            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            else if (jsonArray.get(0).equals("SUCCESS")) {
                JSONArray json = new JSONArray(jsonArray.get(1).toString());
                return Response.ok(ApiResponse.success(json.toList(), jsonArray.get(0).toString())).build();
            }
            if (jsonArray.get(0).equals("ERROR"))
            {
                JSONObject oRespObj = new JSONObject();
                oRespObj.put("oRESP",jsonArray.get(1).toString());
                JSONArray oRespArray = new JSONArray();
                oRespArray.put(oRespObj);
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS
            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("billMstDtl");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("MST");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("ddlBFCType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBFCType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) {
        try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.ddlBFCType(giaBillBudgetDtlReq);
            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            if (jsonArray.get(0).equals("SUCCESS")) {
                JSONArray json = new JSONArray(jsonArray.get(1).toString());
                return Response.ok(ApiResponse.success(json.toList(), jsonArray.get(0).toString())).build();
            }
            if (jsonArray.get(0).equals("ERROR"))
            {
                JSONObject oRespObj = new JSONObject();
                oRespObj.put("oRESP",jsonArray.get(1).toString());
                JSONArray oRespArray = new JSONArray();
                oRespArray.put(oRespObj);
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS
            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setMode("INS");
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("ddlBFCType");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("DD2");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("ddlHeadType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlHeadType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) {
        try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.ddlHeadType(giaBillBudgetDtlReq);
            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            if (jsonArray.get(0).equals("SUCCESS")) {
                JSONArray json = new JSONArray(jsonArray.get(1).toString());
                return Response.ok(ApiResponse.success(json.toList(), jsonArray.get(0).toString())).build();
            }
            if (jsonArray.get(0).equals("ERROR"))
            {
                JSONObject oRespObj = new JSONObject();
                oRespObj.put("oRESP",jsonArray.get(1).toString());
                JSONArray oRespArray = new JSONArray();
                oRespArray.put(oRespObj);
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS
            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setMode("INS");
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("ddlHeadType");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("DD3");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("ddlPdAc")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlPdAc(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.ddlPdAc(giaBillBudgetDtlReq);

            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            else if (jsonArray.get(0).equals("SUCCESS")) {
                JSONArray json = new JSONArray(jsonArray.get(1).toString());
                return Response.ok(ApiResponse.success(json.toList(), jsonArray.get(0).toString())).build();
            }
            if (jsonArray.get(0).equals("ERROR"))
            {
                JSONObject oRespObj = new JSONObject();
                oRespObj.put("oRESP",jsonArray.get(1).toString());
                JSONArray oRespArray = new JSONArray();
                oRespArray.put(oRespObj);
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS
            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("ddlPdAc");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("DD4");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("ddlDivision")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDivision(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.ddlDivision(giaBillBudgetDtlReq);

            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            else if (jsonArray.get(0).equals("SUCCESS")) {
                JSONArray json = new JSONArray(jsonArray.get(1).toString());
                return Response.ok(ApiResponse.success(json.toList(), jsonArray.get(0).toString())).build();
            }
            if (jsonArray.get(0).equals("ERROR"))
            {
                JSONObject oRespObj = new JSONObject();
                oRespObj.put("oRESP",jsonArray.get(1).toString());
                JSONArray oRespArray = new JSONArray();
                oRespArray.put(oRespObj);
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS
            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("ddlDivision");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("DD5");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("bindDG1Budget")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response bindDG1Budget(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
     try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.bindDG1Budget(giaBillBudgetDtlReq);
         if (jsonArray == null || jsonArray.isEmpty()) {
             return Response.ok(ApiResponse.dataIsNull("")).build();
         }
         if (jsonArray.get(0).equals("SUCCESS")) {
             JSONArray json = new JSONArray(jsonArray.get(1).toString());
             return Response.ok(ApiResponse.success(json.toList(), jsonArray.get(0).toString())).build();
         }
         if (jsonArray.get(0).equals("ERROR"))
         {
             JSONObject oRespObj = new JSONObject();
             oRespObj.put("oRESP",jsonArray.get(1).toString());
             JSONArray oRespArray = new JSONArray();
             oRespArray.put(oRespObj);
             return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS
         }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setMode("INS");
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("bindDG1Budget");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("INS~Ctrl");
         errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
     return null;
    }


    @POST
    @Path("insBillBudgetDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response insBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
    try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.insBillBudgetDtl(giaBillBudgetDtlReq);
        JSONObject oRespObj = new JSONObject();
        oRespObj.put("oRESP",jsonArray.get(1).toString());
        JSONArray oRespArray = new JSONArray();
        oRespArray.put(oRespObj);

        if (jsonArray == null || jsonArray.isEmpty()) {
            return Response.ok(ApiResponse.dataIsNull("")).build();
        }
        else
        {
            return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS

        }
    } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setMode("INS");
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("insBillBudgetDtl");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("INS~Ctrl");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("delBillBudgetDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq){
        try {
            JSONArray jsonArray = giaBillBudgetDtlRepo.delBillBudgetDtl(giaBillBudgetDtlReq);
            JSONObject oRespObj = new JSONObject();
            oRespObj.put("oRESP",jsonArray.get(1).toString());
            JSONArray oRespArray = new JSONArray();
            oRespArray.put(oRespObj);

            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            else
            {
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS

            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setMode("INS");
            errorLogReq.setPageUrl("BillBudgetDtlCtrl");
            errorLogReq.setApiName("delBillBudgetDtl");
            errorLogReq.setSpName("SP_BILL_BUDGET_DTL");
            errorLogReq.setSpMode("DEL~Ctrl");
            errorLogReq.setUserId(giaBillBudgetDtlReq.getUserId());
            errorLogReq.setIp(giaBillBudgetDtlReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

}
