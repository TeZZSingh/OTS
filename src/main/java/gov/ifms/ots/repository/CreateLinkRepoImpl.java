package gov.ifms.ots.repository;

import gov.ifms.ots.Request.CreateLinkReq;
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
public class CreateLinkRepoImpl implements CreateLinkRepo {
    @Inject
    @Named("dbOTS")
    private DataSource dataSource;

    @Override
    public JSONArray ddlMenuMaster(CreateLinkReq createLinkReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_CREATE_LINK(?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, createLinkReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DDL");
            cstmt.setString("IAPI_NAME", "ddlMenuMaster");
            cstmt.setString("IIP", createLinkReq.getIp());
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
    public JSONArray bindDG1Menu(CreateLinkReq createLinkReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_CREATE_LINK(?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, createLinkReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "DG1");
            cstmt.setString("IAPI_NAME", "bindDG1Menu");
            cstmt.setString("IIP", createLinkReq.getIp());
            cstmt.setInt("IPARENT_ID", createLinkReq.getParentId());
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
    public JSONArray insMenuMaster(CreateLinkReq createLinkReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_CREATE_LINK(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, createLinkReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "INS");
            cstmt.setString("IAPI_NAME", "insMenuMaster");
            cstmt.setString("IIP", createLinkReq.getIp());
            cstmt.setInt("IMENUID", createLinkReq.getMenuId());
            cstmt.setInt("IPARENT_ID", createLinkReq.getParentId());
            cstmt.setString("INAME_EN", createLinkReq.getNameEn());
            cstmt.setString("INAME_HI", createLinkReq.getNameHi());
            cstmt.setString("IMENUURL", createLinkReq.getMenuUrl());
            cstmt.setString("IVISIBLE", createLinkReq.getVisible());
            cstmt.setInt("IORDER_NO", createLinkReq.getOrderNo());
            cstmt.setInt("ICREATED_BY", createLinkReq.getCreatedBy());
            cstmt.setInt("IMODIFIED_BY", createLinkReq.getModifiedBy());
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
    public JSONArray updMenuMaster(CreateLinkReq createLinkReq) throws OtsException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.dataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call SP_CREATE_LINK(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            Clob clobToken = conn.createClob();
            clobToken.setString(1, createLinkReq.getToken());
            cstmt.setClob("ITOKEN", clobToken);
            cstmt.setString("IMODE", "UPD");
            cstmt.setString("IAPI_NAME", "updMenuMaster");
            cstmt.setString("IIP", createLinkReq.getIp());
            cstmt.setInt("IMENUID", createLinkReq.getMenuId());
            cstmt.setInt("IPARENT_ID", createLinkReq.getParentId());
            cstmt.setString("INAME_EN", createLinkReq.getNameEn());
            cstmt.setString("INAME_HI", createLinkReq.getNameHi());
            cstmt.setString("IMENUURL", createLinkReq.getMenuUrl());
            cstmt.setString("IVISIBLE", createLinkReq.getVisible());
            cstmt.setInt("IORDER_NO", createLinkReq.getOrderNo());
            cstmt.setInt("ICREATED_BY", createLinkReq.getCreatedBy());
            cstmt.setInt("IMODIFIED_BY", createLinkReq.getModifiedBy());
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
