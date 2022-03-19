package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.Category;
import hoangdang.bookstore.model.CategoryModel;

public interface CategoryService {

	CategoryModel createCategory(CategoryModel categoryModel);

	List<Category> findAll();

	void delete(Integer id);

	CategoryModel getOneCategoryById(Integer id);

	CategoryModel updateCategory(CategoryModel categoryModel);

	Category getCategoryByNameSearch(String nameSearch);

}
