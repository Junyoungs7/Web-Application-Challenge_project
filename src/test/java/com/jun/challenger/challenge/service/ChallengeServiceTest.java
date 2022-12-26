package com.jun.challenger.challenge.service;

import com.jun.challenger.challenge.model.Challenge;
import com.jun.challenger.challenge.model.Challenging;
import com.jun.challenger.challenge.repository.ChallengeRepository;
import com.jun.challenger.challenge.repository.ChallengingRepository;
import com.jun.challenger.member.dto.SignUpRequestDTO;
import com.jun.challenger.member.model.Member;
import com.jun.challenger.member.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    ChallengingRepository challengingRepository;

    @Test
    @DisplayName("맴버, 챌린지 생성 및 저장")
    public void createAndSave(){
        SignUpRequestDTO requestDTO = SignUpRequestDTO.builder()
                .ageRange("10~20")
                .email("test@test")
                .gender("man")
                .password("test")
                .username("test")
                .build();

        Member member = Member.builder()
                .requestDTO(requestDTO)
                .build();

        memberRepository.save(member);

        Challenge challenge = Challenge.builder()
                .name("testChallenge")
                .detail("detailChallenge")
                .build();

        challengeRepository.save(challenge);

        Challenging challenging = Challenging.builder()
                .member(member)
                .challenge(challenge)
                .build();

        challengingRepository.save(challenging);
        assertEquals(member.getUsername(), challenging.getMember().getUsername());
        assertEquals(challenge.getName(), challenging.getChallenge().getName());
    }

}