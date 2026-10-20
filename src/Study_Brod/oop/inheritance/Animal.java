package Study_Brod.oop.inheritance;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    double energy;
    String name;

    public Animal(double energy, String name) {
        this.energy = energy;
        this.name = name;
    }

    public void eat(double energy) {
        energy += Math.exp(-energy);
    }

    public void makeNoise(){
        System.out.println("Make some noise");
    }

}

class Cat extends Animal{

    public Cat(double energy, String name) {
        super(energy,name);
    }

    @Override
    public void makeNoise(){
        System.out.println("Meow");
    }
}

class Dog extends Animal{
    String breed;

    public Dog(String name, double energy) {
        super(energy,name);
    }

    public Dog(double energy, String name, String breed) {
        super(energy, name);
        this.breed = breed;
    }

    @Override
    public void makeNoise(){
        System.out.println("Haf");
    }
}

class Pig extends Animal{
    int mudLevel;

    void playInMud(){
        mudLevel += 10;
        mudLevel = Math.min(mudLevel,100);
    }

    public Pig(double energy, String name, int mudLevel) {
        super(energy, name);
        this.mudLevel = mudLevel;
    }

    @Override
    public void makeNoise(){
        System.out.println("Oink");
    }
}
class Main{
    public static void main(String[] args) {
        DataImport di = new DataImport("data/animals.txt");
        List<Animal> animals = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");

            switch (tokens[0]){
                case "Cat":
                {
                    animals.add(new Cat(Double.parseDouble(tokens[1]), tokens[2]));
                    break;
                }
                case "Dog": {
                    animals.add(new Dog(Double.parseDouble(tokens[1]),tokens[2], tokens[3]));
                    break;
                }
                case "Pig": {
                    animals.add(new Pig(Double.parseDouble(tokens[1]),tokens[2], Integer.parseInt(tokens[4])));
                    break;
                }
            }


        }
        for(Animal animal: animals){
            if(animal instanceof Dog){
                System.out.println(((Dog) animal).breed);
            }
        }
        System.out.println(animals);
    }
}


