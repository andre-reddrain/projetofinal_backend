package com.pm.loaplanner.dto.Rewards;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RewardResponseDTO {
    private String id;
    private Boolean isExtraReward;
    private int ammount;
    private String typeRewardId;
    private String gateDetailsId;
}
