package model;

public class Animal { // Super Class /
    public Long id;
    public String animalName;
    public int age;
    public String color;
    public int numberOfFeet;

    public void writeName(String animalName) {
        this.animalName = animalName;
        System.out.println("Animal name is: " + this.animalName);
    }
}
