package gov.ifms.ots.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class Response {
    @JsonProperty
    String data;
    @JsonProperty
    String message;
    @JsonProperty
    String status;
}
