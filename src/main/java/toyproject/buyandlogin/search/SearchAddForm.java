package toyproject.buyandlogin.search;

import lombok.Data;

@Data
public class SearchAddForm {

    private Long id;

    private String category;

    public SearchAddForm(Long id, String category) {
        this.id = id;
        this.category = category;
    }

}
