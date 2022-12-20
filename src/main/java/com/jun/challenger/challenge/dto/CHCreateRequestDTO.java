package com.jun.challenger.challenge.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
public class CHCreateRequestDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String detail;
}
