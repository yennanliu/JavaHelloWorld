package com.yen.TddPlayGround.UrlShortnerV2.repository;

import com.yen.TddPlayGround.UrlShortner.bean.Url;
import com.yen.TddPlayGround.UrlShortnerV2.client.MySQLClient;

import java.util.List;

public class UrlRepo {

    private MySQLClient mySQLClient;

    // constructor
    public UrlRepo(){

    }


    public List<Url> getAllUrl(){

        // TODO : verify below
        List<Url> result = (List<Url>) mySQLClient.runQuery("SELECT * FROM url");
        return result;
    }

    public Url getShortUrlByUrl(String url){

//        Url result = (List<Url>) mySQLClient.runQuery("SELECT * FROM url WHERE url = " + url);
//        return result;
        return null;
    }

    public String getUrlByShortUrl(){

        return null;
    }

}
