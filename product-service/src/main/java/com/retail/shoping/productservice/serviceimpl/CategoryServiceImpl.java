package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.exception.BusinessException;
import com.retail.shoping.productservice.exception.ErrorCode;
import com.retail.shoping.productservice.model.Category;
import com.retail.shoping.productservice.repository.CategoryRepository;
import com.retail.shoping.productservice.service.CategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        Category category1 = categoryRepository.findByName(category.getName()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_ALREADY_EXIST));
        return categoryRepository.save(category1);
    }
}
