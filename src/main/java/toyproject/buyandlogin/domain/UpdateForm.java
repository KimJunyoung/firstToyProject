package toyproject.buyandlogin.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateForm {

    @NotNull
    private Long id;

    @NotBlank
    private String memberName;

    @NotBlank
    private String memberId;

    @Length(min=8)
    @NotBlank
    private String memberPassword;

    public UpdateForm(String memberName, String memberId, String memberPassword) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }
}
