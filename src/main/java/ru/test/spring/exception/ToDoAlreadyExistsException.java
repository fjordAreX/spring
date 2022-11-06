package ru.test.spring.exception;

public class ToDoAlreadyExistsException extends Exception{
    public ToDoAlreadyExistsException(String message) {
        super(message);
    }
}
