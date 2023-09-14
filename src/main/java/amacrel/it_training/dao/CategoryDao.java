package amacrel.it_training.dao;

import amacrel.it_training.entity.Category;
import amacrel.it_training.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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

    public Category createCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category updateCategory(int id, Category category) {
        Category existingCategory = this.getCategoryById(id).get();
        if (this.getCategoryById(id).isPresent()) {
            if (category.getTopics() != null && !Objects.equals(category.getTopics(), existingCategory.getTopics())) {
                existingCategory.setTopics(category.getTopics());
            }
            if (!category.getCategory_name().isEmpty() && !Objects.equals(category.getCategory_name(),
                    existingCategory.getCategory_name())) {
                existingCategory.setCategory_name(category.getCategory_name());
            }
        }
        return this.categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Category category) {
        this.categoryRepository.delete(category);
    }
}
