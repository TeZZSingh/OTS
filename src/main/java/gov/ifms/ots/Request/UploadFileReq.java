package gov.ifms.ots.Request;

import lombok.Data;

import javax.ws.rs.ext.Provider;

@Data
@Provider
public class UploadFileReq {

    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private String userId;
    private int docId;
    private String fileName;
    private String fileData;
    private int createdBy;

}
