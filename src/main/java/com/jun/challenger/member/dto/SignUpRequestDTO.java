package com.jun.challenger.member.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
public class SignUpRequestDTO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;

    @NotEmpty
    private String ageRange;

    @NotEmpty
    private String gender;
}
