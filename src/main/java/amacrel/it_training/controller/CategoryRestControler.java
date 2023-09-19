package amacrel.it_training.controller;

import amacrel.it_training.dao.CategoryDao;
import amacrel.it_training.entity.Category;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@Data
public class CategoryRestControler {

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/")
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Optional<Category> category = categoryDao.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category) {
        return categoryDao.createCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
        Optional<Category> existingCategory = categoryDao.getCategoryById(id);
        return existingCategory.map(category -> ResponseEntity.ok(categoryDao.updateCategory(id, updatedCategory)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        Optional<Category> category = categoryDao.getCategoryById(id);

        if (category.isPresent()) {
            categoryDao.deleteCategory(category.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
