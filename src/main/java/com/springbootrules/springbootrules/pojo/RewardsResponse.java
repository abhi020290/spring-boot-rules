package com.springbootrules.springbootrules.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RewardsResponse {
    private String userType;
    private String userId;
    private String amount;
    private String orderId;
    private long points;
    private long pointsAsValue;
    private String whichRule;
}
