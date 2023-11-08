package gov.ifms.ots.Request;

import lombok.Data;

import java.sql.Date;


@Data
public class GiaBillSanctionDtlsReq {

    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int billNo;
    private int billSanctionDtlsId;
    private  int oldRefNo;
    private String sanctionNo;
    private Date sanctionDt;
    private String userId;

}
