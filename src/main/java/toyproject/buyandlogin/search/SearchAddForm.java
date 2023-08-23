package toyproject.buyandlogin.search;

import lombok.Data;
import toyproject.buyandlogin.validation.NoSpecialValid;

@Data
public class SearchAddForm {

    private Long id;


    private String category;

    public SearchAddForm(Long id, String category) {
        this.id = id;
        this.category = category;
    }

}
