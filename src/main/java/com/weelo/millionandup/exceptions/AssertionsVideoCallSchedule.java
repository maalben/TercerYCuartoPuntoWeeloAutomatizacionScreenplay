package com.weelo.millionandup.exceptions;

public class AssertionsVideoCallSchedule extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String NO_FOUND_ELEMENT = "El elemento a verificar no es visible";

    public AssertionsVideoCallSchedule(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsVideoCallSchedule(String message) {
        super(message);
    }

}
