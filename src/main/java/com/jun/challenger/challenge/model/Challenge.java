package com.jun.challenger.challenge.model;

import com.jun.challenger.base.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "challenge_Id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "Challenge_name", nullable = false)
    private String name;

    @Column(name = "Challenge_detail", nullable = false)
    private String detail;

    @Builder
    public Challenge(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }
}
