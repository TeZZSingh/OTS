package gov.ifms.ots;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import gov.ifms.ots.controller.CreateLinkController;
import gov.ifms.ots.controller.ErrorLogController;
import gov.ifms.ots.controller.GIA.*;
import gov.ifms.ots.controller.MenuMasterController;
import gov.ifms.ots.controller.GIA.UploadFileController;
import gov.ifms.ots.exception.OtsException;
import gov.ifms.ots.filter.CORSConfig;
import gov.ifms.ots.filter.OTSRequestFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

@ApplicationScoped
@ApplicationPath("/ots/v1.0/")
//@LoginConfig(authMethod = "MP-JWT")
public class OTS extends Application{
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(CreateLinkController.class);
		classes.add(MenuMasterController.class);
		classes.add(OTSRequestFilter.class);
		classes.add(CORSConfig.class);
		classes.add(OtsException.class);
		classes.add(GiaBillBudgetDtlController.class);
		classes.add(GiaGenController.class);
		classes.add(GiaAddBenController.class);
		classes.add(GiaBillDeductionController.class);
		classes.add(GiaBillSanctionDtlsController.class);
		classes.add(GiaBillDocsController.class);
		classes.add(GiaAddBenBulkController.class);
		classes.add(ErrorLogController.class);
		classes.add(UploadFileController.class);
		classes.add(MultiPartFeature.class);
		classes.add(WccFileController.class);
		return classes;
	}
}
