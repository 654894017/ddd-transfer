package com.example.bank.account.exception;

/**
 * 超出日限额异常
 */
public class DailyLimitExceededException extends RuntimeException {
    public DailyLimitExceededException() {
    }

    public DailyLimitExceededException(String message) {
        super(message);
    }

    public DailyLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public DailyLimitExceededException(Throwable cause) {
        super(cause);
    }

    public DailyLimitExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
