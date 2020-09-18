package com.tourguide.tracker.service;

import com.tourguide.tracker.beans.Provider;
import com.tourguide.tracker.proxies.TripPricerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TripPricerServiceImpl implements TripPricerService {
    @Autowired
    private TripPricerProxy tripPricerProxy;

    @Override
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints) {
        return tripPricerProxy.getPrice( apiKey,  attractionId,  adults,  children,  nightsStay,  rewardsPoints);
    }

    @Override
    public String getProviderName(String apiKey, int adults) {
        return tripPricerProxy.getProviderName(apiKey, adults);
    }
}
