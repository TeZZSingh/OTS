package gov.ifms.ots.repository;

import gov.ifms.ots.Request.MenuMasterReq;
import gov.ifms.ots.Request.UploadFileReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

public interface UploadFileRepo {

    JSONArray insFile(UploadFileReq uploadFileReq) throws OtsException;
    JSONArray getFile(UploadFileReq uploadFileReq) throws OtsException;
}
