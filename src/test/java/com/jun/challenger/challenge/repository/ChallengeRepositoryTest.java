package com.jun.challenger.challenge.repository;

import com.jun.challenger.challenge.model.Challenge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ChallengeRepositoryTest {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Test
    @DisplayName("create Test")
    void create() {

        String name = "test";
        String detail = "test 상세설명";
        Challenge challenge = Challenge.builder().detail(detail).name(name).build();
        challengeRepository.save(challenge);
        Challenge check = challengeRepository.findByName(challenge.getName());

        assertEquals(challenge.getName(),check.getName());
        assertEquals(challenge.getDetail(), check.getDetail());
    }

}