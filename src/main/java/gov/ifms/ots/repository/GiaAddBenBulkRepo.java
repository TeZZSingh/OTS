package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaAddBenBulkReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

public interface GiaAddBenBulkRepo {


    JSONArray insBenDtl(GiaAddBenBulkReq giaAddBenBulkReq) throws OtsException;
}
