package com.jun.challenger.challenge.model;

import com.jun.challenger.base.model.BaseTimeEntity;
import com.jun.challenger.member.model.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Challenge_Id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "Challenge_name", nullable = false)
    private String name;

    @Column(name = "Challenge_detail", nullable = false)
    private String detail;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<Challenging> challengings = new ArrayList<Challenging>();

    @Builder
    public Challenge(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }
}
