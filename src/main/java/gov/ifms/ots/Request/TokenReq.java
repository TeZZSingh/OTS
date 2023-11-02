package gov.ifms.ots.Request;

import lombok.Data;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@Data
@ApplicationScoped
public class TokenReq {
    private String iss;
    private String aud;
    private String jti;
    private float exp;
    private float iat;
    private String sub;
    private String upn;
    @JsonProperty("preferred_username")
    private String preferredUserName;
    private String ssoId;
    private String levelValueId ;
    private String displayName;
    private String roleId;
    private String levelId;
    private String roleName;
    private String employeeId ;
    private String levelName;
    private String levelValueCode;
    private String userId;
    private String aid;
    private String treasCode;
    ArrayList< Object > groups = new ArrayList < Object > ();
}
