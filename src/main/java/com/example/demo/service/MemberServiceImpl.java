package com.example.demo.service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.OfficeDao;
import com.example.demo.dao.PositionDao;
import com.example.demo.dao.TeamDao;
import com.example.demo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class MemberServiceImpl implements MemberService{

    private final MemberDao memberDao;
    private final TeamDao teamDao;
    private final OfficeDao officeDao;
    private final PositionDao positionDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao, TeamDao teamDao, OfficeDao officeDao,
                             PositionDao positionDao) {
        this.memberDao = memberDao;
        this.teamDao = teamDao;
        this.officeDao = officeDao;
        this.positionDao = positionDao;

    }

    public List<Member> findAll() {

        List<Member> list = memberDao.findAll();
        return list;
    }

    public Member findById(Integer id) {
      Member member = memberDao.findById(id);

      return member;
    }

    public void insertMember(Member member) {
        memberDao.insertMember(member);
    }

    public void updateMember(Member member) {
        memberDao.updateMember(member);
    }

    public void removeMember(Integer memberId) {
        memberDao.removeMember(memberId);
    }

}
