package toyproject.buyandlogin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toyproject.buyandlogin.domain.jpa.Category;
import toyproject.buyandlogin.domain.jpa.Item.Item;
import toyproject.buyandlogin.domain.jpa.Item.ItemForm;
import toyproject.buyandlogin.repository.CategoryRepository;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EntityManager em;

    /**
     * 저장 , 수정, 조회
     */

    @Test
    public void 아이템_저장V1(){

        Category category = Category.createCategory("음료");
        Item item = Item.createItem("커피", 4000, 10, category);

        itemService.saveItem(item);

        assertThat(item).isEqualTo(itemService.findOne(1L));
    }

    @Test
    public void 아이템_저장V2(){

        Category category = Category.createCategory("음료");
        Long categoryId = categoryService.saveCategory(category);

        ItemForm item = new ItemForm("몬스터", 2400, 20);

        em.flush();

        Long itemId = itemService.saveItemV2(categoryId, item);

        Item findId = itemService.findOne(itemId);

        assertThat(itemId).isEqualTo(findId.getId());
    }


    @Test
    public void 업데이트(){
        Category category = Category.createCategory("음료");
        Item item = Item.createItem("커피", 4000, 10, category);

        itemService.saveItem(item);

        Item updateItem = itemService.updateItem(item.getId(), item.getItemName(), 5000, 12);

        assertThat(updateItem.getPrice()).isEqualTo(5000);
    }


}