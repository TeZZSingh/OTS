package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaGenReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

public interface GiaGenRepo {
    JSONArray ddlSchemeType(GiaGenReq giaGenReq) throws OtsException;

    JSONArray ddlBillType(GiaGenReq giaGenReq) throws OtsException;

    JSONArray ddlBillSubType(GiaGenReq giaGenReq) throws OtsException;

    JSONArray ddlBillYear(GiaGenReq giaGenReq) throws OtsException;

    JSONArray ddlBillMonth(GiaGenReq giaGenReq) throws  OtsException;
    JSONArray ddlObjectHead(GiaGenReq giaGenReq) throws  OtsException;
    JSONArray ddlPaymentMode(GiaGenReq giaGenReq) throws  OtsException;

    JSONArray bindDG1Gia(GiaGenReq giaGenReq) throws OtsException;
    JSONArray insGiaBill(GiaGenReq giaGenReq) throws OtsException;

    JSONArray updGiaBill(GiaGenReq giaGenReq) throws OtsException;

}
