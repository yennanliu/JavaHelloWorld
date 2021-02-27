package com.yen.SprintBootTravelAPI.controller;

import java.util.List;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yen.SprintBootTravelAPI.model.Statistic;
import com.yen.SprintBootTravelAPI.model.Travel;
import com.yen.SprintBootTravelAPI.service.StatisticService;
import com.yen.SprintBootTravelAPI.service.TravelService;

@RestController
@RequestMapping("/api-travels/statistics")
public class StatisticController {

    @Autowired
    private TravelService tripsService;

    @Autowired
    private StatisticService statisticsService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity<Statistic> getStatistics() {

        List<Travel> trips = tripsService.find();
        Statistic statistics = statisticsService.create(trips);

        //logger.info(statistics);

        return ResponseEntity.ok(statistics);
    }
}
