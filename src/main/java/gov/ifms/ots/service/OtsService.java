package gov.ifms.ots.service;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.repository.ErrorLogRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class OtsService {
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    ErrorLogRepo errorLogRepo;

    public Response request(JSONArray jsonArray){

        try {
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
        } catch (Exception e) {

            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
        return null;
    }

    public Response insRequest(JSONArray jsonArray){
        try {
            JSONObject oRespObj = new JSONObject();
            oRespObj.put("oRESP",jsonArray.get(1).toString());
            JSONArray oRespArray = new JSONArray();
            oRespArray.put(oRespObj);
            if (jsonArray == null || jsonArray.isEmpty()) {
                return Response.ok(ApiResponse.dataIsNull("")).build();
            }
            else {
                return Response.ok(ApiResponse.success(oRespArray.toList(), jsonArray.get(0).toString())).build(); // get(0) means OSTATUS

            }
        } catch (Exception e) {
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }


    }

    public void errorRequest(String msg,String pageUrl,String apiName,String spName,String spMode,String userId,String ip ){
        errorLogReq.setErrorDesc(msg);
        errorLogReq.setMode("INS");
        errorLogReq.setPageUrl(pageUrl);
        errorLogReq.setApiName(apiName);
        errorLogReq.setSpName(spName);
        errorLogReq.setSpMode(spMode);
        errorLogReq.setUserId(userId);
        errorLogReq.setIp(ip);
        errorLogRepo.insErrorLog(errorLogReq);
    }
}
