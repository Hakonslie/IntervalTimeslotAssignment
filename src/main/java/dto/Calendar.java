package dto;
import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Calendar {

    private String ID = "";

    @SerializedName("appointments")
    @Expose
    private List<Appointment> appointments = null;
    @SerializedName("timeslots")
    @Expose
    private List<Timeslot> timeslots = null;
    @SerializedName("timeslottypes")
    @Expose
    private List<Timeslottype> timeslottypes = null;

    public List<Appointment> getAppointments() {
        return appointments;
    }
    public String getId() {
        return ID;
    }
    public void setId(String id) {
        this.ID = id;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

    public List<Timeslottype> getTimeslottypes() {
        return timeslottypes;
    }

    public void setTimeslottypes(List<Timeslottype> timeslottypes) {
        this.timeslottypes = timeslottypes;
    }

}