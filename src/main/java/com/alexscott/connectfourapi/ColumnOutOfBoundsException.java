package com.alexscott.connectfourapi;

/**
 * Created by alex on 17/12/2016.
 * ArrayIndexOutOfBoundsException is a Runtime exception, but this error can be dealt with so
 * I've rolled my own.
 */
public class ColumnOutOfBoundsException extends Exception {
    public ColumnOutOfBoundsException(String message) {
        super(message);
    }
}
