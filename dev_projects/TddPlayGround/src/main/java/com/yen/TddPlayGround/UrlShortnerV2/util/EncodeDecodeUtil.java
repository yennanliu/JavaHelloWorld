package com.yen.TddPlayGround.UrlShortnerV2.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncodeDecodeUtil {

    final Base64.Decoder decoder = Base64.getDecoder();
    final Base64.Encoder encoder = Base64.getEncoder();

    // encode
    public String encode(String text) throws UnsupportedEncodingException {
        final byte[] textByte = text.getBytes("UTF-8"); //編碼
        final String encodedText = encoder.encodeToString(textByte);
        return encodedText;
    }

    // decode
    public String decode(String encodedText) throws UnsupportedEncodingException {
        return new String(decoder.decode(encodedText), "UTF-8");
    }

}
