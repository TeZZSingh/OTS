package gov.ifms.ots.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.Request.TokenReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.Request.MenuMasterReq;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.filter.OTSRequestFilter;
import gov.ifms.ots.repository.ErrorLogRepo;
import gov.ifms.ots.repository.MenuMasterRepo;
import io.helidon.microprofile.cors.CrossOrigin;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("menuMaster/")
@RegisterProvider(OTSRequestFilter.class)
public class MenuMasterController {
    @Inject
    private MenuMasterRepo menuMasterRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    private ErrorLogRepo errorLogRepo;


    @POST
    @Path("getMenuMaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenuMaster(MenuMasterReq menuMasterReq){
                   try {
                    JSONArray jsonArray  = menuMasterRepo.getMenuMaster(menuMasterReq);
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
        }
        catch (OtsException e ) {
                       errorLogReq.setErrorDesc(e.getExceptionMsg());
                       errorLogReq.setMode("INS");
                       errorLogReq.setPageUrl("MenuMasterController");
                       errorLogReq.setApiName("getMenuMaster");
                       errorLogReq.setSpName("SP_MENU_MASTER");
                       errorLogReq.setSpMode("MNU~Ctrl");
                       errorLogReq.setUserId(menuMasterReq.getUserId());
                       errorLogReq.setIp(menuMasterReq.getIp());
                       errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
                   return null;
    }


}



