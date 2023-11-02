package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.Request.GiaBillDeductionReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.ErrorLogRepo;
import gov.ifms.ots.repository.GiaBillDeductionRepo;
import org.json.JSONArray;
import org.json.JSONObject;
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
    GiaBillDeductionRepo giaBillDeductionRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    ErrorLogRepo errorLogRepo;


    @Path("ddlBillNo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaBillDeductionReq giaBillDeductionReq) {
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlBillNo(giaBillDeductionReq);
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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlBillNo");
           errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD1");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }

    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.billMstDtl(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("billMstDtl");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("MST");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }

    @POST
    @Path("ddlMstBen")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlMstBen(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlMstBen(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlMstBen");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD2");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("ddlDeductionType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDeductionType(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlDeductionType(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlDeductionType");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD3");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("ddlBudgetHeadDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBudgetHeadDtl(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlBudgetHeadDtl(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlBudgetHeadDtl");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD4");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }

    @POST
    @Path("ddlBfcType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBfcType(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlBfcType(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlBfcType");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD5");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }

    @POST
    @Path("ddlHeadType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlHeadType(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlHeadType(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlHeadType");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD6");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("ddlPdAc")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlPdAc(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlPdAc(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlPdAc");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD7");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("ddlDivision")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDivision(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.ddlDivision(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("ddlDivision");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DD8");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("bindDG1Deduction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Deduction(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.bindDG1Deduction(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("bindDG1Deduction");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("DG1");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("insBillDeduction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insBillDeduction(GiaBillDeductionReq giaBillDeductionReq){
        try {
            JSONArray jsonArray = giaBillDeductionRepo.insBillDeduction(giaBillDeductionReq);

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
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("insBenDtl");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("INS");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("updBillDeduction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updBillDeduction(GiaBillDeductionReq giaBillDeductionReq) {
        try {
            JSONArray jsonArray = giaBillDeductionRepo.updBillDeduction(giaBillDeductionReq);
            JSONObject oRespObj = new JSONObject();
            oRespObj.put("oRESP", jsonArray.get(1).toString());
            JSONArray oRespArray = new JSONArray();
            oRespArray.put(oRespObj);

            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            } else {
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS

            }
        } catch (OtsException e) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setPageUrl("GiaBillDeductionController");
            errorLogReq.setApiName("updBillDeduction");
            errorLogReq.setSpName("SP_BILL_DEDUCTION");
            errorLogReq.setSpMode("UPD");
            errorLogReq.setUserId(giaBillDeductionReq.getUserId());
            errorLogReq.setIp(giaBillDeductionReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
