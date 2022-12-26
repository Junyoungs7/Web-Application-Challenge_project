package com.jun.challenger.member.controller;

import com.jun.challenger.member.dto.SignInRequestDTO;
import com.jun.challenger.member.dto.SignUpRequestDTO;
import com.jun.challenger.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid SignUpRequestDTO requestDTO) {
        try {
            memberService.saveMember(requestDTO);
            return ResponseEntity.ok().body("회원가입이 완료되었습니다.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid SignInRequestDTO requestDTO) {
        try {
            memberService.signInMember(requestDTO);
            return ResponseEntity.ok().body("로그인되셨습니다.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
