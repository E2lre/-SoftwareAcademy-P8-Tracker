package com.tourguide.tracker.service;

import com.tourguide.tracker.beans.Provider;

import java.util.List;
import java.util.UUID;

public interface TripPricerService {
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints);
    public String getProviderName(String apiKey, int adults);
}
