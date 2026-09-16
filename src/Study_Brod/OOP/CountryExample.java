package Study_Brod.OOP;

import Study_Brod.Parase.Country;
import fileworks.DataImport;

public class CountryExample {
    public static void main(String[] args){
    DataImport di = new DataImport("data/countries.txt");

    while (di.hasNext()){
        String line = di.readLine();
        String[] data = line.split(";");

        String name = data[0];
        String continent = data[1];
        String population = data[2];
        String AvgAge = data[3];

        Country country = new Country(name, continent, Long.parseLong(population), Double.parseDouble(AvgAge));
    }
    di.finishImport();
    }
}
