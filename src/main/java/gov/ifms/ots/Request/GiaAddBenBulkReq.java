package gov.ifms.ots.Request;
import lombok.Data;

@Data
public class GiaAddBenBulkReq {
    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int billNo;
    private String fileJson;
    private String userId;
}
