package toyproject.buyandlogin.domain.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private int price;

    private int stackQuantity;

    @OneToMany(mappedBy = "item")
    private List<ItemCategory> itemCategories;

}
