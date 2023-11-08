package gov.ifms.ots.repository;

import gov.ifms.ots.Request.GiaAddBenBulkReq;
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
public class GiaAddBenBulkRepoImpl implements GiaAddBenBulkRepo {

    @Inject
    @Named("dbOTS")
    private DataSource dataSource;
    @Override
    public JSONArray insBenDtl(GiaAddBenBulkReq giaAddBenBulkReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_GIA_ADD_BEN_BULK(?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, giaAddBenBulkReq.getToken());
            Clob fileJson = conn.createClob();
            clobToken.setString(6, giaAddBenBulkReq.getFileJson());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "ULD");
            cstmt.setString("IAPI_NAME", "uploadFile");
            cstmt.setString("IIP", giaAddBenBulkReq.getIp());
            cstmt.setInt("IBILL_NO",giaAddBenBulkReq.getBillNo());
            cstmt.setString("IFILE_JSON",giaAddBenBulkReq.getFileJson());
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
            e.printStackTrace();
            throw new OtsException(e.getMessage());
        }
        return jsonArray;
    }
}
