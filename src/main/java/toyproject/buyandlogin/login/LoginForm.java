package toyproject.buyandlogin.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotBlank
    private String memberId;
    @NotBlank
    private String memberPassword;

}
