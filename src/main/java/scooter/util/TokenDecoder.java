package scooter.util;

import org.apache.commons.codec.binary.Base64;

public class TokenDecoder {


    public static String getBodyFromToken(String token) {

        String[] split_string = token.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String body = new String(base64Url.decode(base64EncodedBody));
        return body;
    }
}
