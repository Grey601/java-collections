package ru.netology.domain;

public class SameNamesException extends RuntimeException {

    public SameNamesException() {
        super("Игроки с одинаковыми именами");
    }
}
