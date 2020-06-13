package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.bean.ProductBean;
import com.retail.shoping.productservice.exception.BusinessException;

import com.retail.shoping.productservice.exception.ErrorCode;
import com.retail.shoping.productservice.exception.ProductIsExistException;
import com.retail.shoping.productservice.model.Category;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.repository.CategoryRepository;
import com.retail.shoping.productservice.repository.ProductRepository;
import com.retail.shoping.productservice.service.ProductService;
import com.retail.shoping.productservice.utils.XoriskUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductBean addProduct(ProductBean productBean) {
        Category category = categoryRepository.findById(productBean.getCategory()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));

        if (productRepository.findByProductName(productBean.getProductName()).isPresent()) {
            throw new ProductIsExistException(productBean.getProductName());
        }
        Product product = new Product();
        XoriskUtils.copySafe(productBean, product);
        XoriskUtils.copySafe(productRepository.save(product), productBean);
        return productBean;
    }

    @Override
    public Product upDateProduct(Product product) {
        productRepository.findById(product.getUniqId()).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        categoryRepository.findById(product.getCategory()).orElseThrow(
                () -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long productId) {
        productRepository.findById(productId).orElseThrow(
                () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        return null;
    }


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }


}
