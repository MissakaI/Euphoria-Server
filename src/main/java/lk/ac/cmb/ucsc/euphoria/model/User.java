package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long uid;


    private String first_name;
    private String last_name;
    private String gender;
    @NotBlank
    private String email;
    @NotBlank
    @Transient
    private String password;
    private int contact_number;
    private String date_of_birth;
    private String nic;
    private String city;
    private String district;

    private String status;//whether online or not
    private String account_type;//quick or formal
    private String activated;
    /******/
    private Date timestamp=new Date();

    private String pic_name;


    public User() {
    }

    public User(
            long uid, @JsonProperty("gender") String gender,
            @JsonProperty("firstname") String first_name,
            @JsonProperty("lastname") String last_name,
            @JsonProperty("email") @NotBlank String email,
            @JsonProperty("password") @NotBlank String password,
            @JsonProperty("contactNumber") int contact_number,
            @JsonProperty("dob") String date_of_birth,
            @JsonProperty("nic") String nic,
            @JsonProperty("city") String city,
            @JsonProperty("district") String district,
            @JsonProperty("accountType") String account_type,
            @JsonProperty("pic_name") String pic_name) {
        this.uid = uid;

        this.gender = gender;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.contact_number = contact_number;
        this.date_of_birth = date_of_birth;
        this.nic = nic;
        this.city = city;
        this.district = district;
        this.status = status;
        this.account_type = account_type;
        this.pic_name=pic_name;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public String getPic_name() {
        return pic_name;
    }

    public long getUid() {
        return uid;
    }

    public String getGender() {
        return gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getContact_number() {
        return contact_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getNic() {
        return nic;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStatus() {
        return status;
    }

    public String getAccount_type() {
        return account_type;
    }


}
