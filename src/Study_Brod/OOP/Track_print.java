package Study_Brod.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

public class Track_print {
    public static void main(String[] args){
        DataImport di = new DataImport("data/tracks.txt");
        ArrayList<Track> tracks = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");

            Track songs = new Track(
                    tokens[0],
                    Integer.parseInt(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Integer.parseInt(tokens[3])
            );

            tracks.add(songs);
        }

        System.out.println(tracks.getLast());
        //System.out.println();

        di.finishImport();
    }

}
