package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaBillBudgetDtlReq;
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
public class GiaBillBudgetDtlRepoImpl implements GiaBillBudgetDtlRepo {
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;
    @Override
    public JSONArray ddlBillNo(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD1");
            cstmt.setString("IAPI_NAME", "ddlBillNo");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
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
    public JSONArray billMstDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "MST");
            cstmt.setString("IAPI_NAME", "billmstdtl");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillBudgetDtlReq.getBillNo());
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
    public JSONArray ddlBFCType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD2");
            cstmt.setString("IAPI_NAME", "ddlBFCType");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
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
    public JSONArray ddlHeadType(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD3");
            cstmt.setString("IAPI_NAME", "ddlHeadType");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
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
    public JSONArray ddlPdAc(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD4");
            cstmt.setString("IAPI_NAME", "ddlPdAc");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
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
    public JSONArray ddlDivision(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD5");
            cstmt.setString("IAPI_NAME", "ddlDivision");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
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
    public JSONArray bindDG1Budget(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindDG1Budget");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillBudgetDtlReq.getBillNo());
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
    public JSONArray insBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insBillBudgetDtl");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillBudgetDtlReq.getBillNo());
            cstmt.setString("IBUDGET_HEAD", giaBillBudgetDtlReq.getBudgetHead());
            cstmt.setString("IHEAD_TYPE", giaBillBudgetDtlReq.getHeadType());
            cstmt.setString("IBFC_TYPE", giaBillBudgetDtlReq.getBfcType());
            cstmt.setInt("IPD_ACC_NO", giaBillBudgetDtlReq.getPdAccNo());
            cstmt.setInt("IDIVISION_ID", giaBillBudgetDtlReq.getDivisionId());
            cstmt.setInt("IHEAD_GROSS", giaBillBudgetDtlReq.getHeadGross());
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
    public JSONArray delBillBudgetDtl(GiaBillBudgetDtlReq giaBillBudgetDtlReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_BUDGET_DTL(?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillBudgetDtlReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DEL");
            cstmt.setString("IAPI_NAME", "delBillBudgetDtl");
            cstmt.setString("IIP", giaBillBudgetDtlReq.getIp());
            cstmt.setInt("IBILL_BUDGET_DTL_ID", giaBillBudgetDtlReq.getBillBudgetDtlId());
            cstmt.setInt("IBILL_NO", giaBillBudgetDtlReq.getBillNo());
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

