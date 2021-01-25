package com.example.demo.type;

import java.util.HashMap;
import java.util.Map;

public enum SexType {

    Unknown(0,"不明"),
    Man(1,"男性"),
    Woman(2,"女性");

    private Integer value;
    private String sexName;

    public int getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    SexType(int value, String sexName) {
        this.value = value;
        this.sexName = sexName;
    }

    public static Map<Integer, String> getSexTypeList() {
        Map<Integer, String> sextypeList = new HashMap();
        sextypeList.put(Man.getValue(),Man.getSexName());
        sextypeList.put(Woman.getValue(),Woman.getSexName());
        return sextypeList;
    }

    public static String convert(Integer value) {
        for (SexType sexType : SexType.values()) {
            if (sexType.getValue() == value) {
                return sexType.getSexName();
            }
        }
        return "値はありません。";
    }
}
