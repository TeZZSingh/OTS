package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaBillSanctionDtlsReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;

@Dependent
public class GiaBillSanctionDtlsRepoImpl implements GiaBillSanctionDtlsRepo {
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;



    @Override
    public JSONArray bindBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_SANCTION_DTLS(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillSanctionDtlsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindBillSanction");
            cstmt.setString("IIP", giaBillSanctionDtlsReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillSanctionDtlsReq.getBillNo());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("MY_JSON", Types.CLOB);
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
    public JSONArray insBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_SANCTION_DTLS(?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillSanctionDtlsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insBillSanction");
           cstmt.setString("IIP", giaBillSanctionDtlsReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillSanctionDtlsReq.getBillNo());
            cstmt.setInt("IBILL_SANCTION_DTLS_ID", giaBillSanctionDtlsReq.getBillSanctionDtlsId());
            cstmt.setInt("IOLD_REF_NO", giaBillSanctionDtlsReq.getOldRefNo());
            cstmt.setString("ISANCT_NO", giaBillSanctionDtlsReq.getSanctionNo());
            cstmt.setDate("ISANCT_DT", giaBillSanctionDtlsReq.getSanctionDt());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("MY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }



    @Override
    public JSONArray updBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_SANCTION_DTLS(?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillSanctionDtlsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "UPD");
            cstmt.setString("IAPI_NAME", "updBillSanction");
           cstmt.setString("IIP", giaBillSanctionDtlsReq.getIp());
            cstmt.setInt("IBILL_SANCTION_DTLS_ID", giaBillSanctionDtlsReq.getBillSanctionDtlsId());
            cstmt.setInt("IBILL_NO", giaBillSanctionDtlsReq.getBillNo());
            cstmt.setInt("IOLD_REF_NO", giaBillSanctionDtlsReq.getOldRefNo());
            cstmt.setString("ISANCT_NO", giaBillSanctionDtlsReq.getSanctionNo());
            cstmt.setDate("ISANCT_DT", giaBillSanctionDtlsReq.getSanctionDt());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("MY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
    @Override
    public JSONArray delBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_BILL_SANCTION_DTLS(?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillSanctionDtlsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DEL");
            cstmt.setString("IAPI_NAME", "delBillSanction");
            cstmt.setString("IIP", giaBillSanctionDtlsReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillSanctionDtlsReq.getBillNo());
            cstmt.setInt("IBILL_SANCTION_DTLS_ID", giaBillSanctionDtlsReq.getBillSanctionDtlsId());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("MY_JSON", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
}