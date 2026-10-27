package Study_Brod.oop.inheritance.hunters;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {
    static void randomJob(Hunter hunter){
        Random rnd = new Random();
        int random = rnd.nextInt(0,3);

        switch (random){
            case 1: {
                hunter.hunt();
            }
            case 2: {
                if(hunter instanceof Soldier) ((Soldier) hunter).killBandits();
            }
            case 3: {
                if (hunter instanceof Witcher) ((Witcher) hunter).slayMonster();
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add(new Hunter("Theodere Roosvelt"));
        hunters.add(new Soldier("Jack Carter"));
        hunters.add(new Soldier("Chel"));
        hunters.add(new Witcher("Geralt"));
        hunters.add(new Witcher("Vesemir"));

        int amountOrders = 100;

        Random rnd = new Random();
        int randomIndex;

        for (int i = 0; i < amountOrders; i++) {
            randomIndex = rnd.nextInt(0, hunters.size());
            randomJob((Hunter) hunters.get(randomIndex));
        }

        Hunter best = hunters.getFirst();

        for (Hunter hunter:hunters){
            if(hunter.gold>best.gold){
                best = hunter;
            }
        }
    }
}
