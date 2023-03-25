//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.exceptions.enums;

public enum ErrorCodes {
    ENTITY_NOT_FOUND(1000),
    SHOULD_NOT_EMPTY(1001);

    private int id;

    private ErrorCodes(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
