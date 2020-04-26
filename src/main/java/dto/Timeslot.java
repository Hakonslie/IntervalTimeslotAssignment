package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timeslot {

    // added this to make sure the equals in recursiveFindFirstTimeslot works correctly
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Timeslot) return ((Timeslot) obj).id.equals(this.id);
        return super.equals(obj);
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("calendar_id")
    @Expose
    private String calendarId;
    @SerializedName("type_id")
    @Expose
    private String typeId;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("public_bookable")
    @Expose
    private Boolean publicBookable;
    @SerializedName("out_of_office")
    @Expose
    private Boolean outOfOffice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    public Boolean getPublicBookable() {
        return publicBookable;
    }

    public void setPublicBookable(Boolean publicBookable) {
        this.publicBookable = publicBookable;
    }

    public Boolean getOutOfOffice() {
        return outOfOffice;
    }

    public void setOutOfOffice(Boolean outOfOffice) {
        this.outOfOffice = outOfOffice;
    }

}