package com.springbootrules.springbootrules.service;

import com.springbootrules.springbootrules.Launcher;
import com.springbootrules.springbootrules.pojo.RewardsRequest;
import com.springbootrules.springbootrules.pojo.RewardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RewardsService {

    @Autowired
    private Launcher launcher;

    public RewardsResponse callLauncher(RewardsRequest rewardsRequest){
        log.info("Rule engine invoked.......");
        RewardsResponse rewardsResponse = new RewardsResponse();
        buildRewardsResponse(rewardsRequest,rewardsResponse);
        RewardsResponse response = launcher.launchRules(rewardsRequest, rewardsResponse);
        log.info("Rule engine Completed.......");
        return response;
    }

    private void buildRewardsResponse(RewardsRequest rewardsRequest, RewardsResponse rewardsResponse) {
        rewardsResponse.setOrderId(rewardsRequest.getOrderId());
        rewardsResponse.setUserId(rewardsRequest.getUserId());
        rewardsResponse.setUserType(rewardsRequest.getUserType());
        rewardsResponse.setAmount(rewardsRequest.getAmount());
    }
}
