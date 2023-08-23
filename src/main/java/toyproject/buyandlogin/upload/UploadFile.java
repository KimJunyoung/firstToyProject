package toyproject.buyandlogin.upload;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;
import toyproject.buyandlogin.validation.NoSpecialValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UploadFile {

    @NotBlank
    @NoSpecialValid
    private String memberName;

    @NotBlank
    private String memberId;

    @Length(min=8)
    @NotBlank
    private String memberPassword;

    private MultipartFile multipartFile;

}
