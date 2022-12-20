package com.jun.challenger.challenge.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CHResponseDTO {
    private UUID id;
    private String name;
    private String detail;
}
