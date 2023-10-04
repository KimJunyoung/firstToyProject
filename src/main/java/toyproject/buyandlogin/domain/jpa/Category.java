package toyproject.buyandlogin.domain.jpa;

import lombok.Builder;
import lombok.Getter;
import toyproject.buyandlogin.domain.jpa.Item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Item> Items = new ArrayList<>();

    public Category() {
    }

    @Builder
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public static Category createCategory(String categoryName){
        Category category = Category.builder().categoryName(categoryName).build();
        return category;
    }
}
