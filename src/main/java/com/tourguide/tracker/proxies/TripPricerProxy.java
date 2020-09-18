package com.tourguide.tracker.proxies;

import com.tourguide.tracker.beans.Attraction;
import com.tourguide.tracker.beans.Provider;
import com.tourguide.tracker.beans.VisitedLocation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "tripPricer", url="localhost:8084")
public interface TripPricerProxy {
    @GetMapping(value ="/getPrice")
    List<Provider> getPrice(@RequestParam String apiKey, @RequestParam UUID attractionId, @RequestParam int adults, @RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints);

    @GetMapping(value ="/getProviderName")
    String getProviderName(@RequestParam String apiKey,@RequestParam int adults);


}
