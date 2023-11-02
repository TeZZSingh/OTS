package gov.ifms.ots.response;
import lombok.Data;
@Data
public class ApiResponse<D> {
	private D data;
	private Error error;
	public static <D> ApiResponse<D> success(final D data){
		final ApiResponse<D> apiRespose= new ApiResponse<>();
		apiRespose.setError(null);
		apiRespose.setData(data);
		return apiRespose;
	}
	public static <D> ApiResponse<D> error(final Error error){
		final ApiResponse<D> apiRespose= new ApiResponse<>();
		apiRespose.setError(error);
		apiRespose.setData(null);
		return apiRespose;
	}
	public static <D> ApiResponse<D> errordata(final D data){
		final ApiResponse<D> apiRespose= new ApiResponse<>();
		apiRespose.setData(data);
		return apiRespose;
	}
}

