package gov.ifms.ots.Request;
import lombok.Data;
import java.sql.Date;

@Data
public class GiaBillDocsReq {
    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int id;
    private int billNo;
    private int billDtlId;
    private int wccDocId;
    private String fileName;
    private int docTypeId;
    private int docNo;
    private Date docDate;
    private int amount;
    private String userId;

    }
