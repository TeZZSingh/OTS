package gov.ifms.ots.Request;
import lombok.Data;

@Data
public class GiaBillDeductionReq {
    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int billDeductionId;
    private int billNo;
    private int billDtlId;
    private int allDedId;
    private String searchOn;
    private int budgetHeadId;
    private String majorHeadCode;
    private String subMajorHeadCode;
    private String minorHeadCode;
    private String subMinorHeadCode;
    private String groupSubHeadCode;
    private String headType;
    private String bfcType;
    private int  pdAccNo;
    private int divisionId;
    private int deductionAmt;
    private String userId;
}
