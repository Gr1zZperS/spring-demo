package com.springboot.model;

public enum UserConst {

    USER_NAME("username");

    UserConst(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }

}
