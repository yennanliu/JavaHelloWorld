package com.yen.TddPlayGround.UrlShortner.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Url {

    private String originalUrl;
    private String shortUrl;
}
