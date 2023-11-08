package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaAddBenReq;
import gov.ifms.ots.Request.GiaBillBudgetDtlReq;
import gov.ifms.ots.Request.GiaBillDeductionReq;
import gov.ifms.ots.Request.GiaGenReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

public interface GiaBillBudgetDtlRepo {

    JSONArray ddlBillNo(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;
    JSONArray billMstDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;
    JSONArray ddlBFCType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;
    JSONArray ddlHeadType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;
    JSONArray ddlPdAc(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;
    JSONArray ddlDivision(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;
    JSONArray bindDG1Budget(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;

    JSONArray insBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;

    JSONArray delBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException;
}
