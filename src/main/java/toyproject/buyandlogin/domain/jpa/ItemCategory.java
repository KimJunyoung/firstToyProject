package toyproject.buyandlogin.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "item_category")
public class ItemCategory {

    @Id
    @GeneratedValue
    @Column(name = "item_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


}
