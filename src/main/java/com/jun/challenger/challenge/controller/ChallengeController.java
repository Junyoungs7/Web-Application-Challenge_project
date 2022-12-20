package com.jun.challenger.challenge.controller;

import com.jun.challenger.challenge.dto.CHCreateRequestDTO;
import com.jun.challenger.challenge.dto.CHListResponseDTO;
import com.jun.challenger.challenge.dto.CHResponseDTO;
import com.jun.challenger.challenge.service.ChallengeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/challenge")
public class ChallengeController {

    private final ChallengeService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CHCreateRequestDTO requestDTO) {
        try {
            service.create(requestDTO);
            return ResponseEntity.ok().body("챌린지가 생성되었습니다.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAll(){
        try {
            CHListResponseDTO chListResponseDTOList = service.findAll();
            return ResponseEntity.ok().body(chListResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("리스트를 불러올 수 없습니다.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") UUID id) {
        log.info("id = {}", id);
        try {
            CHResponseDTO chResponseDTO = service.findById(id);
            return ResponseEntity.ok().body(chResponseDTO);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body("해당 챌린지를 찾을 수 없습니다.");
        }
    }
}
