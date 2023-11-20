package com.yen.TddPlayGround.UrlShortnerV2;

// https://medium.com/geekculture/create-your-own-url-shorteners-with-spring-boot-redis-289c9000f747

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class app {

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println(">>> this is UrlShortnerV2 app !!!");

        // https://magiclen.org/java-base64/

        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "google.com"; //"字串文字";
        final byte[] textByte = text.getBytes("UTF-8"); //編碼
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText); //解碼
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }

}
