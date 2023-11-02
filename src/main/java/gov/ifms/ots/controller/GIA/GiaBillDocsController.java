package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.Request.GiaBillDocsReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.ErrorLogRepo;
import gov.ifms.ots.repository.GiaBillDocsRepo;
import org.json.JSONArray;
import org.json.JSONObject;
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
    GiaBillDocsRepo giaBillDocsRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    ErrorLogRepo errorLogRepo;

    @POST
    @Path("ddlBillNo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaBillDocsReq giaBillDocsReq){
        try {

            JSONArray jsonArray = giaBillDocsRepo.ddlBillNo(giaBillDocsReq);

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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("ddlBillNo");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("DD1");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return  null;
    }
    @POST
    @Path("bindDG1Ben")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Ben(GiaBillDocsReq giaBillDocsReq){
        try {
            JSONArray jsonArray = giaBillDocsRepo.bindDG1Ben(giaBillDocsReq);

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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("ddlMstBen");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("DD2");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("bindDG2Ded")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG2Ded(GiaBillDocsReq giaBillDocsReq){
        try {
            JSONArray jsonArray = giaBillDocsRepo.bindDG2Ded(giaBillDocsReq);

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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("bindDeductions");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("DED");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaBillDocsReq giaBillDocsReq){
        try {
            JSONArray jsonArray = giaBillDocsRepo.billMstDtl(giaBillDocsReq);

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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("billMstDtl");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("MST");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("ddlDocType")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlDocType(GiaBillDocsReq giaBillDocsReq){
        try {

            JSONArray jsonArray = giaBillDocsRepo.ddlDocType(giaBillDocsReq);

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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("ddlDocType");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("DD3");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return  null;
    }
    @POST
    @Path("bindDG3Docs")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG3Docs(GiaBillDocsReq giaBillDocsReq){
        try {
            JSONArray jsonArray = giaBillDocsRepo.bindDG3Docs(giaBillDocsReq);

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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("bindDG1Ben");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("DG1");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }


    @POST
    @Path("insDocsDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insDocsDtl(GiaBillDocsReq giaBillDocsReq){
        try {
            JSONArray jsonArray = giaBillDocsRepo.insDocsDtl(giaBillDocsReq);

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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("insDocsDtl");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("INS");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("delDocsDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delDocsDtl(GiaBillDocsReq giaBillDocsReq){
        try {
            JSONArray jsonArray = giaBillDocsRepo.delDocsDtl(giaBillDocsReq);
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
            errorLogReq.setPageUrl("GiaBillDocsController");
            errorLogReq.setApiName("delBenDtl");
            errorLogReq.setSpName("SP_GIA_BILL_DOCS");
            errorLogReq.setSpMode("DEL");
            errorLogReq.setUserId(giaBillDocsReq.getUserId());
            errorLogReq.setIp(giaBillDocsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
