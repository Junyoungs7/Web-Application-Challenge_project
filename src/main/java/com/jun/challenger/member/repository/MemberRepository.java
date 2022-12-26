package com.jun.challenger.member.repository;

import com.jun.challenger.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByUsername(String username);
}
