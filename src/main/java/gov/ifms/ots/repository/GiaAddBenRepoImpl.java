package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaAddBenReq;
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
public class GiaAddBenRepoImpl implements GiaAddBenRepo {

    @Inject
    @Named("dbOTS")
    private DataSource dataSource;
    @Override
    public JSONArray ddlBillNo(GiaAddBenReq giaAddBenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD1");
            cstmt.setString("IAPI_NAME", "ddlBillNo");
            cstmt.setString("IIP", giaAddBenReq.getIp());
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
    public JSONArray billMstDtl(GiaAddBenReq giaAddBenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "MST");
            cstmt.setString("IAPI_NAME", "billmstdtl");
            cstmt.setString("IIP", giaAddBenReq.getIp());
            cstmt.setInt("IBILL_NO", giaAddBenReq.getBillNo());
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
    public JSONArray ddlMstBen(GiaAddBenReq giaAddBenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD2");
            cstmt.setString("IAPI_NAME", "ddlMstBen");
            cstmt.setString("IIP", giaAddBenReq.getIp());
            cstmt.setInt("IBILL_NO", giaAddBenReq.getBillNo());
           // cstmt.setInt("IBILL_NO",giaPayeeReq.getBillNo());
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
            String eMessage = e.getMessage();
            throw new OtsException("An error occurred while bill beneficiary details.", eMessage);
        }
        return jsonArray;
    }

    @Override
    public JSONArray bindDG1Ben(GiaAddBenReq giaAddBenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindDG1Ben");
            cstmt.setString("IIP", giaAddBenReq.getIp());
            cstmt.setInt("IBILL_NO",giaAddBenReq.getBillNo());
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
    public JSONArray insBenDtl(GiaAddBenReq giaAddBenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN(?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insBenDtl");
            cstmt.setString("IIP", giaAddBenReq.getIp());
            cstmt.setInt("IBILL_NO",giaAddBenReq.getBillNo());
            cstmt.setInt("IPAYEE_ID",giaAddBenReq.getPayeeId());
            cstmt.setInt("IGROSS_AMT",giaAddBenReq.getGrossAmt());
            cstmt.setInt("INET_AMT",giaAddBenReq.getNetAmt());
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
    public JSONArray updBenDtl(GiaAddBenReq giaAddBenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN(?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "UPD");
            cstmt.setString("IAPI_NAME", "updBenDtl");
            cstmt.setString("IIP", giaAddBenReq.getIp());
            cstmt.setInt("IBILL_DTL_ID",giaAddBenReq.getBillDtlId());
            cstmt.setInt("IBILL_NO",giaAddBenReq.getBillNo());
            cstmt.setInt("IPAYEE_ID",giaAddBenReq.getPayeeId());
            cstmt.setInt("IGROSS_AMT",giaAddBenReq.getGrossAmt());
            cstmt.setInt("INET_AMT",giaAddBenReq.getNetAmt());
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
    public JSONArray delBenDtl(GiaAddBenReq giaAddBenReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN(?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DEL");
            cstmt.setString("IAPI_NAME", "delBenDtl");
            cstmt.setString("IIP", giaAddBenReq.getIp());
            cstmt.setInt("IBILL_DTL_ID",giaAddBenReq.getBillDtlId());
            cstmt.setInt("IBILL_NO",giaAddBenReq.getBillNo());
            cstmt.setInt("IPAYEE_ID",giaAddBenReq.getPayeeId());
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

