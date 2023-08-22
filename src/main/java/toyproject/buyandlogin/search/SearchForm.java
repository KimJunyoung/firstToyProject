package toyproject.buyandlogin.search;

import lombok.Data;

@Data
public class SearchForm {

    private String category;

    public SearchForm(String category) {
        this.category = category;
    }
}
