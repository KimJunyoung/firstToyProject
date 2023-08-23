package toyproject.buyandlogin.search;

import lombok.Data;
import toyproject.buyandlogin.validation.NoSpecialValid;

@Data
public class SearchForm {


    private String category;

    public SearchForm(String category) {
        this.category = category;
    }
}
