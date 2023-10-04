package toyproject.buyandlogin.domain.jpa.Item;

import lombok.Builder;
import lombok.Getter;
import toyproject.buyandlogin.domain.jpa.Category;
import toyproject.buyandlogin.exception.NotEnoughStockException;

import javax.persistence.*;

@Entity
@Getter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private int price;

    private int stackQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public Item(String itemName, int price, int stackQuantity) {
        this.itemName = itemName;
        this.price = price;
        this.stackQuantity = stackQuantity;
    }

    public Item() {
    }

    public void addCategory(Category category){
        this.category = category;
        category.getItems().add(this);
    }

    public static Item createItem(String itemName, int price, int stackQuantity, Category category){
        Item item = Item.builder()
                .itemName(itemName)
                .price(price)
                .stackQuantity(stackQuantity)
                .build();

        item.addCategory(category);

        return item;
    }

    // 서비스 로직
    public void updateItem(String itemName, int price, int stackQuantity){
        this.itemName = itemName;
        this.price = price;
        this.stackQuantity = stackQuantity;
    }

    // 비즈니스 로직

    public void addStock(int quantity){
        this.stackQuantity += quantity;
    }

    /**
     * stack 감소
     */
    public void removeStack(int quantity){
        int restStock = this.stackQuantity - quantity;
        if(restStock < 0 ) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stackQuantity = restStock;
    }

}
