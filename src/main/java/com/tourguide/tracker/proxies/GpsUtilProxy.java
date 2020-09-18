package com.tourguide.tracker.proxies;

import com.tourguide.tracker.beans.Attraction;
import com.tourguide.tracker.beans.VisitedLocation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "gpsUtil", url="localhost:8082")
public interface GpsUtilProxy {

    @GetMapping(value ="/getUserLocation")
    VisitedLocation visitedlocation(@RequestParam String userId);

    @GetMapping(value ="/getAttractions")
    List<Attraction> attractionList();

}


