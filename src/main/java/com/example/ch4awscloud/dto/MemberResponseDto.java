package com.example.ch4awscloud.dto;

import com.example.ch4awscloud.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto {

    private final Long id;
    private final String name;
    private final int age;
    private final String mbti;

    public static MemberResponseDto from(Member member) {
        return new MemberResponseDto(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }
}
