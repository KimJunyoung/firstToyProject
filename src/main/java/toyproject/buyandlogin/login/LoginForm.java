package toyproject.buyandlogin.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    private String memberId;
    @NotEmpty
    private String memberPassword;

}
