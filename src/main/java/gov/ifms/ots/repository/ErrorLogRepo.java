package gov.ifms.ots.repository;

import gov.ifms.ots.Request.ErrorLogReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;
public interface ErrorLogRepo {
    JSONArray bindDG1Error(ErrorLogReq errorLogReq);
    JSONArray insErrorLog(ErrorLogReq errorLogReq);
    JSONArray delErrorLog(ErrorLogReq errorLogReq);
}
