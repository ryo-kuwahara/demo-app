package com.example.demo.service;

import com.example.demo.dao.TeamDao;
import com.example.demo.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamDao teamDao;

    @Autowired
    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public List<Team> findAll() {
    List<Team> list = teamDao.findAll();
    return list;
    }

    /*public Map<Integer, String> getTeamMap(List<Team> tList) {
        Map<Integer, String> teamList = new HashMap<>();
        for (Team team : tList) {
            teamList.put(team.getId(),team.getName());
        }
        return teamList;
    }*/
}
