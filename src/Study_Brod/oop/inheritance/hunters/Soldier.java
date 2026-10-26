package Study_Brod.oop.inheritance.hunters;

public class Soldier extends Hunter{
    public Soldier(String name) {
        super(name);
        gold += 40;
    }

    void killBandits(){
        System.out.println(name+" is going aginst bandits");
        gold += 100;
    }
}
