package com.Immigration.Management.Exceptions;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@Data
public class SystemException extends RuntimeException {

    private final HttpStatus status;

    public SystemException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public SystemException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static SystemException notFound(Integer id) {
        return new SystemException(HttpStatus.NOT_FOUND," " + id + " was not found.");
    }

    public static SystemException badRequest(String message) {
        return new SystemException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
