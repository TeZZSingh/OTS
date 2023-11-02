package gov.ifms.ots.repository;

import gov.ifms.ots.Request.CreateLinkReq;
import gov.ifms.ots.exception.OtsException;
import org.json.JSONArray;
public interface CreateLinkRepo {
    JSONArray ddlMenuMaster (CreateLinkReq createLinkReq) throws OtsException;
    JSONArray bindDG1Menu (CreateLinkReq createLinkReq) throws OtsException;
    JSONArray insMenuMaster (CreateLinkReq createLinkReq) throws OtsException;
    JSONArray updMenuMaster (CreateLinkReq createLinkReq) throws OtsException;





}
