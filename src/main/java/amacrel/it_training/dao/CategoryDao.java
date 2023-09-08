package amacrel.it_training.dao;

import amacrel.it_training.entity.Category;
import amacrel.it_training.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryDao {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(int id) {
        return this.categoryRepository.findById(id);
    }

    public void createCategory(Category category) {
        this.categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        // TO-DO Check Attributes
        this.categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        this.categoryRepository.delete(category);
    }
}
