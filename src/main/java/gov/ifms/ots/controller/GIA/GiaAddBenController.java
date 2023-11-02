package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.Request.GiaAddBenReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.ErrorLogRepo;
import gov.ifms.ots.repository.GiaAddBenRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("giaAddBen/")
public class GiaAddBenController {
    @Inject
    GiaAddBenRepo giaPayeeRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    ErrorLogRepo errorLogRepo;

    @POST
    @Path("ddlBillNo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillNo(GiaAddBenReq giaAddBenReq){
        try {

            JSONArray jsonArray = giaPayeeRepo.ddlBillNo(giaAddBenReq);

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
            errorLogReq.setPageUrl("GiaAddBenController");
            errorLogReq.setApiName("ddlBillNo");
            errorLogReq.setSpName("SP_GIA_ADD_BEN");
            errorLogReq.setSpMode("DD1");
            errorLogReq.setUserId(giaAddBenReq.getUserId());
            errorLogReq.setIp(giaAddBenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return  null;
    }
    @POST
    @Path("billMstDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response billMstDtl(GiaAddBenReq giaAddBenReq){
    try {
            JSONArray jsonArray = giaPayeeRepo.billMstDtl(giaAddBenReq);

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
            errorLogReq.setPageUrl("GiaAddBenController");
            errorLogReq.setApiName("billMstDtl");
        errorLogReq.setSpName("SP_GIA_ADD_BEN");
            errorLogReq.setSpMode("MST");
            errorLogReq.setUserId(giaAddBenReq.getUserId());
            errorLogReq.setIp(giaAddBenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    return null;
    }
    @POST
    @Path("ddlMstBen")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlMstBen(GiaAddBenReq giaAddBenReq){
        try {
            JSONArray jsonArray = giaPayeeRepo.ddlMstBen(giaAddBenReq);

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
            errorLogReq.setPageUrl("GiaAddBenController");
            errorLogReq.setApiName("ddlMstBen");
            errorLogReq.setSpName("SP_GIA_ADD_BEN");
            errorLogReq.setSpMode("DD2");
            errorLogReq.setUserId(giaAddBenReq.getUserId());
            errorLogReq.setIp(giaAddBenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @POST
    @Path("bindDG1Ben")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Ben(GiaAddBenReq giaAddBenReq){
    try {
            JSONArray jsonArray = giaPayeeRepo.bindDG1Ben(giaAddBenReq);

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
            errorLogReq.setPageUrl("GiaAddBenController");
            errorLogReq.setApiName("bindDG1Ben");
            errorLogReq.setSpName("SP_GIA_ADD_BEN");
            errorLogReq.setSpMode("DG1");
            errorLogReq.setUserId(giaAddBenReq.getUserId());
            errorLogReq.setIp(giaAddBenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    return null;
    }

    @POST
    @Path("insBenDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insBenDtl(GiaAddBenReq giaAddBenReq){
     try {
            JSONArray jsonArray = giaPayeeRepo.insBenDtl(giaAddBenReq);

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
            errorLogReq.setPageUrl("GiaAddBenController");
            errorLogReq.setApiName("insBenDtl");
            errorLogReq.setSpName("SP_GIA_ADD_BEN");
            errorLogReq.setSpMode("INS");
            errorLogReq.setUserId(giaAddBenReq.getUserId());
            errorLogReq.setIp(giaAddBenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("updBenDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updBenDtl(GiaAddBenReq giaAddBenReq){
    try {
            JSONArray jsonArray = giaPayeeRepo.updBenDtl(giaAddBenReq);
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
            errorLogReq.setPageUrl("GiaAddBenController");
            errorLogReq.setApiName("updBenDtl");
            errorLogReq.setSpName("SP_GIA_ADD_BEN");
            errorLogReq.setSpMode("UPD");
            errorLogReq.setUserId(giaAddBenReq.getUserId());
            errorLogReq.setIp(giaAddBenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @POST
    @Path("delBenDtl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBenDtl(GiaAddBenReq giaAddBenReq){
        //System.out.println("CreateLinkController: " + createLinkReq.getCreatedBy() + "  --------------- " + createLinkReq.getToken());
        try {
            JSONArray jsonArray = giaPayeeRepo.delBenDtl(giaAddBenReq);
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
            errorLogReq.setPageUrl("GiaAddBenController");
            errorLogReq.setApiName("delBenDtl");
            errorLogReq.setSpName("SP_GIA_ADD_BEN");
            errorLogReq.setSpMode("DEL");
            errorLogReq.setUserId(giaAddBenReq.getUserId());
            errorLogReq.setIp(giaAddBenReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
