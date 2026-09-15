package Study_Brod.OOP;

import fileworks.DataExport;
import fileworks.DataImport;

public class Track_print {
    public static void main(String[] args){
        DataImport di = new DataImport("data/tracks.txt");

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");


        }
    }
}
