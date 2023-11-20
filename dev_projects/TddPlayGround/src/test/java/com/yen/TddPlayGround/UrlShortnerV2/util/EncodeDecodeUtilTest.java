package com.yen.TddPlayGround.UrlShortnerV2.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(MockitoExtension.class)
class EncodeDecodeUtilTest {

    private EncodeDecodeUtil encodeDecodeUtil;

    @BeforeEach
    public void before(){
        System.out.println("before");
        encodeDecodeUtil = new EncodeDecodeUtil();
    }

    @Test
    public void testEncode() throws UnsupportedEncodingException {

        String txt = "meta.com";
        System.out.println(encodeDecodeUtil.encode(txt));
        assertEquals(encodeDecodeUtil.encode(txt), "bWV0YS5jb20=");
    }

    @Test
    public void testDecode() throws UnsupportedEncodingException {

        String encodedTxt = "bWV0YS5jb20=";
        System.out.println(encodeDecodeUtil.decode(encodedTxt));
        assertEquals(encodeDecodeUtil.decode(encodedTxt), "meta.com");
    }

}