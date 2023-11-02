package gov.ifms.ots.controller.GIA;


import gov.ifms.ots.Request.WccUploadFileReq;
import gov.ifms.ots.response.Response;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("wcc/")
public class WccFileController {

    @POST
    @Path("uploadWccFile")
    public Response uploadWccFile(WccUploadFileReq uploadFileReq){

      System.out.println("uploadWccFile---->"+uploadFileReq.toString());
        return null;
    }




}
