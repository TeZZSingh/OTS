package gov.ifms.ots.Request;

import lombok.Data;

@Data
public class GiaAddBenReq {

    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int billDtlId;
    private int billNo;
    private int payeeId;
    private int grossAmt;
    private int netAmt;
    private String userId;




}
