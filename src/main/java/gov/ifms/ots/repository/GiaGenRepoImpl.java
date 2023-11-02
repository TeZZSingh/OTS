package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaGenReq;
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
public class GiaGenRepoImpl implements GiaGenRepo {
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;

    @Override
    public JSONArray ddlSchemeType(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD1");
            cstmt.setString("IAPI_NAME", "ddlSchemeType");
            cstmt.setString("IIP", giaGenReq.getIp());
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
    public JSONArray ddlBillType(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD2");
            cstmt.setString("IAPI_NAME", "ddlBillType");
            cstmt.setString("IIP", giaGenReq.getIp());
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
    public JSONArray ddlBillSubType(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD3");
            cstmt.setString("IAPI_NAME", "ddlBillSubType");
            cstmt.setString("IIP", giaGenReq.getIp());
            cstmt.setInt("IBILL_TYPE_ID", giaGenReq.getBillTypeId());
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
    public JSONArray ddlBillYear(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD4");
            cstmt.setString("IAPI_NAME", "ddlBillYear");
            cstmt.setString("IIP", giaGenReq.getIp());
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
    public JSONArray ddlBillMonth(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD5");
            cstmt.setString("IAPI_NAME", "ddlBillMonth");
            cstmt.setString("IIP", giaGenReq.getIp());
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
    public JSONArray ddlObjectHead(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD6");
            cstmt.setString("IAPI_NAME", "ddlObjectHead");
            cstmt.setString("IIP", giaGenReq.getIp());
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
    public JSONArray ddlPaymentMode(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD7");
            cstmt.setString("IAPI_NAME", "ddlPaymentMode");
            cstmt.setString("IIP", giaGenReq.getIp());
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
    public JSONArray bindDG1Gia(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindDG1Gia");
            cstmt.setString("IIP", giaGenReq.getIp());
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
    public JSONArray insGiaBill(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobtoken = conn.createClob();
            clobtoken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobtoken);
            cstmt.setString("IMODE","INS");
            cstmt.setString("IAPI_NAME", "insGiaBill");
            cstmt.setString("IIP", giaGenReq.getIp());
            cstmt.setInt("ISCHEME_ID", giaGenReq.getSchemeId());
            cstmt.setInt("IBILL_TYPE_ID", giaGenReq.getBillTypeId());
            cstmt.setInt("IBILL_SUB_TYPE_ID", giaGenReq.getBillSubTypeId());
            cstmt.setInt("IBILL_YEAR", giaGenReq.getBillYear());
            cstmt.setInt("IBILL_MONTH", giaGenReq.getBillMonth());
            cstmt.setInt("IOBJECT_HEAD_ID", giaGenReq.getObjectHeadId());
            cstmt.setString("IPAYMENT_MODE", giaGenReq.getPaymentMode());
            cstmt.setInt("IGROSS_AMNT", giaGenReq.getGrossAmnt());
            cstmt.setInt("INET_AMNT", giaGenReq.getNetAmnt());
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
    public JSONArray updGiaBill(GiaGenReq giaGenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_GEN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobtoken = conn.createClob();
            clobtoken.setString(1, giaGenReq.getToken());
            cstmt.setClob("ITOKEN", clobtoken);
            cstmt.setString("IMODE","UPD");
            cstmt.setString("IAPI_NAME", "updGiaBill");
            cstmt.setString("IIP", giaGenReq.getIp());
            cstmt.setInt("IBILL_NO", giaGenReq.getBillNo());
            cstmt.setInt("ISCHEME_ID", giaGenReq.getSchemeId());
            cstmt.setInt("IBILL_TYPE_ID", giaGenReq.getBillTypeId());
            cstmt.setInt("IBILL_SUB_TYPE_ID", giaGenReq.getBillSubTypeId());
            cstmt.setInt("IBILL_YEAR", giaGenReq.getBillYear());
            cstmt.setInt("IBILL_MONTH", giaGenReq.getBillMonth());
            cstmt.setInt("IOBJECT_HEAD_ID", giaGenReq.getObjectHeadId());
            cstmt.setString("IPAYMENT_MODE", giaGenReq.getPaymentMode());
            cstmt.setInt("IGROSS_AMNT", giaGenReq.getGrossAmnt());
            cstmt.setInt("INET_AMNT", giaGenReq.getNetAmnt());
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
