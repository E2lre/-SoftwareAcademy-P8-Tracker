package com.tourguide.tracker.service;

import com.tourguide.tracker.proxies.GpsUtilProxy;
import com.tourguide.tracker.proxies.RewardCentralProxy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RewardCentralServiceImpl  implements RewardCentralService {
    @Autowired
    private RewardCentralProxy rewardCentralProxy;
    @Override
    public int getAttractionRewardPoints(String attractionId, String userId) {
        return rewardCentralProxy.getAttractionRewardPoints(attractionId,userId);
    }
}
