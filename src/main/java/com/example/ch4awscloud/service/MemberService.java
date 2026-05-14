package com.example.ch4awscloud.service;

import com.example.ch4awscloud.common.exception.MemberNotFoundException;
import com.example.ch4awscloud.dto.MemberRequestDto;
import com.example.ch4awscloud.dto.MemberResponseDto;
import com.example.ch4awscloud.entity.Member;
import com.example.ch4awscloud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto saveMember(MemberRequestDto requestDto) {
        log.info("[API - LOG] 팀원 저장 요청 시작");
        Member member = new Member(requestDto.getName(), requestDto.getAge(), requestDto.getMbti());
        Member savedMember = memberRepository.save(member);
        log.info("[API - LOG] 팀원 저장 완료 - id: {}", savedMember.getId());
        return MemberResponseDto.from(savedMember);
    }

    @Transactional(readOnly = true)
    public MemberResponseDto getMember(Long id) {
        log.info("[API - LOG] 팀원 조회 요청 시작");
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("[API - LOG] 팀원 조회 실패 - 존재하지 않는 id: {}", id);
                    return new MemberNotFoundException();
                });
        log.info("[API - LOG] 팀원 조회 완료 - id: {}", id);
        return MemberResponseDto.from(member);
    }
}
