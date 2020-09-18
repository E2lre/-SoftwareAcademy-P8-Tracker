package com.tourguide.tracker.service;

import java.util.List;
import java.util.UUID;

import com.tourguide.tracker.beans.Attraction;
import com.tourguide.tracker.beans.VisitedLocation;

public interface TrackerService {
    public VisitedLocation getUserLocation(String userId);
    public List<Attraction> getAttractions();
}
