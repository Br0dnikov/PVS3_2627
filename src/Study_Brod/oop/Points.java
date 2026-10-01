package Study_Brod.oop;

import fileworks.DataImport;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

public class Points {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        DataImport di = new DataImport("data/points.txt");


        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(",");

            switch (tokens.length){
                case 2:
                    points.add(new Point(Double.parseDouble(tokens[0]),Double.parseDouble(tokens[1])));
                    break;
                case 3:
                    points.add(new Point(tokens[0],Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                    break;
                case 4:
                    points.add(new Point(tokens[0],Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
                    break;
            }
        }
        di.finishImport();
        System.out.println(points);

        for (Point point : points){
            System.out.println(points);
        }
    }

}
class Point{
    String place;
    double x,y,z;
    final double DEFAULT_Z = 0;
    static int pointsCreated = 1;

    public Point(String place, double x, double y, double z) {
        this(place,x,y);
        this.z = z;
    }

    public Point(String place, double x, double y) {
        this.place = place;
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
        place = "Point#"+pointsCreated;
        pointsCreated++;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" +
                "z=" + z +
                ", y=" + y +
                ", x=" + x +
                ", place='" + place + '\'' +
                '}';
    }
}
