package com.example.demo.type;

import java.util.HashMap;
import java.util.Map;

public enum TeamType {
    System(1,"システム"),
    Eigyo(2,"営業部"),
    Soumu(3,"総務部"),
    Keiri(4,"経理部");

    private Integer value;
    private String name;

    TeamType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Map<Integer, String> getTeamTypeList() {
        Map<Integer, String> teamTypeList = new HashMap<>();
        teamTypeList.put(System.getValue(),System.getName());
        teamTypeList.put(Eigyo.getValue(),Eigyo.getName());
        teamTypeList.put(Soumu.getValue(),Soumu.getName());
        teamTypeList.put(Keiri.getValue(),Keiri.getName());

        return teamTypeList;
    }
}
