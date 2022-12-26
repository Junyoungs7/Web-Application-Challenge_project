package com.jun.challenger.challenge.repository;

import com.jun.challenger.challenge.model.Challenge;
import com.jun.challenger.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {

    Challenge findByName(String name);
    List<Challenge> findAll();
    Optional<Challenge> findById(UUID id);

}
