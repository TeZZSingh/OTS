package gov.ifms.ots.Request;

import lombok.Data;
@Data
public class MenuMasterReq {
    private int roleId;
    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int assignmentId;
    private String userId;
}
