package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private Integer locid;

    @Column(name="CITY")
    private String city;

    @Column(name="Street_Address")
	private String StreetAddress;
	
	@Column(name="Postal_Code")
	private String postalcode;

    @Column(name="State_Province")
	private String stateProvince;
	
	@Column(name="Country_Name")
	private String countryName;

    public Integer getLocid() {
        return locid;
    }

    public void setLocid(Integer locid) {
        this.locid = locid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Location(){

    }

    public Location(String city, String streetAddress, String postalcode, String stateProvince, String countryName) {
        this.city = city;
        this.StreetAddress = streetAddress;
        this.postalcode = postalcode;
        this.stateProvince = stateProvince;
        this.countryName = countryName;
    }

 

    
}
