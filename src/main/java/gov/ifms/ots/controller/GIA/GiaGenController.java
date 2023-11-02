package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.Request.GiaGenReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.ErrorLogRepo;
import gov.ifms.ots.repository.GiaGenRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("giaGen/")
public class GiaGenController {
    @Inject
    private GiaGenRepo giaGenRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    private ErrorLogRepo errorLogRepo;

    @Path("ddlSchemeType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlSchemeType(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.ddlSchemeType(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("ddlSchemeType");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DD1");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }

    @Path("ddlBillType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillType(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.ddlBillType(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("ddlBillType");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DD2");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }

    @Path("ddlBillSubType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillSubType(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.ddlBillSubType(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("ddlBillSubtype");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DD3");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("ddlBillYear")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillYear(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.ddlBillYear(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("ddlBillYear");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DD4");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("ddlBillMonth")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillMonth(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.ddlBillMonth(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("ddlBillMonth");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DD5");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("ddlObjectHead")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlObjectHead(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.ddlObjectHead(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("ddlObjectHead");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DD6");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("ddlPaymentMode")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlPaymentMode(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.ddlPaymentMode(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("ddlPaymentMode");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DD7");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("bindDG1Gia")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Gia(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.bindDG1Gia(giaGenReq);
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
            errorLogReq.setToken(giaGenReq.getToken());
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("bindDG1Gia");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("DG1");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("insGiaBill")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insGiaBill(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.insGiaBill(giaGenReq);
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
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("insGiaBill");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("INS");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }


    @Path("updGiaBill")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updGiaBill(GiaGenReq giaGenReq) {
        try {
            JSONArray jsonArray = giaGenRepo.updGiaBill(giaGenReq);
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
            errorLogReq.setToken(giaGenReq.getToken());
            errorLogReq.setPageUrl("GiaGenController");
            errorLogReq.setApiName("updGiaBill");
            errorLogReq.setSpName("SP_GIA_GEN");
            errorLogReq.setSpMode("UPD");
            errorLogReq.setUserId(giaGenReq.getUserId());
            errorLogReq.setIp(giaGenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

}
