package com.danit.springhomeworks;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class HomeworkExceptions {
    static public  ResponseStatusException notFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
    }
}
