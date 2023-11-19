//package com.yen.TddPlayGround.UrlShortnerV2.service;
//
//import com.yen.TddPlayGround.UrlShortnerV2.bean.Url;
//import com.yen.TddPlayGround.UrlShortnerV2.repository.UrlRepository;
//import com.yen.TddPlayGround.UrlShortnerV2.service.impl.UrlServiceImpl;
//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verify;
//
//
//// https://www.tpisoftware.com/tpu/articleDetails/1294
//// https://hackmd.io/@KaiChen/H1R5Nq5FI
//
//@ExtendWith(MockitoExtension.class)
//class UrlServiceTest {
//
//    @Mock
//    UrlRepository urlRepository;
//
//    @InjectMocks
//    UrlServiceImpl urlService;
//
////    /**
////     *  Manually Create Mocks: If you want to mock an interface,
////     *  you can create a mock manually using Mockito.mock(UrlService.class).
////     */
////    @Mock
////    UrlService urlService;
//
//    @BeforeEach
//    public void before(){
//        System.out.println("pre setup ...");
//    }
//
//    @Test
//    public void shouldGetUrlIfInputNotNull(){
//
////        // setup behaviour of mock instance method
////        urlService = Mockito.mock(UrlService.class);
////        when(urlService.getUrlByKey(anyString())).thenReturn("https://short_url/abc");
////
////        //System.out.println(urlService.getUrlByKey("123"));
////        assertEquals(urlService.getUrlByKey("some-key"), "https://short_url/abc");
//
//        // Mockito.when(userRepository.save(any(User.class))).thenReturn(null);
//
//        /**
//         *         User u1 = new User("id-01", 10.0);
//         *
//         *         Mockito.when(userRepository.save(any(User.class)))
//         *                 .thenReturn(u1);
//         *
//         */
//
//        Url url_1 = new Url("https://google.com", "htttps://short_url/abc");
//        // mock
//        Mockito.when(
//                urlRepository.findById(anyString())).thenReturn(null);
//
//        String res = urlService.getUrlByKey("https://google.com");
//        System.out.println(res);
//        assertEquals(res, "https://short_url/abc");
//    }
//
////    @Test
////    public void shouldCallOnce(){
////
////        // setup behaviour of mock instance method
////        urlService = Mockito.mock(UrlService.class);
////
////        // NOTE : we call method, then verify below
////        String result = urlService.getUrlByKey("some-key");
////
////        // Verify that the method was called exactly once
////        verify(urlService, times(1)).getUrlByKey(anyString());
////    }
////
////    @Test
////    public void shouldReturnDifferentWhenDifferentInput(){
////
////        urlService = Mockito.mock(UrlService.class);
////
////        String result1 = urlService.getUrlByKey("some-key-1");
////        String result2 = urlService.getUrlByKey("some-key-2");
////
////        System.out.println(result1);
////
////        assertNotNull(result1);
////        assertNotEquals(result1, result2);
////    }
////
////    @Test
////    public void shouldReturnSameWhenSameInput(){
////
////
////    }
//
//
//}