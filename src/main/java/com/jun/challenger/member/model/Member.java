package com.jun.challenger.member.model;

import com.jun.challenger.base.model.BaseTimeEntity;
import com.jun.challenger.challenge.model.Challenge;
import com.jun.challenger.challenge.model.Challenging;
import com.jun.challenger.member.dto.SignUpRequestDTO;
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
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "Member_Id", unique = true, nullable = false)
    private String username;

    @Column(name = "Member_Pwd", nullable = false)
    private String password;

    @Column(name = "Member_Email", nullable = false)
    private String email;

    @Column(name = "Member_Age_Range", nullable = false)
    private String ageRange;

    @Column(name = "Member_Gender", nullable = false)
    private String gender;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Challenging> challengings = new ArrayList<Challenging>();


    @Builder
    public Member(SignUpRequestDTO requestDTO) {
        this.username = requestDTO.getUsername();
        this.password = requestDTO.getPassword();
        this.email = requestDTO.getEmail();
        this.ageRange = requestDTO.getAgeRange();
        this.gender = requestDTO.getGender();
    }
}
