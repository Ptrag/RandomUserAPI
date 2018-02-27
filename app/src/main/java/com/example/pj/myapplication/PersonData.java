package com.example.pj.myapplication;

/**
 * Created by Pj on 26/02/2018.
 */

public class PersonData {

    private String firstName;
    private String lastName;
    private String titleName;
    private String email;
    private String username;
    private String phone;
    private String city;
    private String street;
    private String dob;
    private String thumbnailUrl;
    private String pictureMediumSizeUrl;

    public PersonData(String firstName, String lastName, String titleName, String email, String username, String phone, String city, String street, String dob, String thumbnailUrl, String pictureMediumSizeUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.titleName = titleName;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.dob = dob;
        this.thumbnailUrl = thumbnailUrl;
        this.pictureMediumSizeUrl = pictureMediumSizeUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getPictureMediumSizeUrl() {
        return pictureMediumSizeUrl;
    }

    public void setPictureMediumSizeUrl(String pictureMediumSizeUrl) {
        this.pictureMediumSizeUrl = pictureMediumSizeUrl;
    }
}
