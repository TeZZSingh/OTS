package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaBillSanctionDtlsReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

public interface GiaBillSanctionDtlsRepo {
    JSONArray bindBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) throws OtsException;
    JSONArray insBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq)throws OtsException;
    JSONArray updBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) throws OtsException ;
   JSONArray delBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq)throws OtsException;
}
