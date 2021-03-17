//package com.yen.tweet.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.social.twitter.api.Tweet;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import com.yen.tweet.service.SearchService;
//
//@RestController
//@RequestMapping("/api/v1/search")
//public class SearchApiController {
//    private SearchService searchService;
//
//    @Autowired
//    public SearchApiController (SearchService searchService) {
//        this.searchService = searchService;
//    }
//
//    //@RequestMapping(value = "/{SearchType}", method = RequestMethod.GET)
////    public List<Tweet> search  {@PathVariable String searchType, @MatrixVariable List<String> keywords} {
////        return searchService.search(searchType, keywords);
////    }
//}
