package com.jun.challenger.challengeMember.controller;

import com.jun.challenger.challengeMember.dto.C_MRequestDTO;
import com.jun.challenger.challengeMember.dto.C_MResponseDTO;
import com.jun.challenger.challengeMember.service.C_MService;
import com.jun.challenger.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cm")
public class C_MController {

    private final C_MService c_mService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid C_MRequestDTO requestDTO){
        try {
            c_mService.challengeRegisterMember(requestDTO);
            return ResponseEntity.ok().body("챌린지에 등록되었습니다.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/members/{challengeid}")
    public ResponseEntity<?> members(@PathVariable("challengeid") UUID challengeId){
        System.out.println(challengeId);
        C_MResponseDTO responseDTO = c_mService.members(challengeId);
        return ResponseEntity.ok().body(responseDTO);
    }
}
