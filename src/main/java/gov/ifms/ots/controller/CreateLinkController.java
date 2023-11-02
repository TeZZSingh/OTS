package gov.ifms.ots.controller;

import gov.ifms.ots.Request.CreateLinkReq;
import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.CreateLinkRepo;
import gov.ifms.ots.repository.ErrorLogRepo;
import io.helidon.microprofile.cors.CrossOrigin;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("createLink/")
public class CreateLinkController {
    @Inject
    private CreateLinkRepo createLinkRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    private ErrorLogRepo errorLogRepo;

    @POST
    @Path("ddlMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ddlMenuMaster(CreateLinkReq createLinkReq) {
             try {
            JSONArray jsonArray = createLinkRepo.ddlMenuMaster(createLinkReq);
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
            errorLogReq.setPageUrl("CreateLinkController");
            errorLogReq.setApiName("ddlMenuMaster");
            errorLogReq.setSpName("SP_CREATE_LINK");
            errorLogReq.setSpMode("DDL~Ctrl");
            errorLogReq.setUserId(createLinkReq.getUserId());
            errorLogReq.setIp(createLinkReq.getIp());
//            errorLogReq.setIsDeleted("N");

            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
             return null;
    }

    @POST
    @Path("bindDG1Menu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bindDG1Menu(CreateLinkReq createLinkReq) {
          try {
            JSONArray jsonArray = createLinkRepo.bindDG1Menu(createLinkReq);
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
            errorLogReq.setPageUrl("CreateLinkController");
            errorLogReq.setApiName("bindmenumaster");
            errorLogReq.setSpName("SP_CREATE_LINK");
            errorLogReq.setSpMode("DG1~Ctrl");
            errorLogReq.setUserId(createLinkReq.getUserId());
            errorLogReq.setIp(createLinkReq.getIp());
//            errorLogReq.setIsDeleted("N");

            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
          return null;
    }

    @POST
    @Path("insMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insMenuMaster(CreateLinkReq createLinkReq) {
            try {
            JSONArray jsonArray = createLinkRepo.insMenuMaster(createLinkReq);
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
            errorLogReq.setPageUrl("CreateLinkController");
            errorLogReq.setApiName("insMenuMaster");
            errorLogReq.setSpName("SP_CREATE_LINK");
            errorLogReq.setSpMode("INS~Ctrl");
            errorLogReq.setUserId(createLinkReq.getUserId());
            errorLogReq.setIp(createLinkReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }

    @POST
    @Path("updMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updMenuMaster(CreateLinkReq createLinkReq) {
              try {
            JSONArray jsonArray = createLinkRepo.updMenuMaster(createLinkReq);
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
            errorLogReq.setPageUrl("CreateLinkController");
            errorLogReq.setApiName("updMenuMaster");
            errorLogReq.setSpName("SP_CREATE_LINK");
            errorLogReq.setSpMode("UPD~Ctrl");
            errorLogReq.setUserId(createLinkReq.getUserId());
            errorLogReq.setIp(createLinkReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
