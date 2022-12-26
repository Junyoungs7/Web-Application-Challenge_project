package com.jun.challenger.challengeMember.service;

import com.jun.challenger.challenge.model.Challenge;
import com.jun.challenger.challenge.repository.ChallengeRepository;
import com.jun.challenger.challengeMember.dto.C_MPointDTO;
import com.jun.challenger.challengeMember.dto.C_MRequestDTO;
import com.jun.challenger.challengeMember.dto.C_MResponseDTO;
import com.jun.challenger.challengeMember.model.Challenging;
import com.jun.challenger.challengeMember.repository.ChallengingRepository;
import com.jun.challenger.member.model.Member;
import com.jun.challenger.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class C_MService {

    private final MemberRepository memberRepository;
    private final ChallengeRepository challengeRepository;
    private final ChallengingRepository challengingRepository;

    public void challengeRegisterMember(C_MRequestDTO requestDTO){
        Challenging findChallenging = challengingRepository.findByMember_UsernameAndChallenge_Id(requestDTO.getUsername(), requestDTO.getChallengeId());
        if (findChallenging != null) {
            throw new IllegalStateException("이미 챌린지에 등록되어있습니다.");
        }
        Member findMember = memberRepository.findByUsername(requestDTO.getUsername());
        Challenge findChallenge = challengeRepository.findById(requestDTO.getChallengeId()).get();
        Challenging register = Challenging.builder()
                .member(findMember)
                .challenge(findChallenge)
                .build();
        challengingRepository.save(register);
    }

    public C_MResponseDTO members(UUID challengeId){
        List<Challenging> findChallenging = challengingRepository.findByChallenge_Id(challengeId);
        List<C_MPointDTO> c_mPointDTOS = new ArrayList<>();


        for (Challenging challenging : findChallenging) {
            C_MPointDTO c_mPointDTO = C_MPointDTO.builder()
                    .username(challenging.getMember().getUsername())
                    .point(challenging.getPoint())
                    .build();
            c_mPointDTOS.add(c_mPointDTO);
        }
        return C_MResponseDTO.builder()
                .c_mPointDTOS(c_mPointDTOS)
                .build();
    }
}
