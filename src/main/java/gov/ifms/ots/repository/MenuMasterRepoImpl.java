package gov.ifms.ots.repository;

import gov.ifms.ots.Request.MenuMasterReq;
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
public class MenuMasterRepoImpl implements MenuMasterRepo {
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;
    @Override
    public JSONArray getMenuMaster(MenuMasterReq menuMasterReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_MENU_MASTER(?,?,?,?,?,?,?)}")) {
            Clob clobtoken = conn.createClob();
            clobtoken.setString(1, menuMasterReq.getToken());
            cstmt.setClob("ITOKEN", clobtoken);
            cstmt.setString("IMODE", "MNU");
            cstmt.setString("IAPI_NAME", "getmenumaster");
            cstmt.setString("IIP", menuMasterReq.getIp());
            cstmt.setInt("IROLE_ID", menuMasterReq.getRoleId());
            cstmt.registerOutParameter("ORESP", Types.CLOB);
            cstmt.registerOutParameter("OSTATUS", Types.VARCHAR);
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

