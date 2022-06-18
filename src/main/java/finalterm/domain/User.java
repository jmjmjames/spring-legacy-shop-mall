package finalterm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class User {

    private Integer id;
    private String userId;
    @JsonIgnore
    private String pwd;
    private String name;
    private LocalDate birthday;
    private String email;
    private String address;
    private String phoneNumber;

    protected User() {
    }

    public User(Integer id, String userId, String pwd, String name, LocalDate birthday, String email, String address, String phoneNumber) {
        this.id = id;
        this.userId = userId;
        this.pwd = pwd;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
