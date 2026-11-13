package Study_Brod.exams;
//Doplnte atributy pro Film
//
//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach
//
//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

import Study_Brod.interfaces.ComparingBase;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu
public class MovieComparing {

    static void printList( ArrayList<Movie> movies){
        for(Movie m : movies){
            System.out.println(m);

        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");
        ArrayList<Movie> movies = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");

            movies.add(new Movie(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble( tokens[2]),Integer.parseInt(tokens[3])));
        }

        movies.sort((BY_OLDEST).reversed());
        printList(movies);
        movies.sort((BY_NAME));
        printList(movies);
        movies.sort((BY_NAME));
        printList(movies);
        movies.sort((BY_RATING));
        for (int i = 0; i < 10; i++) {
            System.out.println(movies.get(i));
        }

        di.finishImport();
    }

    public static final Comparator<Movie> BY_OLDEST = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {

            return Integer.compare(o1.year,o2.year);
        }
    };

    public static final Comparator<Movie> BY_NAME = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {

            return o1.name.compareTo(o2.name);
        }
    };

    public static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {

            return Double.compare(o1.raiting,o2.raiting);
        }
    };

}
class Movie implements Comparable{
    String name;
    int year;
    double raiting;
    int duration;

    public Movie(String name, int year, double raiting, int duration) {
        this.name = name;
        this.year = year;
        this.raiting = raiting;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name=" + name +
                ", year=" + year +
                ", raiting=" + raiting +
                ", duration=" + duration +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}