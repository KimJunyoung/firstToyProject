package toyproject.buyandlogin.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateForm {

    private Long id;

    @NotEmpty
    private String memberName;
    @NotEmpty
    private String memberId;

    @Length(min=8)
    @NotEmpty
    private String memberPassword;

    public UpdateForm(String memberName, String memberId, String memberPassword) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }
}
