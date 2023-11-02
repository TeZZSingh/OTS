package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.GiaBillSanctionDtlsReq;
import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaBillSanctionDtlsRepo;
import gov.ifms.ots.repository.ErrorLogRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("giaBillSanctionDtls/")
public class GiaBillSanctionDtlsController {
    @Inject
    private GiaBillSanctionDtlsRepo giaBillSanctionDtlsRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    private ErrorLogRepo errorLogRepo;

    @Path("bindBillSanction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) {
        try {
            JSONArray jsonArray = giaBillSanctionDtlsRepo.bindBillSanction(giaBillSanctionDtlsReq);
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
            errorLogReq.setPageUrl("BillSanctionDtlsController");
            errorLogReq.setApiName("bindBillSanction");
            errorLogReq.setSpName("SP_BILL_SANCTION_DTLS");
            errorLogReq.setSpMode("DG1");
            errorLogReq.setUserId(giaBillSanctionDtlsReq.getUserId());
            errorLogReq.setIp(giaBillSanctionDtlsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }
    @Path("insBillSanction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) {
        try {
            JSONArray jsonArray = giaBillSanctionDtlsRepo.insBillSanction(giaBillSanctionDtlsReq);
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
        } catch (OtsException e ) {
            errorLogReq.setErrorDesc(e.getExceptionMsg());
            errorLogReq.setPageUrl("BillSanctionDtlsController");
            errorLogReq.setApiName("insBillSanction");
            errorLogReq.setSpName("SP_BILL_SANCTION_DTLS");
            errorLogReq.setSpMode("INS");
            errorLogReq.setUserId(giaBillSanctionDtlsReq.getUserId());
            errorLogReq.setIp(giaBillSanctionDtlsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("updBillSanction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updBillSanctionDtls(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) {
        try {
            JSONArray jsonArray = giaBillSanctionDtlsRepo.updBillSanction(giaBillSanctionDtlsReq);

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
            errorLogReq.setToken(giaBillSanctionDtlsReq.getToken());
            errorLogReq.setPageUrl("BillSanctionDtlsController");
            errorLogReq.setApiName("updBillSanction");
            errorLogReq.setSpName("SP_BILL_SANCTION_DTLS");
            errorLogReq.setSpMode("UPD");
            errorLogReq.setUserId(giaBillSanctionDtlsReq.getUserId());
            errorLogReq.setIp(giaBillSanctionDtlsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("delBillSanction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBillSanctionDtls(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq){

        try {
            JSONArray jsonArray = giaBillSanctionDtlsRepo.delBillSanction(giaBillSanctionDtlsReq);
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
            errorLogReq.setPageUrl("BillSanctionDtlsController");
            errorLogReq.setApiName("delBillSanction");
            errorLogReq.setSpName("SP_BILL_SANCTION_DTLS");
            errorLogReq.setSpMode("DEL");
            errorLogReq.setUserId(giaBillSanctionDtlsReq.getUserId());
            errorLogReq.setIp(giaBillSanctionDtlsReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }
}
