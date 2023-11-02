package gov.ifms.ots.repository;

import gov.ifms.ots.Request.ErrorLogReq;
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
public class ErrorLogRepoImpl implements ErrorLogRepo {
    @Inject
    @Named("dbOTS")
    DataSource dataSource;

    @Override
    public JSONArray bindDG1Error(ErrorLogReq errorLogReq) {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_ERROR_LOG(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            System.out.println("data" +  errorLogReq.getToken());
            clobToken.setString(1, errorLogReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindDG1Error");
            cstmt.setString("IIP", errorLogReq.getIp());
            cstmt.registerOutParameter("MY_JSON", Types.CLOB);
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            System.out.println(e.getMessage());
               }
        return jsonArray;
    }

    @Override
    public JSONArray insErrorLog(ErrorLogReq errorLogReq) {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_ERROR_LOG(?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            System.out.println("data" +  errorLogReq.getToken());
            clobToken.setString(1, errorLogReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insErrorLog");
            cstmt.setString("IIP", errorLogReq.getIp());
            cstmt.setString("IERROR_DESC", errorLogReq.getErrorDesc());
            cstmt.setString("IPAGE_URL", errorLogReq.getPageUrl());
            cstmt.setString("ISP_NAME", errorLogReq.getSpName());
            cstmt.setString("ISP_MODE", errorLogReq.getSpMode());
            cstmt.setString("IUSER_ID", errorLogReq.getUserId());
            cstmt.registerOutParameter("MY_JSON", Types.CLOB);
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return jsonArray;
    }

    @Override
    public JSONArray delErrorLog(ErrorLogReq errorLogReq) {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_ERROR_LOG(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            System.out.println("data" +  errorLogReq.getToken());
            clobToken.setString(1, errorLogReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DEL");
            cstmt.setString("IAPI_NAME", "delErrorLog");
            cstmt.setString("IIP", errorLogReq.getIp());
            cstmt.setInt("IERROR_ID", errorLogReq.getErrorId());
            cstmt.registerOutParameter("MY_JSON", Types.CLOB);
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.execute();
            String OSTATUS = cstmt.getString("OSTATUS");
            Clob OUT_STR_CLOB = cstmt.getClob("ORESP");
            String ORESP= OUT_STR_CLOB.getSubString(1, (int) OUT_STR_CLOB.length());
            jsonArray.put(0,OSTATUS);
            jsonArray.put(1, ORESP);
        } catch (Exception e) {
            System.out.println(e.getMessage());
               }
        return jsonArray;
    }
}

