package com.example.demo.dao;


import com.example.demo.entity.Member;
import com.example.demo.type.RoleType;
import com.example.demo.type.SexType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDaoImpl implements MemberDao{

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    private final TeamDao teamDao;
    private final OfficeDao officeDao;
    private final PositionDao positionDao;



    public MemberDaoImpl(JdbcTemplate jdbcTemplate, TeamDao teamDao, OfficeDao officeDao,
                         PositionDao positionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.teamDao = teamDao;
        this.officeDao = officeDao;
        this.positionDao = positionDao;

    }

    public Member selectByName(String name) {
        String sql = "SELECT * FROM members WHERE name = ?";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, name);
        Member member = new Member();
        member.setId((Integer)result.get("id"));
        member.setName((String)result.get("name"));
        member.setPassword((String)result.get("password"));
        member.setRoleName(RoleType.convert((Integer)result.get("role_id")));
        member.setTeam(teamDao.findById((Integer)result.get("team_id")));
        Date date = (Date)result.get("join_date");
        LocalDate ld = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        member.setJoinDate(ld);
        member.setOffice(officeDao.findById((Integer)result.get("office_id")));
        member.setPosition(positionDao.findById((Integer)result.get("position_id")));
        member.setSexName(SexType.convert((Integer)result.get("sex")));
        member.setRegisterDate(((Timestamp)result.get("register_date")).toLocalDateTime());
        return member;

    }

    public List<Member> findAll() {
    String sql = "SELECT * FROM members";
    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
    List<Member> list = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            Member member = new Member();
            member.setId((Integer)result.get("id"));
            member.setName((String)result.get("name"));
            member.setPassword((String)result.get("password"));
            member.setRoleName(RoleType.convert((Integer)result.get("role_id")));
            member.setTeam(teamDao.findById((Integer)result.get("team_id")));
            Date date = (Date)result.get("join_date");
            LocalDate ld = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            member.setJoinDate(ld);
            member.setOffice(officeDao.findById((Integer)result.get("office_id")));
            member.setPosition(positionDao.findById((Integer)result.get("position_id")));
            member.setSexName(SexType.convert((Integer)result.get("sex")));
            member.setRegisterDate(((Timestamp)result.get("register_date")).toLocalDateTime());
            list.add(member);
        }
    return list;
    }

    public Member findById(Integer id) {
    String sql = "SELECT * FROM members WHERE id = ?";
    Map<String, Object> requestMember = jdbcTemplate.queryForMap(sql, id);
    Member member = new Member();
    member.setId((Integer)requestMember.get("id"));
    member.setName((String)requestMember.get("name"));
    member.setPassword((String)requestMember.get("password"));
    member.setRoleName(RoleType.convert((Integer)requestMember.get("role_id")));
    member.setTeam(teamDao.findById((Integer)requestMember.get("team_id")));
    Date date = (Date)requestMember.get("join_date");
    LocalDate ld = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    member.setJoinDate(ld);
    member.setOffice(officeDao.findById((Integer)requestMember.get("office_id")));
    member.setPosition(positionDao.findById((Integer)requestMember.get("position_id")));
    member.setSex((Integer)requestMember.get("sex"));
    member.setSexName(SexType.convert((Integer)requestMember.get("sex")));
    member.setRegisterDate(((Timestamp)requestMember.get("register_date")).toLocalDateTime());
    return member;
    }

    public void insertMember(Member member) {
        Date now = new Date();
        java.sql.Date joinDate = java.sql.Date.valueOf(member.getJoinDate());
        String sql = "INSERT INTO members (name, password, role_id, team_id, join_date, office_id, position_id, sex, register_date) VALUES(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, member.getName(), member.getPassword(), member.getRoleId(), member.getTeam().getId(), joinDate,
                member.getOffice().getId(),member.getPosition().getId(), member.getSex(), now);
    }

    public void updateMember(Member member) {
        Date now = new Date();
        java.sql.Date joinDate = java.sql.Date.valueOf(member.getJoinDate());
        String sql = "UPDATE members SET name = ?, password = ?, role_id = ?, team_id = ?, join_date = ?, office_id = ?, position_id = ?," +
                "sex = ?, modified_date = ? WHERE id = ?;";
        jdbcTemplate.update(sql, member.getName(), member.getPassword(), member.getRoleId(), member.getTeam().getId(), joinDate,member.getOffice().getId(),
                member.getPosition().getId(),member.getSex(),now,member.getId());
    }

    public void removeMember(Integer memberId) {
        String sql = "DELETE FROM members where id = ?";
        jdbcTemplate.update(sql, memberId);
    }

}


