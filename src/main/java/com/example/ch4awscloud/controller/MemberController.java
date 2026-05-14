package com.example.ch4awscloud.controller;

import com.example.ch4awscloud.dto.MemberRequestDto;
import com.example.ch4awscloud.dto.MemberResponseDto;
import com.example.ch4awscloud.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long id) {
        log.info("[API - LOG] GET /api/members/{} 요청", id);
        return ResponseEntity.ok(memberService.getMember(id));
    }
}
