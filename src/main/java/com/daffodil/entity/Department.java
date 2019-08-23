package com.daffodil.entity;

public enum Department {

    HR("hr"),
    ADMIN("admin"),
    TRAVEL("travel");

    private String value;

    private Department(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
};

