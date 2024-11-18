package StopWatch;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch(){}

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        endTime = LocalTime.now();
    }


    public long elapsedTime() {
        return ChronoUnit.SECONDS.between(startTime,endTime);
    }
}
