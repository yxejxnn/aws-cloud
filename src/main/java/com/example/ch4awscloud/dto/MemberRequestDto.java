package com.example.ch4awscloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequestDto {

    private String name;
    private int age;
    private String mbti;
}
