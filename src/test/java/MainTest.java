
import dto.Timeslot;
import org.junit.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.threeten.extra.Interval;

public class MainTest {

    // Testing parameters
    private String[] calendarIds= new String[]{"48cadf26-975e-11e5-b9c2-c8e0eb18c1e9", "48644c7a-975e-11e5-a090-c8e0eb18c1e9", "452dccfc-975e-11e5-bfa5-c8e0eb18c1e9"};
    private int durationInSeconds = 2700;
    private String fromTimeInstant = "2019-04-24T15:00:00Z";
    private String toTimeInstant = "2019-04-24T17:00:00Z";
    private Interval intervalToSearch = Interval.of(Instant.parse(fromTimeInstant) , Instant.parse(toTimeInstant));

    @Test
    public void runWithParameters() {
        Main main = new Main();
        Map<String, HashMap<Interval, List<Timeslot>>> results = main.findAvailableTime(calendarIds, durationInSeconds, intervalToSearch);

        results.forEach((calendarId, calendar) -> {
            System.out.println("Available Intervals for: " + calendarId);
            calendar.forEach((interval, timeslots) -> {
                System.out.println("From: " + interval.getStart() + "To: " + interval.getEnd());
                timeslots.forEach(timeslot -> {
                    System.out.println("Timeslot available from: " + timeslot.getStart() + " To: " + timeslot.getEnd());
                });
            });
            System.out.println("---------------- \n");
        });


    }


}
