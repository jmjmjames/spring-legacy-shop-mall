package finalterm.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LoginDto {
    @NotEmpty
    @NotBlank
    private String userId;
    @NotEmpty
    @NotBlank
    private String pwd;
    private Boolean rememberId;

    public LoginDto() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getRememberId() {
        return rememberId;
    }

    public void setRememberId(Boolean rememberId) {
        this.rememberId = rememberId;
    }
}
