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


        /*
        1- More than one class can inherit a class. But a class can inherit only one. Like Dog class can inherit from Animal only but not "Animal, Dog" together, only one inherit.
        2- Protected, can be accessed from both the class it is in and within the class that inherits that class. At main inaccessible
        */
//        Animal.numberOfFeet  // Can't accessible because it's protected.


    }
}