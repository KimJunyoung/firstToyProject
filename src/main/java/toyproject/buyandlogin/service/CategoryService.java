package toyproject.buyandlogin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.buyandlogin.domain.jpa.Category;
import toyproject.buyandlogin.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Long saveCategory(Category category){
        categoryRepository.save(category);
        return category.getId();
    }

    public Category findCategory(Long id){
        return categoryRepository.findOne(id);
    }

    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }
}
