package Study_Brod.oop.inheritance;

public class Surgeon extends Doctor{
    final static int SURGEON_BONUS = 25000;

    public Surgeon(String name) {
        super(name);
        this.salary = SURGEON_BONUS;
    }


    void surgery(){
        System.out.println("Cutting is open...");
        salary += 10000;
    }

}
