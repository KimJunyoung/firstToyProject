package toyproject.buyandlogin.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class Member {

    private Long id;

    @NotBlank
    private String memberName;

    @NotBlank
    private String memberId;

    @Length(min=8)
    @NotBlank
    private String memberPassword;

    private List<Item> items = new ArrayList<>();

    public Member(){
    }

    public Member(String memberName, String memberId, String memberPassword) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }
}
