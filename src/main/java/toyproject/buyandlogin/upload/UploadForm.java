package toyproject.buyandlogin.upload;

import lombok.Data;

@Data
public class UploadForm {

    private String storeName;
    private String realName;

    public UploadForm(String storeName, String realName) {
        this.storeName = storeName;
        this.realName = realName;
    }
}
