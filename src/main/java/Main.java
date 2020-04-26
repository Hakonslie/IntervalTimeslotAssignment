
import com.google.gson.*;
import dto.Appointment;
import dto.Calendar;
import dto.Timeslot;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import org.threeten.extra.Interval;

class Main {
    private List<Calendar> calendars;
    Main() {
        calendars = new ArrayList<>();
        fetchCalendars();
    }

    private void fetchCalendars() {
        Map<String, String> mapOfFiles = new HashMap<>();
        mapOfFiles.put("Danny Boy", "48cadf26-975e-11e5-b9c2-c8e0eb18c1e9");
        mapOfFiles.put("Joanna Hef", "48644c7a-975e-11e5-a090-c8e0eb18c1e9");
        mapOfFiles.put("Emma Win", "452dccfc-975e-11e5-bfa5-c8e0eb18c1e9");

        // Get each file
        mapOfFiles.forEach((fileName, calendarId) -> {
            String content = null;
            try {
                Path filePath = Paths.get("src/PatientSky/" + fileName + ".json");
                content = Files.readString(filePath);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            Gson gson = new Gson();
            Calendar calendar = gson.fromJson(content, Calendar.class);
            calendar.setId(calendarId);

            calendars.add(calendar);

        });

    }

    // Helper function accept a Calendar and an ArrayList of Intervals and finds timeslots that are available within each interval
    private HashMap<Interval, List<Timeslot>> findTimeslotsWithinIntervals(Calendar calendar, ArrayList<Interval> intervalsAvailable) {
        HashMap<Interval, List<Timeslot>> intervalsWithTimeslots = new HashMap<>();
        intervalsAvailable.forEach( interval -> {
            List<Timeslot> timeslots = calendar.getTimeslots().stream()
                    .filter(timeslot -> Instant.parse(timeslot.getStart() + "Z").compareTo(interval.getStart()) > -1)
                    .filter(timeslot -> Instant.parse(timeslot.getEnd() + "Z").compareTo(interval.getEnd()) < 1)
                    .collect(Collectors.toList());
            intervalsWithTimeslots.put(interval,  timeslots);
        });
        return intervalsWithTimeslots;
    }

    /*
            Main function as described in assignment
            return Hashmap with Key = ID of calendar and value = another HashMap
            HashMap in value has Key = Interval Object with the interval that is available within the requested timeframe and Value = List of Timeslots within that period
     */
    Map<String, HashMap<Interval, List<Timeslot>>> findAvailableTime(String[] calendarIds, int durationInSeconds, Interval intervalToSearch)
    {
        // Local fields
        List<Calendar> relevantCalendars = new ArrayList<>();
        Duration duration = Duration.ofSeconds(durationInSeconds);
        Map<String, HashMap<Interval, List<Timeslot>>> listOfCalendarsWithTimeslotsForAvailableIntervalsWithinSearchParameter = new HashMap<>();

        // Fetch relevant calendars with id-s corresponding to function parameter, if id doesn't match throws RuntimeException
        Arrays.stream(calendarIds).forEach(calendarId -> {
            relevantCalendars
                    .add(
                            calendars.stream()
                                    .filter(calendar -> calendar.getId().equals(calendarId))
                                    .findAny()
                                    // Calendar ID is invalid
                                    .orElseThrow(RuntimeException::new)
                    );
                }

        );

        for(Calendar relevantCalendar : relevantCalendars) {
            //Find all appointments within interval
            List<Appointment> appointments = relevantCalendar.getAppointments().stream()
                    .filter(appointment -> Instant.parse(appointment.getStart() + "Z").compareTo(intervalToSearch.getStart()) > -1)
                    .filter(appointment -> Instant.parse(appointment.getEnd() + "Z").compareTo(intervalToSearch.getEnd()) < 1)
                    .collect(Collectors.toList());

            // No appointments
            if(appointments.isEmpty()) {
                ArrayList<Interval> arrayListOfInterval = new ArrayList<>();
                arrayListOfInterval.add(intervalToSearch);
                listOfCalendarsWithTimeslotsForAvailableIntervalsWithinSearchParameter.put(relevantCalendar.getId(), findTimeslotsWithinIntervals(relevantCalendar, arrayListOfInterval));
            }
            // Check to see if there are gaps in between appointments
            else {
                ArrayList<Interval> availableIntervals = new ArrayList<>();
                // If there is time available before first appointment
                // Adding Z to the Instant.parse because otherwise it won't parse, might be better solutions to this but it worked out for me so I stuck with it.
                if (Interval.of(intervalToSearch.getStart(), Instant.parse(appointments.get(0).getStart() + "Z")).toDuration().compareTo(duration) > -1) {
                    availableIntervals.add((Interval.of(intervalToSearch.getStart(), Instant.parse(appointments.get(0).getStart() + "Z"))));
                }
                // If there is time available after last appointment
                if (Interval.of(Instant.parse(appointments.get(appointments.size() - 1).getEnd() + "Z"), intervalToSearch.getEnd()).toDuration().compareTo(duration) > -1) {
                    availableIntervals.add(Interval.of(Instant.parse(appointments.get(appointments.size() - 1).getEnd() + "Z"), intervalToSearch.getEnd()));
                }
                // Check between rest of appointments
                for (int i = 0; i < appointments.size() - 1; i++) {
                    Interval inter = Interval.of(Instant.parse(appointments.get(i).getEnd() + "Z"), Instant.parse(appointments.get(i + 1).getStart() + "Z"));
                    if (inter.toDuration().compareTo(duration) > -1) {
                        availableIntervals.add(inter);
                    }
                }

                if (!availableIntervals.isEmpty()) {
                    listOfCalendarsWithTimeslotsForAvailableIntervalsWithinSearchParameter.put(relevantCalendar.getId(), findTimeslotsWithinIntervals(relevantCalendar, availableIntervals));
                    // No schedules fit the requested duration within the requested interval
                } else return null;
            }
        }
        return listOfCalendarsWithTimeslotsForAvailableIntervalsWithinSearchParameter;
    }
}
