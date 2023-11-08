package gov.ifms.ots.Request;
import lombok.Data;
@Data
public class GiaBillInnerOuterReq {
    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int billNo;
}
