package Study_Brod.Tests;

import fileworks.DataExport;
import fileworks.DataImport;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Movie {

    String name;
    int year;
    String type;
    double rating;

    public Movie(String name, int year, String type, double rating) {
        this.name = name;
        this.year = year;
        this.type = type;
        this.rating = rating;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");
        DataExport de = new DataExport("data/horrors.txt");

        Movie bestFilm = new Movie("N/A", 0, "N/A", 0);
        Movie afterMilleniumFilm = new Movie("N/A", 0, "N/A", 0);
        Movie horrorFilm = new Movie("N/A", 0, "horror", 0);

        ArrayList afterMilleniumMovies = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");

            if (bestFilm.rating < Double.parseDouble(tokens[3])){
                bestFilm.name = tokens[0];
                bestFilm.year = Integer.parseInt(tokens[1]);
                bestFilm.type = tokens[2];
                bestFilm.rating = Double.parseDouble(tokens[3]);
            }

            if (Integer.parseInt(tokens[1]) > 2000){
                afterMilleniumFilm.name = tokens[0];
                afterMilleniumFilm.year = Integer.parseInt(tokens[1]);
                afterMilleniumFilm.type = tokens[2];
                afterMilleniumFilm.rating = Double.parseDouble(tokens[3]);

                afterMilleniumMovies.add(afterMilleniumFilm.name);
            }



            if (tokens[2].equals("Horror")){
                horrorFilm.name = tokens[0];
                horrorFilm.year = Integer.parseInt(tokens[1]);
                horrorFilm.type = tokens[2];
                horrorFilm.rating = Double.parseDouble(tokens[3]);

                de.writeLine(horrorFilm.name);
            }



        }
        System.out.println("po roce 2000 vysly tyto filmy: "+afterMilleniumMovies);
        System.out.println("Nelepsi film je: "+bestFilm.name);

        di.finishImport();
        de.finishExport();
    }
}
