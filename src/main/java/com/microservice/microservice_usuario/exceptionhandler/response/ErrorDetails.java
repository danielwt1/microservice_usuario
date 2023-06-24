package com.microservice.microservice_usuario.exceptionhandler.response;

import java.time.LocalDate;

public class ErrorDetails {
    private LocalDate date;
    private String message;
    private String path;

    public ErrorDetails(LocalDate date, String message, String path) {
        this.date = date;
        this.message = message;
        this.path = path;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
