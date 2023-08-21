package toyproject.buyandlogin.domain;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String itemName;
    private String category;
    private Integer price;

    public Item(String itemName, String category, Integer price) {
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

}
