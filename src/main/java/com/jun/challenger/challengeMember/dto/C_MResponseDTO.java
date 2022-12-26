package com.jun.challenger.challengeMember.dto;

import com.jun.challenger.member.model.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class C_MResponseDTO {
    List<C_MPointDTO> c_mPointDTOS;

}
