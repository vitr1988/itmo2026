package ru.itmo.spring.lesson2.old;

public class Converter {

    private static final Converter INSTANCE = new Converter();

    private Converter() {

    }

//    INSTANCE;

    public static Converter getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new Converter();
//        }
        return INSTANCE;
    }

    public int convert(int value) {
        return value * 100;
    }
}
