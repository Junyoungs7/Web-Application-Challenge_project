package com.jun.challenger.challenge.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CHListResponseDTO {

    List<CHResponseDTO> chResponseDTOS;
}
