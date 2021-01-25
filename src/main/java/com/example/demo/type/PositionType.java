package com.example.demo.type;

import java.util.HashMap;
import java.util.Map;

public enum PositionType {

    Ippan(1,"一般"),
    Shunin(2,"主任"),
    Kacho(3,"課長"),
    Bucho(4,"部長");

    private Integer value;
    private String name;

    PositionType(Integer value, String name) {
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

    public static Map<Integer, String> getPositionTypeList() {
        Map<Integer, String> positionTypeList = new HashMap<>();
        positionTypeList.put(Ippan.getValue(),Ippan.getName());
        positionTypeList.put(Shunin.getValue(),Shunin.getName());
        positionTypeList.put(Kacho.getValue(),Kacho.getName());
        positionTypeList.put(Bucho.getValue(),Bucho.getName());

        return positionTypeList;
    }





}
