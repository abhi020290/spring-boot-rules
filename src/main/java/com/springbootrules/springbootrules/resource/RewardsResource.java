package com.springbootrules.springbootrules.resource;

import com.springbootrules.springbootrules.pojo.RewardsRequest;
import com.springbootrules.springbootrules.pojo.RewardsResponse;
import com.springbootrules.springbootrules.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rewards")
public class RewardsResource {

    @Autowired
    private RewardsService rewardsService;

    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
    ResponseEntity<RewardsResponse> getRewards(@RequestBody RewardsRequest rewardsRequest) {
        RewardsResponse rewardsResponse = rewardsService.callLauncher(rewardsRequest);
        return ResponseEntity.ok(rewardsResponse);

    }
}
