package com.example.demo.dao;

import com.example.demo.entity.Member;
import com.example.demo.entity.Office;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberDao {

    List<Member> findAll();

    Member findById(Integer id);

    void insertMember(Member member);

    void updateMember(Member member);

    void removeMember(Integer memberId);

    Member selectByName(String memberName);

}
