package gov.ifms.ots.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import gov.ifms.ots.response.ApiResponse;
import org.json.JSONObject;

import com.google.common.collect.Iterables;
@Provider
public class TestValidationException implements ExceptionMapper<Exception> {
	private static final long serialVersionUID = 1L;
	@Override
	public Response toResponse(Exception ex) {
		JSONObject jSONObject = new JSONObject();
		if (ex instanceof ConstraintViolationException) {
					ConstraintViolationException ce = (ConstraintViolationException) ex;
			Set<ConstraintViolation<?>> constraintViolations = ce.getConstraintViolations();
			constraintViolations.stream().forEach(data -> {
				String name = Iterables.getLast(data.getPropertyPath()).getName();
				String message = data.getMessage();
				jSONObject.put(name, message);
			});
			return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON_TYPE)
					.entity(ApiResponse.errordata(jSONObject.toMap())).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON_TYPE)
				.entity(ApiResponse.errordata(jSONObject.toMap())).build();
	}
}