package com.tourguide.tracker.service;

import com.tourguide.tracker.beans.VisitedLocation;
import com.tourguide.tracker.beans.Attraction;
import com.tourguide.tracker.proxies.GpsUtilProxy;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class TrackerServiceImpl implements  TrackerService {
    @Autowired
    private GpsUtilProxy gpsUtilProxy;
    @Override
    public VisitedLocation getUserLocation(String userId) {
        com.tourguide.tracker.beans.VisitedLocation vt;
        vt = gpsUtilProxy.visitedlocation(userId);
        return vt;
    }

    @Override
    public List<Attraction> getAttractions() {
        return gpsUtilProxy.attractionList();
    }
}
