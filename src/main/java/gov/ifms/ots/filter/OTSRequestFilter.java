package gov.ifms.ots.filter;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import gov.ifms.ots.common.ApiResponse;
import gov.ifms.ots.common.Error;
import io.helidon.webserver.ServerRequest;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@Priority(Priorities.AUTHORIZATION)
@Provider
public class OTSRequestFilter implements ContainerRequestFilter {

    @Context
    HttpHeaders httpHeaders;

    @Context
    private ServerRequest serverRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        try {
            String contentType = requestContext.getHeaderString("Content-Type");
            if(contentType.equalsIgnoreCase("application/json")){
                String requestPath = "/" + requestContext.getUriInfo().getPath();
                String ip = getClientIpAddr(serverRequest);
                String delimiter = "/";
                int firstIndex = requestPath.indexOf(delimiter);
                int secondIndex = requestPath.indexOf(delimiter, firstIndex + 1);
                String scopeRequested = requestPath.substring(secondIndex, requestPath.length());
                String auth = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
                if (auth == null || !auth.startsWith("Bearer ")) {
                    Response response = Response.status(Response.Status.UNAUTHORIZED).entity(ApiResponse.error(Error.create("Unauthorized", "Unauthorized"))).build();
                    requestContext.abortWith(response);
                }

                String token=null;

                if (auth != null && auth.startsWith("Bearer ")) {
                    token = auth.substring("Bearer ".length()).trim();
                }else{
                    Response response = Response.status(Response.Status.UNAUTHORIZED).entity(ApiResponse.error(Error.create("Unauthorized", "Unauthorized"))).build();
                }
                System.out.println("bearer " + token);
                Base64.Decoder decoder = Base64.getUrlDecoder();
                String[] chunks = token.split("\\.");
                String header = new String(decoder.decode(chunks[0]));
                String payload = new String(decoder.decode(chunks[1]));
                JSONObject headerJson = new JSONObject(header);
                JSONObject payloadJson = new JSONObject(payload);
                System.out.println("headerJson >>>>" + headerJson.toString());
                System.out.println("headerJson >>>>" + payloadJson.toString());

                String userId="";
                if (payloadJson.has("userId") && !payloadJson.isNull("userId")) {
                    userId=payloadJson.getString("userId");
                } else {
                    userId="";
                }

                long currentTimeMillis = System.currentTimeMillis() / 1000;

                System.out.println("Expiry >>>>" + payloadJson.getLong("exp"));
                System.out.println("Current time in milliseconds: " + currentTimeMillis);
                System.out.println("User ID Code >>>>" + userId);

                //JSONArray subScopeObj = new JSONArray(subScope);
/*
    if (expiry < currentTimeMillis) {
        Response response = Response.status(Response.Status.UNAUTHORIZED).entity(ApiResponse.error(Error.create("Forbidden", "Token Expired"))).build();
        requestContext.abortWith(response);
    }*/

    		/*if (!type.contains("ACCESS")) {
    			Response response = Response.status(Response.Status.FORBIDDEN).entity(ApiResponse.error(Error.create("Forbidden", "Invalid Token"))).build();
    			requestContext.abortWith(response);
    		}*/

    		/*if (!isEndpointAvailable(requestPath, subScopeObj)) {
    			System.out.println("Sub Scope >>>>" + subScope);
    			Response response = Response.status(Response.Status.FORBIDDEN).entity(ApiResponse.error(Error.create("Forbidden", "UnAuthoroized Access"))).build();
    			requestContext.abortWith(response);
    		}*/

                InputStream originalInputStream = requestContext.getEntityStream();
                String originalBody = IOUtils.toString(originalInputStream, StandardCharsets.UTF_8);
                if (originalBody == null || originalBody.isEmpty())
                    requestContext.getHeaders().add("Content-Type", "application/json");
                String modifiedBody=modifyRequestBody(originalBody,"token", payloadJson.toString());
                String modifiedBodyuserID=modifyRequestBody(modifiedBody,"userId", userId);

                InputStream modifiedInputStream = new ByteArrayInputStream(modifiedBodyuserID.getBytes(StandardCharsets.UTF_8));
                requestContext.setEntityStream(modifiedInputStream);}
        } catch (Exception e) {
            e.printStackTrace();
            Response response = Response.status(Response.Status.UNAUTHORIZED).entity(ApiResponse.error(Error.create("Unauthorized", ""))).build();
            requestContext.abortWith(response);
        }
    }


    private boolean isEndpointAvailable(String requestPath, JSONArray subScopeObj) {
        Stream<String> stream = (Stream)StreamSupport.stream(subScopeObj.spliterator(), true);
        return stream.anyMatch(e -> e.equals(requestPath));
    }

    private String modifyRequestBody(String originalBody, String key, Object value) {
        JSONObject headerJson = null;
        if (originalBody != null && !originalBody.isEmpty())
            headerJson = new JSONObject(originalBody);
        else
            headerJson = new JSONObject();
        headerJson.put(key, value);
        return headerJson.toString();
    }

    public static String getClientIpAddr(ServerRequest request) {
        String ip = request.headers().first("X-Forwarded-For").orElse(request.remoteAddress());
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("Proxy-Client-IP").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("WL-Proxy-Client-IP").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("HTTP_X_FORWARDED_FOR").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("HTTP_X_FORWARDED").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("HTTP_X_CLUSTER_CLIENT_IP").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("HTTP_CLIENT_IP").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("HTTP_FORWARDED_FOR").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("HTTP_FORWARDED").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("HTTP_VIA").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.headers().first("REMOTE_ADDR").orElse(request.remoteAddress());
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.remoteAddress();
        }
        return ip;
    }

}
