package toyproject.buyandlogin.upload;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UploadFile {

    @NotEmpty
    private String memberName;

    @NotEmpty
    private String memberId;

    @Length(min=2)
    @NotEmpty
    private String memberPassword;

    private MultipartFile multipartFile;

}
