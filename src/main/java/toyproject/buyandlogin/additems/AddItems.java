package toyproject.buyandlogin.additems;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toyproject.buyandlogin.domain.OldItem;
import toyproject.buyandlogin.domain.OldItemRepository;
import toyproject.buyandlogin.domain.Member;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddItems {

    private final OldItemRepository oldItemRepository;

    public void save(Member member, Long id) {
        OldItem oldItem = oldItemRepository.findById(id);
        log.info(oldItem.getItemName());
        List<OldItem> oldItems = member.getOldItems();
        oldItems.add(oldItem);
        log.info("{}", oldItems);

    }
}
