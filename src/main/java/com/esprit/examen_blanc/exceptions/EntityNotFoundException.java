//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.examen_blanc.exceptions;

import com.esprit.examen_blanc.exceptions.enums.ErrorCodes;
import java.util.List;

public class EntityNotFoundException extends Exception {
    private ErrorCodes errorCodes;
    private List<String> errors;

    public EntityNotFoundException(String message, ErrorCodes errorCodes, List<String> errors) {
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }

    public EntityNotFoundException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }

    public ErrorCodes getErrorCodes() {
        return this.errorCodes;
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
