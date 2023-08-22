package toyproject.buyandlogin.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import toyproject.buyandlogin.upload.UploadForm;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data

public class Member {

    private Long id;
    @NotEmpty
    private String memberName;
    @NotEmpty
    private String memberId;
    @Length(min=8)
    @NotEmpty
    private String memberPassword;

    private UploadForm attachFile;

    private List<Item> items;

    public Member(){

    }

    public Member(String memberName, String memberId, String memberPassword, UploadForm attachFile, List<Item> items) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.attachFile = attachFile;
        this.items = items;
    }
}
