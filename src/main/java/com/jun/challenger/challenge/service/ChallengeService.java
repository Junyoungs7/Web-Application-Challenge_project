package com.jun.challenger.challenge.service;

import com.jun.challenger.challenge.dto.CHCreateRequestDTO;
import com.jun.challenger.challenge.dto.CHListResponseDTO;
import com.jun.challenger.challenge.dto.CHResponseDTO;
import com.jun.challenger.challenge.model.Challenge;
import com.jun.challenger.challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public void validateDuplicate(String name) {
        Challenge challenge = challengeRepository.findByName(name);
        if (challenge != null) {
            throw new IllegalStateException("이미 있는 챌린지입니다.");
        }
    }
    public void create(CHCreateRequestDTO requestDTO) {
        validateDuplicate(requestDTO.getName());
        Challenge challenge = Challenge.builder()
                .name(requestDTO.getName()).detail(requestDTO.getDetail()).build();

        challengeRepository.save(challenge);
    }

    public CHListResponseDTO findAll(){
        List<Challenge> challenges = challengeRepository.findAll();
        List<CHResponseDTO> chResponseDTOS = new ArrayList<>();
        for (Challenge challenge : challenges) {
            CHResponseDTO chResponseDTO = CHResponseDTO.builder()
                    .detail(challenge.getDetail()).id(challenge.getId()).name(challenge.getName()).build();
            chResponseDTOS.add(chResponseDTO);
        }
        return CHListResponseDTO.builder().chResponseDTOS(chResponseDTOS).build();
    }

    public CHResponseDTO findById(UUID uuid) {
        Challenge challenge = challengeRepository.findById(uuid).get();
        if (!challenge.getId().equals(uuid)) {
            throw new IllegalStateException("해당 챌린지는 없습니다.");
        } else {
            return CHResponseDTO.builder()
                    .name(challenge.getName())
                    .id(challenge.getId())
                    .detail(challenge.getDetail())
                    .build();
        }
    }
}
