package amacrel.it_training.controller;

import amacrel.it_training.dao.CategoryDao;
import amacrel.it_training.entity.Category;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@Data
public class CategoryRestControler {

    private CategoryDao categoryDao;

    public CategoryRestControler(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/all")
    public List<Category> getCategories() {
        return this.categoryDao.getCategories();
    }

    @GetMapping("/{id}/")
    public Optional<Category> getCategoryById(@PathVariable int id) {
        return this.categoryDao.getCategoryById(id);
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody Category category) {
        this.categoryDao.createCategory(category);
    }

    @PutMapping("/update")
    public void updateCategory(@RequestBody Category category) {
        this.categoryDao.updateCategory(category);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestBody Category category) {
        this.categoryDao.deleteCategory(category);
    }
}
