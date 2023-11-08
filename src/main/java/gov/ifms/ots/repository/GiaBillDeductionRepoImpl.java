package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaBillDeductionReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Types;

@Dependent
public class GiaBillDeductionRepoImpl implements GiaBillDeductionRepo{
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;
    @Override
    public JSONArray ddlBillNo(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD1");
            cstmt.setString("IAPI_NAME", "ddlBillNo");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }

    @Override
    public JSONArray billMstDtl(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "MST");
            cstmt.setString("IAPI_NAME", "billMstDtl");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillDeductionReq.getBillNo());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }

    @Override
    public JSONArray ddlMstBen(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD2");
            cstmt.setString("IAPI_NAME", "ddlMstBen");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillDeductionReq.getBillNo());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
    @Override
    public JSONArray ddlDeductionType(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD3");
            cstmt.setString("IAPI_NAME", "ddlDeductionType");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }

    @Override
    public JSONArray ddlBudgetHeadDtl(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD4");
            cstmt.setString("IAPI_NAME", "ddlBudgetHeadDtl");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.setInt("IALL_DED_ID",giaBillDeductionReq.getAllDedId());
            cstmt.setString("ISEARCHON",giaBillDeductionReq.getSearchOn());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }

    @Override
    public JSONArray ddlBfcType(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD5");
            cstmt.setString("IAPI_NAME", "ddlBfcType");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }


    @Override
    public JSONArray ddlHeadType(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD6");
            cstmt.setString("IAPI_NAME", "ddlHeadType");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
    @Override
    public JSONArray ddlPdAc(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD7");
            cstmt.setString("IAPI_NAME", "ddlPdAc");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
    @Override
    public JSONArray ddlDivision(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD8");
            cstmt.setString("IAPI_NAME", "ddlDivision");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }

    @Override
    public JSONArray bindDG1Deduction(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindDG1Deduction");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.setInt("IBILL_NO",giaBillDeductionReq.getBillNo());
            cstmt.setInt("IBILL_DTL_ID",giaBillDeductionReq.getBillDtlId());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
    @Override
    public JSONArray insBillDeduction(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insBillDeduction");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.setInt("IBILL_NO",giaBillDeductionReq.getBillNo());
            cstmt.setInt("IBILL_DTL_ID",giaBillDeductionReq.getBillDtlId());
            cstmt.setInt("IALL_DED_ID",giaBillDeductionReq.getAllDedId());
            cstmt.setInt("IBUDGET_HEAD_ID",giaBillDeductionReq.getBudgetHeadId());
            cstmt.setString("IHEAD_TYPE",giaBillDeductionReq.getHeadType());
            cstmt.setString("IBFC_TYPE",giaBillDeductionReq.getBfcType());
            cstmt.setInt("IPD_ACC_NO",giaBillDeductionReq.getPdAccNo());
            cstmt.setInt("IDIVISION_ID",giaBillDeductionReq.getDivisionId());
            cstmt.setInt("IDEDUCTION_AMT",giaBillDeductionReq.getDeductionAmt());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);

        } catch (Exception e) {
           throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }

    @Override
    public JSONArray updBillDeduction(GiaBillDeductionReq giaBillDeductionReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_DEDUCTION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDeductionReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "UPD");
            cstmt.setString("IAPI_NAME", "updBillDeduction");
            cstmt.setString("IIP", giaBillDeductionReq.getIp());
            cstmt.setInt("IBILL_DEDUCTION_ID",giaBillDeductionReq.getBillDeductionId());
            cstmt.setInt("IBILL_NO",giaBillDeductionReq.getBillNo());
            cstmt.setInt("IBILL_DTL_ID",giaBillDeductionReq.getBillDtlId());
            cstmt.setInt("IALL_DED_ID",giaBillDeductionReq.getAllDedId());
            cstmt.setInt("IBUDGET_HEAD_ID",giaBillDeductionReq.getBudgetHeadId());
            cstmt.setString("IHEAD_TYPE",giaBillDeductionReq.getHeadType());
            cstmt.setString("IBFC_TYPE",giaBillDeductionReq.getBfcType());
            cstmt.setInt("IPD_ACC_NO",giaBillDeductionReq.getPdAccNo());
            cstmt.setInt("IDIVISION_ID",giaBillDeductionReq.getDivisionId());
            cstmt.setInt("IDEDUCTION_AMT",giaBillDeductionReq.getDeductionAmt());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OMY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);

        } catch (Exception e) {
           throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
}
