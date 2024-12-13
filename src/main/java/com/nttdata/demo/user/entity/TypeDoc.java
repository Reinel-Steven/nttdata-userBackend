package com.nttdata.demo.user.entity;

import lombok.Getter;

@Getter
public enum TypeDoc {
    PASSPORT("P"),
    CC("C");

    private final String type;

    TypeDoc(String type) {
        this.type = type;
    }
}
