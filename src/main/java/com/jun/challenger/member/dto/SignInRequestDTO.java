package com.jun.challenger.member.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class SignInRequestDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
