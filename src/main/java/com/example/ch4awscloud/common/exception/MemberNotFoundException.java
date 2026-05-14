package com.example.ch4awscloud.common.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends ServiceException {
    public MemberNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 팀원이 존재하지 않습니다.");
    }
}
