package com.springbootrules.springbootrules.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RewardsRequest {
    private String userType;
    private String userId;
    private String amount;
    private String orderId;
}
