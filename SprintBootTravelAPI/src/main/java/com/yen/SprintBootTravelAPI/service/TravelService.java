// TODO: fix the class
//package com.yen.SprintBootTravelAPI.service;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.json.simple.JSONObject;
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import netscape.javascript.JSObject;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import com.yen.SprintBootTravelAPI.enumeration.TravelTypeEnum;
//import com.yen.SprintBootTravelAPI.factory.TravelFactory;
//import com.yen.SprintBootTravelAPI.factory.impl.TravelFactoryImpl;
//import com.yen.SprintBootTravelAPI.model.Travel;
//
//@Service
//public class TravelService {
//    private TravelFactory factory;
//    private List<Travel>  travels;
//
//    public void createFactory(){
//        if (factory == null){
//            factory = new TravelFactoryImpl();
//        }
//    }
//
//    public void createTravelList(){
//        if (factory == null){
//            travels = new ArrayList<>();
//        }
//    }
//
//    public boolean isJSONvalid(String jsonInString){
//        try{
//            return new ObjectMapper().readTree(jsonInString) != null;
//        } catch (IOException e) {
//            return false;
//        }
//    }
//
//    private long parseId(JSONObject travel) {
//        return Long.valueOf((int) travel.get("id"));
//    }
//
//    private BigDecimal parseAmount(JSONObject travel) {
//        return new BigDecimal((String) travel.get("amount"));
//    }
//
//    private LocalDateTime parseStartDate(JSONObject travel) {
//        var startDate = (String) travel.get("startDate");
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
//        return ZonedDateTime.parse(startDate, formatter.withZone(ZoneId.of("UTC"))).toLocalDateTime();
//    }
//
//    public boolean isStartDateGreaterThanEndDate(Travel travel) {
//        if (travel.getEndDate() == null) return false;
//        return travel.getStartDate().isAfter(travel.getEndDate());
//    }
//
//    public boolean isStartDateGreaterThanEndDate(Travel travel) {
//        if (travel.getEndDate() == null) return false;
//        return travel.getStartDate().isAfter(travel.getEndDate());
//    }
//
//    private void setTravelValues(JSONObject jsonTravel, Travel travel) {
//
//        String orderNumber = (String) jsonTravel.get("orderNumber");
//        String type = (String) jsonTravel.get("type");
//
//        travel.setOrderNumber(orderNumber != null ? orderNumber : travel.getOrderNumber());
//        travel.setAmount(jsonTravel.get("amount") != null ? parseAmount(jsonTravel) : travel.getAmount());
//        travel.setStartDate(jsonTravel.get("startDate") != null ? parseStartDate(jsonTravel) : travel.getStartDate());
//        travel.setEndDate(jsonTravel.get("endDate") != null ? parseEndDate(jsonTravel) : travel.getEndDate());
//        travel.setType(type != null ? TravelTypeEnum.getEnum(type) : travel.getType());
//    }
//
//    public Travel create(JSONObject jsonTravel) {
//
//        createFactory();
//
//        Travel travel = factory.createTravel((String) jsonTravel.get("type"));
//        travel.setId(parseId(jsonTravel));
//        setTravelValues(jsonTravel, travel);
//
//        return travel;
//    }
//
//
//    public Travel update(Travel travel, JSONObject jsonTravel) {
//        setTravelValues(jsonTravel, travel);
//        return travel;
//    }
//
//    public void add(Travel travel) {
//        createTravelList();
//        travels.add(travel);
//    }
//
//    public List<Travel> find() {
//        createTravelList();
//        return travels;
//    }
//
//    public Travel findById(long id) {
//        return travels.stream().filter(t -> id == t.getId()).collect(Collectors.toList()).get(0);
//    }
//
//    public void delete() {
//        travels.clear();
//    }
//
//    public void clearObjects() {
//        travels = null;
//        factory = null;
//    }
//}
