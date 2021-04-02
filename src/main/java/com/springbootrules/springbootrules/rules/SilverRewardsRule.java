package com.springbootrules.springbootrules.rules;

import com.springbootrules.springbootrules.pojo.RewardsRequest;
import com.springbootrules.springbootrules.pojo.RewardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule(name = "SilverRewardsRule", description = "Identify the type of users", priority = 1)
@Slf4j
public class SilverRewardsRule {

    @Condition
    public boolean checkCondition(@Fact("rewardsRequest") RewardsRequest rewardsRequest) {
        return Integer.parseInt(rewardsRequest.getAmount()) > 150
                && rewardsRequest.getUserType().equalsIgnoreCase("SILVER");
    }

    @Action
    public void takeAction(Facts facts) {
        log.info("Invoked SilverRewardsRule............");
        RewardsRequest rewardsRequest = facts.get("rewardsRequest");
        RewardsResponse rewardsResponse = facts.get("rewardsResponse");
        long points = (long) (Integer.parseInt(rewardsRequest.getAmount()) * 0.2);
        long valueOfPoints = points * 10;
        rewardsResponse.setPoints(points);
        rewardsResponse.setPointsAsValue(valueOfPoints);
        rewardsResponse.setWhichRule("SilverRewardsRule");
    }

}
