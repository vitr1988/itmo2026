package ru.itmo.spring.lesson2.old;

public class SingletonExample {

    public static void main(String[] args) {
        Converter converter = Converter.getInstance();
        System.out.println(converter.convert(11));
        System.out.println(converter.convert(-10));
        System.out.println(converter.convert(0));

        Object o = AutomobileFactory.INSTANCE.create("Light");
        o = AutomobileFactory.INSTANCE.create("Heavy");
        o = AutomobileFactory.INSTANCE.create("Light");
        o = AutomobileFactory.INSTANCE.create("Light");

        if (o instanceof Car car) {
            System.out.println(car.getModel());
        } else if (o instanceof Truck truck) {
            System.out.println(truck.getTonnage());
        }
    }
}
