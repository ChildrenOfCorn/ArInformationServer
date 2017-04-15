package com.github.childrenofcorn.exception;

import lombok.Getter;

import static com.github.childrenofcorn.exception.ExceptionCodes.WRONG_ACCESS_TOKEN_EXCEPTION;
import static com.github.childrenofcorn.exception.ExceptionCodes.WRONG_MEETING_TOKEN_EXCEPTION;

/**
 * Created by grishberg on 15.04.17.
 */
@Getter
public class AppException extends Exception {
    private int code;

    public AppException(String message) {
        super(message);
    }

    private AppException(int code, String message) {
        super(message);
        this.code = code;
    }

    public static final class WrongProductIdException extends AppException {
        public WrongProductIdException() {
            super(WRONG_MEETING_TOKEN_EXCEPTION, "Wrong meeting token");
        }
    }

    public static final class WrongAccessTokenException extends AppException {
        public WrongAccessTokenException() {
            super(WRONG_ACCESS_TOKEN_EXCEPTION, "Wrong access token");
        }
    }
}

