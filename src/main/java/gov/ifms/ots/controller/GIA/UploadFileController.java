package gov.ifms.ots.controller.GIA;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import gov.ifms.ots.Request.UploadFileReq;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.UploadFileRepo;
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
    UploadFileRepo uploadFileRepo;

    @Inject
    UploadFileReq uploadFileReq;

    @POST
    @Path("insFile")
   @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String insFile(@FormDataParam("file") InputStream inputStream,
                               @FormDataParam("file") FormDataContentDisposition filedetails) throws  IOException
        {
            try{
                //File inputFile = new File("path/to/input/file.txt");
            byte[] fileData = inputStream.readAllBytes();
            String jsonFileData = Base64.getEncoder().encodeToString(fileData);

            uploadFileReq.setFileData(jsonFileData);
            uploadFileReq.setFileName(filedetails.getFileName());
            uploadFileReq.setCreatedBy(1);
            JSONArray jsonArray = uploadFileRepo.insFile(uploadFileReq);

            // 2. Write the JSON data to a file
           /* String originalFileName = filedetails.getFileName();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("F://" + originalFileName + ".json"), jsonFileData);

            // 3. Convert JSON data back to a file
            String json = objectMapper.readValue(new File("F://" + originalFileName + ".json"), String.class);
            byte[] decodedFileData = Base64.getDecoder().decode(json);

            File outputFile = new File("F://" + originalFileName);
            Files.write(outputFile.toPath(), decodedFileData);*/

    }
            catch (OtsException e){
            e.printStackTrace();
            }
            return "done";
        }

    @POST
    @Path("getFile")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getFile(UploadFileReq uploadFileReq) throws  IOException
    {
        try{

            JSONArray jsonArray = uploadFileRepo.getFile(uploadFileReq);
            JSONObject oRespObj = new JSONObject();
            oRespObj.put("oRESP",jsonArray.get(1).toString());



            String oRESPString = oRespObj.getString("oRESP");

// Parse the "oRESP" JSON array
            JSONArray oRESPArray = new JSONArray(oRESPString);

// Access the first element of the array (assuming it's an object)
            JSONObject firstElement = oRESPArray.getJSONObject(0);

// Get "fileName" and "fileData" from the first element
            String fileName = firstElement.getString("fileName");
            String fileData = firstElement.getString("fileData");

            System.out.println("fileName: " + fileName);
            System.out.println("fileData: " + fileData);

            //String fileName1 = oRespObj.getString("fileName");
           // String fileData1 = oRespObj.getString("fileData");

            //System.out.println("fileName1: " + fileName);
           // System.out.println("fileData1: " + fileData);





            byte[] byteArray = fileData.getBytes(); // Your byte array containing data

// Convert the byte array to a String using a specific character encoding
            String result = new String(byteArray, StandardCharsets.UTF_8);
            System.out.println("file data "+result);

            // 2. Write the JSON data to a file


            // 3. Convert JSON data back to a file
          // String json = objectMapper.readValue(new File("F://" + originalFileName + ".json"), String.class);
            byte[] decodedFileData = Base64.getDecoder().decode(result);

            File outputFile = new File("F://" + fileName);
            Files.write(outputFile.toPath(), decodedFileData);

        }
        catch (OtsException e){
            e.printStackTrace();
        }
        return "done";
    }
}
