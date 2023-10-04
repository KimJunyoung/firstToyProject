package toyproject.buyandlogin.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.buyandlogin.domain.jpa.Category;
import toyproject.buyandlogin.domain.jpa.Item.Item;
import toyproject.buyandlogin.domain.jpa.Item.ItemForm;
import toyproject.buyandlogin.repository.CategoryRepository;
import toyproject.buyandlogin.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 저장
     * 수정
     * 단건 조회
     * 전체 조회
     */

    @Transactional
    public void saveItem( Item item){
        itemRepository.save(item);
    }

    @Transactional
    public Long saveItemV2(Long CategoryID, ItemForm item){
        // 엔티티 조회
        Category category = categoryRepository.findOne(CategoryID);

        Item newItem = Item.createItem(item.getItemName(), item.getPrice(), item.getStackQuantity(), category);

        itemRepository.save(newItem);

        return newItem.getId();
    }

    @Transactional
    public Item updateItem(Long id, String itemName, int price, int stockQuantity){
        Item findItem = itemRepository.findOne(id);
        findItem.updateItem(itemName, price, stockQuantity);
        return findItem;
    }

    public Item findOne(Long id){
        return itemRepository.findOne(id);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }
}
