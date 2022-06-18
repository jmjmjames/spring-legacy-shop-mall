package finalterm.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ModifyDto {

    @NotBlank(message = "변경하지 않을 시 기존의 이메일을 입력해주세요.")
    @Email(message="잘못된 이메일 형식입니다.")
    private String email;

    @NotBlank(message = "변경하지 않을 시 기존의 주소를 입력해주세요.")
    private String address;

    @NotBlank(message = "변경하지 않을 시 기존의 휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "010-XXXX-XXXX 형식")
    private String phoneNumber;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
