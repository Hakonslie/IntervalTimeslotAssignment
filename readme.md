
### Approximate time usage
1. Understand datatypes (30 min)
2. Import files and calendars into java objects (60 min)
http://www.jsonschema2pojo.org/
3. Figure out how to use ISO 8601 Intervals (30 min)
https://www.threeten.org/threeten-extra/
4. Method for Iterating Calendars Timeslots (120 min)
https://stackoverflow.com/questions/8405087/what-is-this-date-format-2011-08-12t201746-384z
5. Colleting Timeslots ( 180 min)
Spent a long time struggling with iterating over available timeslots, 
but took a step back and decided to make it easier by reading the array in the order they are when I understood they are already chronological
6. Return available Intervals with Timeslots. (60 min)
7. Some clean up and documentation ( 30 min)

### Function explanations
**fetchCalendars()**

Function grabs calendars and parse from Json into Java classes defined in dto package. 
Using Java new function introduced in Java 11 (new to me at least, but worked very well). 
Use com.google.gson to parse Json, have had good experience with this earlier so decided to go with it again

**private HashMap<Interval, List<Timeslot>> findTimeslotsWithinIntervals(Calendar calendar, ArrayList<Interval> intervalsAvailable)**

Helper function, tried to naturally split this out of the receiving function to keep it a bit cleaner.
This function takes in the calendar and a list of intervals available. 
Will return each interval again with available timeslots within that interval.

**Map<String, HashMap<Interval, List<Timeslot>>> findAvailableTime(String[] calendarIds, int durationInSeconds, Interval intervalToSearch)**

Main function to solve the assignment. First gets all Calendars relevant to CalendarId-s from parameter. 
Then 

### Thoughts

1. Would've like to have more tests underway but got hung up in the functionality.
2. Got stuck on timeslots trying to figure out how to connect one timeslots end to another timeslots start and create links of timeslots, 
spent too long on this before I realized I could easily read the timeslots in their order as they are already chronological.
3. Not returning a finnished functionality rather data that can be turned into functionality.
4. Learned a lot about working with Time









    

