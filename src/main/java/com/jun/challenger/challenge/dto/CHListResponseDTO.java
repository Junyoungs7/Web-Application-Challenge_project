package com.jun.challenger.challenge.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class CHListResponseDTO {

    List<CHResponseDTO> chResponseDTOS;
}
