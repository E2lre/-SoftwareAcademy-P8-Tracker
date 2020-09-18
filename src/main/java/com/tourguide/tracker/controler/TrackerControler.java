package com.tourguide.tracker.controler;

import com.tourguide.tracker.beans.Provider;
import com.tourguide.tracker.beans.VisitedLocation;
import com.tourguide.tracker.beans.Attraction;
import com.tourguide.tracker.proxies.GpsUtilProxy;

//import gpsUtil.location.Attraction;
import com.tourguide.tracker.proxies.RewardCentralProxy;
import com.tourguide.tracker.service.TripPricerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TrackerControler {

    @Autowired
    private GpsUtilProxy gpsUtilProxy;
    @Autowired
    private RewardCentralProxy rewardCentralProxy;
    @Autowired
    private TripPricerService tripPricerService;

    @GetMapping(value = "getUserLocation")
    @ResponseStatus(HttpStatus.OK)
    public VisitedLocation getUserLocation (@RequestParam String userId)  {

            //UUID userIdUUID = UUID.fromString(userId);
            return gpsUtilProxy.visitedlocation(userId);

    }
    @GetMapping(value = "getAttractions")
    @ResponseStatus(HttpStatus.OK)
    public List<Attraction> getAttractions ()  {

        return gpsUtilProxy.attractionList();

    }
    @GetMapping(value = "getAttractionRewardPoints")
    @ResponseStatus(HttpStatus.OK)
    public int getAttractionRewardPoints (@RequestParam String attractionId, @RequestParam String userId)  {

        return rewardCentralProxy.getAttractionRewardPoints(attractionId,userId);

    }
    @GetMapping(value = "getPrice")
    @ResponseStatus(HttpStatus.OK)
    public List<Provider> getPrice (@RequestParam String apiKey, @RequestParam UUID attractionId, @RequestParam int adults, @RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints)  {


            return tripPricerService.getPrice(apiKey,  attractionId,  adults,  children,  nightsStay,  rewardsPoints);

    }
    @GetMapping(value = "getProviderName")
    @ResponseStatus(HttpStatus.OK)
    public String getProviderName (@RequestParam String apiKey,@RequestParam int adults)  {

        return tripPricerService.getProviderName(apiKey,  adults);

    }

}
