package gov.ifms.ots.repository;


import gov.ifms.ots.Request.GiaBillDocsReq;
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
public class GiaBillDocsRepoImpl implements GiaBillDocsRepo {
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;
    @Override
    public JSONArray ddlBillNo(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD1");
            cstmt.setString("IAPI_NAME", "ddlBillNo");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
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
    public JSONArray bindDG1Ben(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindDGBen");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillDocsReq.getBillNo());
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
    public JSONArray bindDG2Ded(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG2");
            cstmt.setString("IAPI_NAME", "ddlPayeeDtl");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillDocsReq.getBillNo());
            cstmt.setInt("IBILL_DTL_ID", giaBillDocsReq.getBillDtlId());
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
    public JSONArray billMstDtl(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "MST");
            cstmt.setString("IAPI_NAME", "billmstdtl");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
            cstmt.setInt("IBILL_NO", giaBillDocsReq.getBillNo());
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
    public JSONArray ddlDocType(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DD3");
            cstmt.setString("IAPI_NAME", "ddlDocType");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
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
    public JSONArray bindDG3Docs(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG3");
            cstmt.setString("IAPI_NAME", "bindDG1Docs");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
            cstmt.setInt("IBILL_NO",giaBillDocsReq.getBillNo());
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
    public JSONArray insDocsDtl(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insDocsDtl");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
            cstmt.setInt("IBILL_NO",giaBillDocsReq.getBillNo());
            cstmt.setInt("IWCC_DOC_ID",giaBillDocsReq.getWccDocId());
            cstmt.setString("IFILE_NAME", giaBillDocsReq.getFileName());
            cstmt.setInt("IDOC_TYPE_ID",giaBillDocsReq.getDocTypeId());
            cstmt.setInt("IDOC_NO",giaBillDocsReq.getDocNo());
            cstmt.setDate("IDOC_DATE",giaBillDocsReq.getDocDate());
            cstmt.setInt("IAMOUNT",giaBillDocsReq.getAmount());
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
    public JSONArray delDocsDtl(GiaBillDocsReq giaBillDocsReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_BILL_DOCS(?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaBillDocsReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DEL");
            cstmt.setString("IAPI_NAME", "delDocsDtl");
            cstmt.setString("IIP", giaBillDocsReq.getIp());
            cstmt.setInt("IID",giaBillDocsReq.getId());
            cstmt.setInt("IBILL_NO",giaBillDocsReq.getBillNo());
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
