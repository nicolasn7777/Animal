package animal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnimalHelper ah = new AnimalHelper();
        Animal animal = ah.getById(1);
//
        System.out.println(animal.getId() + " " + animal.getName() + " "
                    + animal.getAge() + " " + animal.getTail());
//
        ah.remove(animal);
//        animal.setName("Vasya");
//        animal.setAge(3);
//        animal.setTail(true);
//
//        ah.add(animal);

        List<Animal> animals = ah.getAll();

        for (Animal animal1 : animals) {
            System.out.println(animal1.getId() + " " + animal1.getName() + " "
                    + animal1.getAge() + " " + animal1.getTail());
        }

    }

}
