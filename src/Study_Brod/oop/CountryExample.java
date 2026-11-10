package Study_Brod.oop;

import Study_Brod.parse.Country;
import fileworks.DataImport;

import java.util.Comparator;

public class CountryExample {
    public static void main(String[] args){
        DataImport di = new DataImport("data/countries.txt");

        while (di.hasNext()){
            String line = di.readLine();
            String[] data = line.split(";");

            String name = data[0];
            String continent = data[1];
            String population = data[2];
            String avgAge = data[3];

            Country country = new Country(name, continent, Long.parseLong(population), Double.parseDouble(avgAge));
        }
        di.finishImport();
    }

    public static final Comparator <Country> BY_AVG_AGE = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Double.compare(o1.avgAge, o2.avgAge);
        }
    };

}

