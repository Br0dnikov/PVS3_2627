package Study_Brod.exams;

import fileworks.DataImport;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;

// Soubor má 4 sloupečky oddělené znakem "\t" - tabulátor
// name	price	num_reviews_total	short_description
// Některé řádky nemusí obsahovat krátký popisek

// Naimplementujte třídu reprezentující 1 hru/řádek
// Načtěte soubor
// Naimplementujte jednotlivé metody

public class SteamGameTest {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/steam_games.txt");

        List<Game> games = new ArrayList<>();

        // TODO: načíst soubor do arraylistu
        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split("\t");

            switch (tokens.length){
                case 3: games.add(new Game(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[2])));
                    break;
                case 4: games.add(new Game(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[2]),tokens[3]));
                    break;
            }
        }

        System.out.println("Games total loaded: " + games.size());

        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));    // placené

    }

    private static Game mostExpansive(List<Game> games) {
        // TODO: vrátit nejdražší hru
        Game gameForBourgeois = new Game("", 0, 0, "");
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getPrice() > gameForBourgeois.getPrice()){
                gameForBourgeois = games.get(i);
            }
        }

        return gameForBourgeois;
    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma

        long freeGames = 0;
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getPrice() == 0) {
                freeGames++;
            }
        }
        return freeGames;
    }

    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení

        double avgReview = 0;
        for (int i = 0; i < games.size(); i++) {
                avgReview += games.get(i).getPlayers();
        }

        avgReview /= games.size();

        return avgReview;
    }
}

class Game {
    // TODO: attributy, konstruktor(y), gettery/settery + minimálně toString()
    String gameName;
    double price;
    int players;
    String description;

    public Game(String gameName, double price, int players){
        this.gameName = gameName;
        this.price = price;
        this.players = players;

        // TODO: getter pro krátký popisek bude vracet "Not released yet" pokud není popisek uveden hra je "zdarma"
        if(this.price == 0)this.description = "Not released yet";
        else description= "No description";
    }

    public Game(String gameName, double price, int players, String description){
        this(gameName, price, players);
        this.description = description;
    }

    public String getGameName() {
        return gameName;
    }

    public double getPrice() {
        return price;
    }

    public int getPlayers() {
        return players;
    }

    public String getDescription() {
        return description;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameName='" + gameName + '\'' +
                ", price=" + price +
                ", players=" + players +
                ", description='" + description + '\'' +
                '}';
    }
}