package gov.ifms.ots.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.ifms.ots.Request.TokenReq;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encoders.Base64;
public class Test {

    public static void main(String[] args) throws JsonProcessingException {

        String json = "{\"iss\":\"http://ifmstest.rajasthan.gov.in\",\"aud\":\"targetService\",\"jti\":\"f80b4979-3043-43d5-9733-c2d2f4b28f56\",\"exp\":1695726642,\"iat\":1695725442,\"sub\":\"IFMSTEST\",\"upn\":\"IFMSTEST\",\"preferred_username\":\"IFMS TOKEN\",\"ssoId\":\"IFMS.TEST\",\"levelValueId\":null,\"displayName\":\"IFMS TEST\",\"roleId\":\"48\",\"levelId\":\"2\",\"roleName\":\"HoD\",\"employeeId\":null,\"levelName\":\"Dept\",\"levelValueCode\":null,\"userId\":\"1\",\"aid\":\"56831\",\"treasCode\":null,\"groups\":[]}";

        // Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert JSON to Java object
        TokenReq myData = objectMapper.readValue(json, TokenReq.class);

        // Now you can work with the Java object
        System.out.println("Name: " + myData.getAid());
        System.out.println("Age: " + myData.getAud());


    }
}