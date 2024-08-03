import model.Animal;
import model.Dog;

public class Main {
    public static void main(String[] args) {

        // INHERITANCE
        // Saves rewriting methods and variables defined in parent classes.

        Dog dog = new Dog();

        dog.age = 10; // age comes from Animal class.
        dog.animalName = "Ice";

        dog.writeName(dog.animalName);

        System.out.println("------------------------------");

        Animal animal = new Animal();

        animal.age = 15;
        animal.animalName = "Lucky";

        animal.writeName(animal.animalName);


        // more than one class can inherit a class. But a class can inherit only one. Like Dog class can inherit from Animal only but not "Animal, Dog" together, only one inherit.
    }
}