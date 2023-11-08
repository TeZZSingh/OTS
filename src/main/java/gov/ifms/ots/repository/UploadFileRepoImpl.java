package gov.ifms.ots.repository;

import gov.ifms.ots.Request.MenuMasterReq;
import gov.ifms.ots.Request.UploadFileReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;


@Dependent
public class UploadFileRepoImpl implements UploadFileRepo{
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;


    @Override
    public JSONArray insFile(UploadFileReq uploadFileReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_UPLOAD_FILE_HDR(?,?,?,?,?,?,?,?)}")) {
            //Clob clobtoken = conn.createClob();
            //Blob blobFile = conn.createBlob();
            //clobtoken.setString(1, menuMasterReq.getToken());
            //blobFile.setBytes(1,uploadFileReq.getFileData());
            cstmt.setString("IFILE_DATA", uploadFileReq.getFileData());
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insFile");
            cstmt.setString("IIP", uploadFileReq.getIp());
            cstmt.setString("IFILE_NAME", uploadFileReq.getFileName());
            cstmt.setInt("ICREATED_BY", uploadFileReq.getCreatedBy());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            String eMessage = e.getMessage();
            throw new OtsException("An error occurred while retrieving menu master details.", eMessage);
        }
        return jsonArray;
    }

    @Override
    public JSONArray getFile(UploadFileReq uploadFileReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_UPLOAD_FILE_HDR(?,?,?,?,?,?)}")) {

            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "getFile");
            cstmt.setString("IIP", uploadFileReq.getIp());
            cstmt.setInt("IDOC_ID", uploadFileReq.getDocId());
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            String eMessage = e.getMessage();
            throw new OtsException("An error occurred while retrieving menu master details.", eMessage);
        }
        return jsonArray;
    }
}
