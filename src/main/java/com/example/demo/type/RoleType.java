package com.example.demo.type;

import java.util.HashMap;
import java.util.Map;

public enum RoleType {
    USER(0,"USER"),
    ADMIN(1,"ADMIN");


    private Integer value;
    private String name;

    RoleType(Integer value, String name) {
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

    public static Map<Integer, String> getRoleTypeList() {
        Map<Integer, String> roleList = new HashMap<>();
        roleList.put(USER.getValue(), USER.getName());
        roleList.put(ADMIN.getValue(), ADMIN.getName());

        return roleList;
    }

    public static String convert(Integer value) {
        for (RoleType roleType : RoleType.values()) {
            if (roleType.getValue() == value) {
                return roleType.getName();
            }
        }
        return "値はありません。";
    }
}
