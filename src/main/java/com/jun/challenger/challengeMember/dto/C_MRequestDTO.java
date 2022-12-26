package com.jun.challenger.challengeMember.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class C_MRequestDTO {

    private UUID challengeId;
    private String username;

}
