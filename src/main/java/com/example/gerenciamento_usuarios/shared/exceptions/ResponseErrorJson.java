package com.example.gerenciamento_usuarios.shared.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseErrorJson {
    // getters
    private String message;
    private List<String> errors;

    public ResponseErrorJson(String message) {
        this.message = message;
    }

    public ResponseErrorJson(List<String> errors) {
        this.errors = errors;
    }
}

