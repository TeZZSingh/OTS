package gov.ifms.ots.controller.GIA;

import gov.ifms.ots.Request.GiaGenReq;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.repository.GiaGenRepo;
import gov.ifms.ots.service.OtsService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("giaGen/")
public class GiaGenController {
    @Inject
    private GiaGenRepo giaGenRepo;
    @Inject
    private OtsService otsService;

    @Path("ddlSchemeType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlSchemeType(GiaGenReq giaGenReq) {
        try {
            return otsService.request(giaGenRepo.ddlSchemeType(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","ddlSchemeType","SP_GIA_GEN",
                    "DD1~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @Path("ddlBillType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillType(GiaGenReq giaGenReq) {
        try {
            return otsService.request(giaGenRepo.ddlBillType(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","ddlBillType","SP_GIA_GEN",
                    "DD2~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

    @Path("ddlBillSubType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillSubType(GiaGenReq giaGenReq) {
        try {
          return otsService.request(giaGenRepo.ddlBillSubType(giaGenReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","ddlBillSubtype","SP_GIA_GEN",
                    "DD3~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("ddlBillYear")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillYear(GiaGenReq giaGenReq) {
        try {
           return otsService.request(giaGenRepo.ddlBillYear(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","ddlBillYear","SP_GIA_GEN",
                    "DD4~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("ddlBillMonth")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlBillMonth(GiaGenReq giaGenReq) {
        try {
            return otsService.request(giaGenRepo.ddlBillMonth(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","ddlBillMonth","SP_GIA_GEN",
                    "DD5~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("ddlObjectHead")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlObjectHead(GiaGenReq giaGenReq) {
        try {
            return otsService.request(giaGenRepo.ddlObjectHead(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","ddlObjectHead","SP_GIA_GEN",
                    "DD6~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("ddlPaymentMode")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ddlPaymentMode(GiaGenReq giaGenReq) {
        try {
            return otsService.request(giaGenRepo.ddlPaymentMode(giaGenReq));

        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","ddlPaymentMode","SP_GIA_GEN",
                    "DD7~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("bindDG1Gia")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bindDG1Gia(GiaGenReq giaGenReq) {
        try {
            return  otsService.request(giaGenRepo.bindDG1Gia(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","bindDG1Gia","SP_GIA_GEN",
                    "DG1~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
    @Path("insGiaBill")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insGiaBill(GiaGenReq giaGenReq) {
        try {
           return otsService.insRequest(giaGenRepo.insGiaBill(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","insGiaBill","SP_GIA_GEN",
                    "INS~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }


    @Path("updGiaBill")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updGiaBill(GiaGenReq giaGenReq) {
        try {
          return otsService.insRequest(giaGenRepo.updGiaBill(giaGenReq));
        } catch (OtsException e) {
            otsService.errorRequest(e.getExceptionMsg(),"GiaGenController","updGiaBill","SP_GIA_GEN",
                    "UPD~Ctrl",giaGenReq.getUserId(),giaGenReq.getIp());
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }

}
