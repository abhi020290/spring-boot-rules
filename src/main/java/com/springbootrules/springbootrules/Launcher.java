package com.springbootrules.springbootrules;

import com.springbootrules.springbootrules.pojo.RewardsRequest;
import com.springbootrules.springbootrules.pojo.RewardsResponse;
import com.springbootrules.springbootrules.rules.PremiumRewardsRule;
import com.springbootrules.springbootrules.rules.SilverRewardsRule;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Launcher {

    public RewardsResponse launchRules(RewardsRequest rewardsRequest, RewardsResponse rewardsResponse) {
        Facts facts = new Facts();
        facts.put("rewardsRequest", rewardsRequest);
        facts.put("rewardsResponse", rewardsResponse);

        Rules rules = new Rules();
        rules.register(new SilverRewardsRule());
        rules.register(new PremiumRewardsRule());

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
        return facts.get("rewardsResponse");
    }
}
