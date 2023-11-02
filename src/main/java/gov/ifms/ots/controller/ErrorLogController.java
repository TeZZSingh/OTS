package gov.ifms.ots.controller;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
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

@Path("errorLog/")
public class ErrorLogController {
    @Inject
    private ErrorLogRepo errorLogRepo;


    @POST
    @Path("bindDG1Error")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Error(ErrorLogReq errorLogReq) {
            try {
            JSONArray jsonArray = errorLogRepo.bindDG1Error(errorLogReq);
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

    @POST
    @Path("insErrorLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insErrorLog(ErrorLogReq errorLogReq) {
         try {
            JSONArray jsonArray = errorLogRepo.insErrorLog(errorLogReq);
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
        } catch (Exception e) {
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }


    @POST
    @Path("delErrorLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delErrorLog(ErrorLogReq errorLogReq) {
       try {
            JSONArray jsonArray = errorLogRepo.delErrorLog(errorLogReq);
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
        } catch (Exception e) {
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }
}
