package com.example.ch4awscloud.repository;

import com.example.ch4awscloud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
