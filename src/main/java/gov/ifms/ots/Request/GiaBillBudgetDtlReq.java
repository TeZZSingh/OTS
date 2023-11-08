package gov.ifms.ots.Request;

import lombok.Data;

@Data
public class GiaBillBudgetDtlReq {

    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int billBudgetDtlId;
    private int billNo;
    private String budgetHead;
    private String headType;
    private String bfcType;
    private int pdAccNo;
    private int divisionId;
    private int headGross;
    private String userId;



}
