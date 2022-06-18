package finalterm.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class UserDto {
    @NotBlank
    @NotEmpty(message="필수 항목입니다.")
    private String userId;
    @NotBlank
    @NotEmpty(message="필수 항목입니다.")
    private String pwd;
    @NotBlank
    @NotEmpty(message="필수 항목입니다.")
    private String name;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate birthday;

    @NotBlank
    @Email(message="잘못된 이메일 형식입니다.")
    private String email;

    private String address;
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "010-XXXX-XXXX 형식")
    private String phoneNumber;

    public UserDto() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
