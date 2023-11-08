package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaBillBudgetDtlReq;
import gov.ifms.ots.Request.GiaBillDeductionReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

public interface GiaBillDeductionRepo {

    JSONArray ddlBillNo(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray billMstDtl(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray ddlMstBen(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray ddlDeductionType(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray ddlBudgetHeadDtl(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray ddlBfcType(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray ddlHeadType(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray ddlPdAc(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray ddlDivision(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray bindDG1Deduction(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray insBillDeduction(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
    JSONArray updBillDeduction(GiaBillDeductionReq giaBillDeductionReq) throws OtsException;
}
