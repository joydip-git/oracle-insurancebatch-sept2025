package com.oracle.database.exceptions;

public class DbQueryException extends Exception {
    public DbQueryException() {
        super("query is not proper/not found");
    }

    public DbQueryException(String message) {
        super(message);
    }
}
