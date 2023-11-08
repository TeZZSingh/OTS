package gov.ifms.ots.controller.GIA;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.Request.GiaAddBenBulkReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.ErrorLogRepo;
import gov.ifms.ots.repository.GiaAddBenBulkRepo;
import gov.ifms.ots.service.Base64ExcelToJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import java.io.*;
import java.util.Base64;
@Path("giaAddBenBulk/")
public class GiaAddBenBulkController {
    @Inject
    Base64ExcelToJson base64ExcelToJson;

    @Inject
    GiaAddBenBulkRepo giaAddBenBulkRepo;
    @Inject
    private ErrorLogReq errorLogReq;
    @Inject
    ErrorLogRepo errorLogRepo;
    @POST
    @Path("uploadFile")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response uploadFile(GiaAddBenBulkReq giaAddBenBulkReq) throws IOException {
        try {
            System.out.println("uploadFile");
            JsonObject json = base64ExcelToJson.getExcelDataAsJsonObject(giaAddBenBulkReq.getFileJson());
            String jsonString = json.toString();
            System.out.println(jsonString);
            giaAddBenBulkReq.setFileJson(jsonString);
           JSONArray jsonArray= giaAddBenBulkRepo.insBenDtl(giaAddBenBulkReq);

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
            errorLogReq.setPageUrl("GiaAddBenBulkController");
            errorLogReq.setApiName("uploadFile");
            errorLogReq.setSpName("SP_GIA_ADD_BEN_BULK");
            errorLogReq.setSpMode("ULD");
            errorLogReq.setUserId(giaAddBenBulkReq.getUserId());
            errorLogReq.setIp(giaAddBenBulkReq.getIp());
            errorLogRepo.insErrorLog(errorLogReq);
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}
