package com.jun.challenger.challengeMember.model;

import com.jun.challenger.challenge.model.Challenge;
import com.jun.challenger.member.model.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Member_Id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Challenge_Id")
    private Challenge challenge;

    private int point;

    @Builder
    public Challenging(Member member, Challenge challenge) {
        this.member = member;
        this.challenge = challenge;
        this.point = 0;
    }
}
