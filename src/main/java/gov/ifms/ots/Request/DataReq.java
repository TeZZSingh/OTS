package gov.ifms.ots.Request;

import lombok.Data;

@Data
public class DataReq {

    private int docTypeId;
    private String docTypeName;
    private String docName;
    private String docTitle;
    private String content;
}
