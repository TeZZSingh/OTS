package gov.ifms.ots.repository;

import gov.ifms.ots.Request.MenuMasterReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;
public interface MenuMasterRepo {
    JSONArray getMenuMaster(MenuMasterReq menuMasterReq) throws OtsException;
}
