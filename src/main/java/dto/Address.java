package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("address_type")
    @Expose
    private String addressType;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("country_code")
    @Expose
    private Integer countryCode;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("floor")
    @Expose
    private Integer floor;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("postal_area")
    @Expose
    private String postalArea;
    @SerializedName("municipal")
    @Expose
    private Object municipal;
    @SerializedName("county")
    @Expose
    private Object county;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalArea() {
        return postalArea;
    }

    public void setPostalArea(String postalArea) {
        this.postalArea = postalArea;
    }

    public Object getMunicipal() {
        return municipal;
    }

    public void setMunicipal(Object municipal) {
        this.municipal = municipal;
    }

    public Object getCounty() {
        return county;
    }

    public void setCounty(Object county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

}