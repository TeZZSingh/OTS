package gov.ifms.ots.Request;

import lombok.Data;
import java.sql.Date;
@Data
public class CreateLinkReq {
    private String token;
    private String mode;
    private String apiName;
    private String ip;
    private int menuId;
    private int parentId;
    private String nameEn;
    private String nameHi;
    private String menuUrl;
    private String visible;
    private int orderNo;
    private int createdBy;
    private int modifiedBy;
    private String userId;
}

