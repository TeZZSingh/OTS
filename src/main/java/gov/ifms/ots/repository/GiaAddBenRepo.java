package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaAddBenReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

public interface GiaAddBenRepo {

    JSONArray ddlBillNo(GiaAddBenReq giaAddBenReq) throws OtsException;
    JSONArray billMstDtl(GiaAddBenReq giaAddBenReq) throws OtsException;
    JSONArray ddlMstBen(GiaAddBenReq giaAddBenReq) throws OtsException;
    JSONArray bindDG1Ben(GiaAddBenReq giaAddBenReq) throws OtsException;
    JSONArray insBenDtl(GiaAddBenReq giaAddBenReq) throws OtsException;
    JSONArray updBenDtl(GiaAddBenReq giaAddBenReq) throws OtsException;
    JSONArray delBenDtl(GiaAddBenReq giaAddBenReq) throws OtsException;
}
