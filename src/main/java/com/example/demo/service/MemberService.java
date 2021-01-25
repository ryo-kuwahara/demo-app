package com.example.demo.service;


import com.example.demo.entity.Member;
import com.example.demo.entity.Team;

import java.util.List;

public interface MemberService {
    List<Member> findAll();

    Member findById(Integer id);

    void insertMember(Member member);

    void updateMember(Member member);

    void removeMember(Integer memberId);

}


