package gov.ifms.ots.Request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class WccUploadFileReq {
    private String token;
    private String type;
    private int sourceId;
    private String userId;
    ArrayList< DocAttrReq > docAttributes ;
    ArrayList < DataReq > data ;

}
