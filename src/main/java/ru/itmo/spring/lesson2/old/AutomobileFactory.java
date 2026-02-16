package ru.itmo.spring.lesson2.old;

public class AutomobileFactory implements Factory {

    public static final AutomobileFactory INSTANCE = new AutomobileFactory();

    @Override
    public Object create(String type) {
//        return new Random().nextBoolean() ? new Car() : new Truck();
        return "Light".equals(type) ? new Car() : new Truck();
    }
}
