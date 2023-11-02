package gov.ifms.ots.Request;

import lombok.Data;

import java.sql.Date;

@Data
public class GiaGenReq {

    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int billNo;
    private int schemeId;
    private int billTypeId;
    private int billSubTypeId;
    private int billYear;
    private int billMonth;
    private int objectHeadId;
    private String paymentMode;
    private int grossAmnt;
    private int netAmnt;
    private String userId;

}
