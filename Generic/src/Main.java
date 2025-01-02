import java.awt.*;
import java.util.ArrayList;

// Using the Generic Class
public class Main {
    public static void main(String[] args) {
        // Box for Integer
//        Box<Integer> intBox = new Box<>(123);
//        System.out.println("Integer Value: " + intBox.getItem());
//
//        // Box for String
//        Box<String> strBox = new Box<>("Hello Generics");
//        System.out.println("String Value: " + strBox.getItem());

        FruiteBasket basket = new FruiteBasket();
        basket.add(new Apple("elma1"));
        basket.add(new Apple("elma2"));
        basket.add(new Apple("elma3"));
//        basket.add("elma4");
        basket.showFruiteBasket();

//        basket.add(new Pineapple("ananas1"));

        GenericFruitBasket basket2 = new GenericFruitBasket();
        basket2.add(new Apple("elma1"));
        basket2.add(new Apple("elma2"));
        basket2.add(new Pineapple("Pineapple1"));
        basket2.add(new Pineapple("Pineapple2"));

//        basket2.add("nanay");
        basket2.showFruiteBasket();


    }
}
