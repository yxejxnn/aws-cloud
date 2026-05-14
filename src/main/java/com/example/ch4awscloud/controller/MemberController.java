package com.example.ch4awscloud.controller;

import com.example.ch4awscloud.dto.MemberRequestDto;
import com.example.ch4awscloud.dto.MemberResponseDto;
import com.example.ch4awscloud.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> saveMember(@RequestBody MemberRequestDto requestDto) {
        log.info("[API - LOG] POST /api/members 요청");
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }
}
