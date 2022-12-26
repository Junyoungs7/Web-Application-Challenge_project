package com.jun.challenger.member.service;

import com.jun.challenger.member.dto.SignInRequestDTO;
import com.jun.challenger.member.dto.SignUpRequestDTO;
import com.jun.challenger.member.repository.MemberRepository;
import com.jun.challenger.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void validateDuplicate(String username) {
        Member validMember = memberRepository.findByUsername(username);
        if (validMember != null) {
            throw new IllegalStateException("이미 가입된 사용자입니다.");
        }
    }

    public void saveMember(SignUpRequestDTO requestDTO) {
        validateDuplicate(requestDTO.getUsername());
        Member saveMember = Member.builder()
                .requestDTO(requestDTO)
                .build();

        memberRepository.save(saveMember);
    }

    public void signInMember(SignInRequestDTO requestDTO) {
        Member validMember = memberRepository.findByUsername(requestDTO.getUsername());
        if (!Objects.equals(validMember.getPassword(), requestDTO.getPassword())) {
            throw new IllegalStateException("비밀번호를 다시 한번 확인해주세요.");
        }
    }
}
