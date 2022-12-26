package com.jun.challenger.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jun.challenger.challenge.dto.CHCreateRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ChallengeControllerTest {

    @Mock
    private CHCreateRequestDTO requestDTO;

    @Autowired
    private MockMvc mockMvc;

    AutoCloseable openMocks;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ChallengeController.class).build();
    }

    @Test
    @DisplayName("로컬 챌린지 등록 테스트")
    void create() throws Exception {

        //given
        requestDTO = CHCreateRequestDTO.builder()
                .name("test")
                .detail("detail")
                .build();

        //when & then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/challenge/create")
                .content(objectMapper.writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findAll() {
    }
}