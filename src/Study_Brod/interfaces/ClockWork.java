package Study_Brod.interfaces;

public class ClockWork {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch(0);
        watch.SetStart();
        watch.AddMilliseconds(5500);
        watch.SetStop();
        watch.displayTime();
    }
}

class DigitalClock implements TimeSupport{
    int year, month, day, hours,minute,second;

    public DigitalClock(int year, int month, int day, int hours, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public void displayTime(){
        System.out.println("Today: " +day+"."+month+"."+year);
    }
}

class StopWatch implements TimeSupport{
    long millisecond;

    long start;
    long stop;

    void SetStart(){
        start = millisecond;
    }

    void AddMilliseconds(long toAdd){
        millisecond += toAdd;
    }

    void  SetStop(){
        stop = millisecond;
    }

    public StopWatch (long millisecond){
        this.millisecond = millisecond;
    }

    @Override
    public void displayTime(){
        long duration = stop-start;
        double totalSeconds = duration/1000.0;

        int minutes = (int) totalSeconds/60;
        double seconds = totalSeconds % 60.0;
        System.out.println(minutes + ":" + seconds);


    }
}
