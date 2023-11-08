package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.GiaBillSanctionDtlsReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaBillSanctionDtlsRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("giaBillSanctionDtls/")
public class GiaBillSanctionDtlsController {
    @Inject
    private GiaBillSanctionDtlsRepo giaBillSanctionDtlsRepo;
    @Inject
    private OtsService otsService;

    @Path("bindBillSanction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) {
        try {
            return otsService.request(giaBillSanctionDtlsRepo.bindBillSanction(giaBillSanctionDtlsReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillSanctionDtlsController","bindBillSanction","SP_BILL_SANCTION_DTLS",
                    "DG1~Ctrl",giaBillSanctionDtlsReq.getUserId(),giaBillSanctionDtlsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("insBillSanction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insBillSanction(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) {
        try {
            return otsService.insRequest(giaBillSanctionDtlsRepo.insBillSanction(giaBillSanctionDtlsReq));

        } catch (OtsException e ) {
            otsService.errorRequest(e.getExceptionMsg(),"BillSanctionDtlsController","insBillSanction","SP_BILL_SANCTION_DTLS",
                    "INS~Ctrl",giaBillSanctionDtlsReq.getUserId(),giaBillSanctionDtlsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("updBillSanction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updBillSanctionDtls(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq) {
        try {
           return otsService.insRequest(giaBillSanctionDtlsRepo.updBillSanction(giaBillSanctionDtlsReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillSanctionDtlsController","updBillSanction","SP_BILL_SANCTION_DTLS",
                    "UPD~Ctrl",giaBillSanctionDtlsReq.getUserId(),giaBillSanctionDtlsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @POST
    @Path("delBillSanction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBillSanctionDtls(GiaBillSanctionDtlsReq giaBillSanctionDtlsReq){

        try {
            return otsService.insRequest(giaBillSanctionDtlsRepo.delBillSanction(giaBillSanctionDtlsReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"BillSanctionDtlsController","delBillSanction","SP_BILL_SANCTION_DTLS",
                    "DEL~Ctrl",giaBillSanctionDtlsReq.getUserId(),giaBillSanctionDtlsReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }

    }
}
