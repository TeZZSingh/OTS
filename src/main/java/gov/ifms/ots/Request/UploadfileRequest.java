package gov.ifms.ots.Request;

import lombok.Data;

@Data
public class UploadfileRequest {

    public String base64Data;
    public String userId;
    public String token;
}
