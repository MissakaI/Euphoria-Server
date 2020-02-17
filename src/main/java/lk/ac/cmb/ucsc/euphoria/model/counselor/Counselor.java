package lk.ac.cmb.ucsc.euphoria.model.counselor;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.model.common.SuperEntity;

import javax.persistence.*;

@Entity
public class Counselor extends SuperEntity {

    private String name;

    @Column(length = 500)
    private String description;

    private String specialty;

    private String hospital;

    private String city;

    private String picName;

    @OneToOne(cascade = CascadeType.ALL)
    private LoginCredentials loginCredentials;

    private float rating;
    private int ratedTimes;

    public Counselor() {
    }

    public Counselor(String name, String description, String specialty, String hospital, String city, String picName) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.picName = picName;
    }

    public Counselor(String name, String description, String specialty, String hospital, String city, String picName,
                     LoginCredentials loginCredentials) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.picName = picName;
        this.loginCredentials = loginCredentials;
    }

    public Counselor(String name, String description, String specialty, String hospital, String city, String picName,
                     String email, String username, String password) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.picName = picName;
        this.loginCredentials = new LoginCredentials(username,password,email);
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRatedTimes() {
        return ratedTimes;
    }

    public void setRatedTimes(int ratedTimes) {
        this.ratedTimes = ratedTimes;
    }

    public Counselor(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String photoUrl) {
        this.picName = photoUrl;
    }

    public LoginCredentials getLoginCredentials() {
        return loginCredentials;
    }

    public void setLoginCredentials(LoginCredentials loginCredentials) {
        this.loginCredentials = loginCredentials;
    }
}
