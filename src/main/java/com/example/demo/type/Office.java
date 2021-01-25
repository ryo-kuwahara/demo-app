package com.example.demo.type;

import java.util.HashMap;
import java.util.Map;

public enum Office {

    Tokyo(1,"東京"),
    Kanagawa(2,"神奈川"),
    Chiba(3,"千葉"),
    Saitama(4,"埼玉");

    private Integer value;
    private String name;

    Office(Integer value, String name) {
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

    public static Map<Integer, String> getOfficeTypeList() {

        Map<Integer, String> officeTypeList = new HashMap<>();
        officeTypeList.put(Tokyo.getValue(), Tokyo.getName());
        officeTypeList.put(Kanagawa.getValue(), Kanagawa.getName());
        officeTypeList.put(Chiba.getValue(), Chiba.getName());
        officeTypeList.put(Saitama.getValue(), Saitama.getName());
        return officeTypeList;
    }
}
