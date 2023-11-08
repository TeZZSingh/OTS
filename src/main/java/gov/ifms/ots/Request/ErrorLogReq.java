package gov.ifms.ots.Request;

import lombok.Data;

import javax.enterprise.context.ApplicationScoped;
import java.sql.Date;
@ApplicationScoped
@Data
public class ErrorLogReq {
    private String token;
    private int errorId;
    private String mode;
    private String apiName;
    private String ip;
    private String errorDesc;
    private String pageUrl;
    private String spName;
    private String spMode;
    private String userId;
    }
