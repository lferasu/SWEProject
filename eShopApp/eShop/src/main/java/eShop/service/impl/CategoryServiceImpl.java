package eShop.service.impl;

import eShop.model.Category;
import eShop.repository.CategoryRepository;
import eShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }
}
