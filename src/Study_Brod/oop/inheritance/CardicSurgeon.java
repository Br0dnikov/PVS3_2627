package Study_Brod.oop.inheritance;

public class CardicSurgeon extends Surgeon {
    final static int CS_BONUS = 35000;

    public CardicSurgeon(String name) {
        super(name);
        salary += CS_BONUS;
    }

    void cardicSurgery(){
        System.out.println("Cut my heart");
        salary += 30000;
    }
}
