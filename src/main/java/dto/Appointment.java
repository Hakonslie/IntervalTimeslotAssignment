package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appointment {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("patient_id")
    @Expose
    private String patientId;
    @SerializedName("calendar_id")
    @Expose
    private String calendarId;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("patient_comment")
    @Expose
    private Object patientComment;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("time_slot_type_id")
    @Expose
    private String timeSlotTypeId;
    @SerializedName("type_id")
    @Expose
    private Object typeId;
    @SerializedName("state")
    @Expose
    private Integer state;
    @SerializedName("out_of_office_location")
    @Expose
    private String outOfOfficeLocation;
    @SerializedName("out_of_office")
    @Expose
    private Boolean outOfOffice;
    @SerializedName("completed")
    @Expose
    private Boolean completed;
    @SerializedName("is_scheduled")
    @Expose
    private Boolean isScheduled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Object getPatientComment() {
        return patientComment;
    }

    public void setPatientComment(Object patientComment) {
        this.patientComment = patientComment;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public String getTimeSlotTypeId() {
        return timeSlotTypeId;
    }

    public void setTimeSlotTypeId(String timeSlotTypeId) {
        this.timeSlotTypeId = timeSlotTypeId;
    }

    public Object getTypeId() {
        return typeId;
    }

    public void setTypeId(Object typeId) {
        this.typeId = typeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOutOfOfficeLocation() {
        return outOfOfficeLocation;
    }

    public void setOutOfOfficeLocation(String outOfOfficeLocation) {
        this.outOfOfficeLocation = outOfOfficeLocation;
    }

    public Boolean getOutOfOffice() {
        return outOfOffice;
    }

    public void setOutOfOffice(Boolean outOfOffice) {
        this.outOfOffice = outOfOffice;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getIsScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(Boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

}