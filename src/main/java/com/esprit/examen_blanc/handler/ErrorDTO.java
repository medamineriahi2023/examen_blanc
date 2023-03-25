package com.esprit.examen_blanc.handler;

import com.esprit.examen_blanc.exceptions.enums.ErrorCodes;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class ErrorDTO {
    private Integer httpCode;
    private ErrorCodes errorCodes;
    private String message;
    private List<String> errors = new ArrayList();

    public ErrorDTO(final Integer httpCode, final ErrorCodes errorCodes, final String message, final List<String> errors) {
        this.httpCode = httpCode;
        this.errorCodes = errorCodes;
        this.message = message;
        this.errors = errors;
    }
}