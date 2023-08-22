package toyproject.buyandlogin.additems;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toyproject.buyandlogin.domain.Item;
import toyproject.buyandlogin.domain.ItemRepository;
import toyproject.buyandlogin.domain.Member;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddItems {

    private final ItemRepository itemRepository;

    public void save(Member member, Long id) {
        Item item= itemRepository.findById(id);
        log.info(item.getItemName());
        List<Item> items = member.getItems();
        items.add(item);
        log.info("{}", items);

    }
}
