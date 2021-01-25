package com.example.demo.service;

import com.example.demo.entity.Team;
import java.util.List;
import java.util.Map;

public interface TeamService {

    List<Team> findAll();

    /*Map<Integer, String> getTeamMap(List<Team> tList);*/
}
