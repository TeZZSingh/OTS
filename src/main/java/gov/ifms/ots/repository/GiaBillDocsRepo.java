package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaBillDocsReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;
public interface GiaBillDocsRepo {

    JSONArray ddlBillNo(GiaBillDocsReq giaBillDocsReq) throws OtsException;
    JSONArray bindDG1Ben(GiaBillDocsReq giaBillDocsReq) throws OtsException;
    JSONArray bindDG2Ded(GiaBillDocsReq giaBillDocsReq) throws OtsException;
    JSONArray billMstDtl(GiaBillDocsReq giaBillDocsReq) throws OtsException;
    JSONArray ddlDocType(GiaBillDocsReq giaBillDocsReq) throws OtsException;
    JSONArray bindDG3Docs(GiaBillDocsReq giaBillDocsReq) throws OtsException;
    JSONArray insDocsDtl(GiaBillDocsReq giaBillDocsReq) throws OtsException;
    JSONArray delDocsDtl(GiaBillDocsReq giaBillDocsReq) throws OtsException;
}
