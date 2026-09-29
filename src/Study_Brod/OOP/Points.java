package Study_Brod.OOP;

public class Points {
    public static void main(String[] args) {

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
