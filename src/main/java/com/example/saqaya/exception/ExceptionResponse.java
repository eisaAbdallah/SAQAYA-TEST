package com.example.saqaya.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;
    private String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String message, String details,String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.httpCodeMessage=httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(String httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }
}
