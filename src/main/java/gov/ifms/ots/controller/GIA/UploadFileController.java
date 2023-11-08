package gov.ifms.ots.controller.GIA;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import gov.ifms.ots.Request.UploadFileReq;
import gov.ifms.ots.Request.UploadfileRequest;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.UploadFileRepo;
import gov.ifms.ots.service.Base64ExcelToJson;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import java.io.*;
import java.util.Base64;


@Path("upload/")
public class UploadFileController {

    @Inject
    Base64ExcelToJson base64ExcelToJson;


    @POST
    @Path("insFile")
   @Consumes(MediaType.APPLICATION_JSON)
    public Response insFile(UploadfileRequest uploadfileRequest) throws  IOException
        {

            JsonObject json = base64ExcelToJson.getExcelDataAsJsonObject(uploadfileRequest.getBase64Data());
            String jsonString = json.toString();
            System.out.println(jsonString);
            return Response.ok(ApiResponse.success(null,"Success")).build();
        }


}
