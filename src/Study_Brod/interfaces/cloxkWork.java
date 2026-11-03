package Study_Brod.interfaces;

public class cloxkWork {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch(0);
        watch.AddMilliseconds(5500);
        watch.SetStart();
        watch.SetStop();
        watch.DisplayTime();
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
    public void DisplayTime(){
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
    void DisplayTime(){
        long duration = stop-start;
        double seconds = duration/1000d;

        int minutes = (int) seconds/60;
        seconds %= 60;


    }
}
