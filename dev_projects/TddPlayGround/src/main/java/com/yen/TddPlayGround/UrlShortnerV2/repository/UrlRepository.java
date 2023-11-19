package com.yen.TddPlayGround.UrlShortnerV2.repository;

import com.yen.TddPlayGround.UrlShortner.bean.Url;
import org.springframework.data.jpa.repository.JpaRepository;

// (originalUrl as ID)
public interface UrlRepository extends JpaRepository<Url, String> {

}
