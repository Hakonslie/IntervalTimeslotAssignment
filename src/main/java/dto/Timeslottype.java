package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timeslottype {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slot_size")
    @Expose
    private Integer slotSize;
    @SerializedName("public_bookable")
    @Expose
    private Boolean publicBookable;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("clinic_id")
    @Expose
    private String clinicId;
    @SerializedName("deleted")
    @Expose
    private Object deleted;
    @SerializedName("out_of_office")
    @Expose
    private Boolean outOfOffice;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(Integer slotSize) {
        this.slotSize = slotSize;
    }

    public Boolean getPublicBookable() {
        return publicBookable;
    }

    public void setPublicBookable(Boolean publicBookable) {
        this.publicBookable = publicBookable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public Object getDeleted() {
        return deleted;
    }

    public void setDeleted(Object deleted) {
        this.deleted = deleted;
    }

    public Boolean getOutOfOffice() {
        return outOfOffice;
    }

    public void setOutOfOffice(Boolean outOfOffice) {
        this.outOfOffice = outOfOffice;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}