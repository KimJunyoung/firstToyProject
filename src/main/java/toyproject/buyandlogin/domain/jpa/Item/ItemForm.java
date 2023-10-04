package toyproject.buyandlogin.domain.jpa.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {
    private String itemName;

    private int price;

    private int stackQuantity;

    public ItemForm(String itemName, int price, int stackQuantity) {
        this.itemName = itemName;
        this.price = price;
        this.stackQuantity = stackQuantity;
    }
}
