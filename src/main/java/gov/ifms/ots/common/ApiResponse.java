package gov.ifms.ots.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class ApiResponse<D> {
    private String status;
    private D data;
    private Error error;
    private String oSTATUS;


    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setData(D data) {
        this.data = data;
    }
    public D getData() {
        return data;
    }

    public void setError(Error error) {
        this.error = error;
    }
    public Error getError() {
        return error;
    }
    public String getoSTATUS() {
        return oSTATUS;
    }

    public void setoSTATUS(String oSTATUS) {
        this.oSTATUS = oSTATUS;
    }

    public static <D> ApiResponse<D> success(final D data,String message) {
        final ApiResponse<D> apiRespose= new ApiResponse<>();
        apiRespose.setStatus("200"); //success status for end user
        apiRespose.setError(null);
        apiRespose.setoSTATUS(message);
        apiRespose.setData(data);
        return apiRespose;
    }
    public static <D> ApiResponse<D> error(final Error error){
        final ApiResponse<D> apiRespose= new ApiResponse<>();
        apiRespose.setStatus("201");// failed status for end user
        apiRespose.setError(error);
        apiRespose.setData(null);
        apiRespose.setoSTATUS("Data Not Found");
        return apiRespose;
    }
    public static <D> ApiResponse<D> dataIsNull(String message){
        final ApiResponse<D> apiRespose= new ApiResponse<>();
        apiRespose.setStatus("201");// failed status for end user
           apiRespose.setData(null);
        apiRespose.setoSTATUS("Data Not Found");
        return apiRespose;
    }
}
