package com.jun.challenger.challengeMember.repository;

import com.jun.challenger.challengeMember.model.Challenging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChallengingRepository extends JpaRepository<Challenging, Long> {
    Challenging findByMember_UsernameAndChallenge_Id(String username, UUID challengeId);

    List<Challenging> findByChallenge_Id(UUID challengeId);
}
