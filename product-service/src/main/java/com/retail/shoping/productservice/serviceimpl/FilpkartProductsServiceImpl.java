package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.Category;
import com.retail.shoping.productservice.model.FlipkartProducts;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.repository.BrandRepository;
import com.retail.shoping.productservice.repository.CategoryRepository;
import com.retail.shoping.productservice.repository.FlipkartProductsRepository;
import com.retail.shoping.productservice.repository.ProductRepository;
import com.retail.shoping.productservice.service.FlipkartProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilpkartProductsServiceImpl implements FlipkartProductsService {

    @Autowired
    private FlipkartProductsRepository flipkartProductsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<String> importDataToCategoryTable() {
        List<String> list = new ArrayList<>();
        List<FlipkartProducts> flipkartProductsList = flipkartProductsRepository.findAll();
        int c = 0;
        for (FlipkartProducts flipkartProducts : flipkartProductsList) {
            String string = flipkartProducts.getProduct_category_tree();

            List<String> categories = Arrays.asList(string.toString().split(">>"));

            long id = -1;
            String previous = "";
            for (int i = 0; i < categories.size(); i++) {
                String s = categories.get(i);
                StringBuilder stringBuilder1 = new StringBuilder(s);
                stringBuilder1.deleteCharAt(0);
                s = stringBuilder1.toString();
                if (i == 0) {
                    if (categoryRepository.findByName(s) == null) {
                        Category category = new Category();
                        category.setName(s);
                        categoryRepository.save(category);
                        list.add(s);
                    }
                    previous = s;
                } else {
                    if (categoryRepository.findByName(s) == null) {
                        Category category = new Category();
                        category.setName(s);
                        if (categoryRepository.findByName(previous) != null) {
                            category.setParentId(categoryRepository.findByName(previous).getId());
                        }
                        categoryRepository.save(category);
                        list.add(s);
                    }
                    previous = s;
                }
            }
        }
        return list;
    }


    @Override
    public List<FlipkartProducts> getAllFlipkartProducts() {
        return flipkartProductsRepository.findAll();
    }

    @Override
    public List<Product> importDataIntoProductTable() {
        List<Product> productList = new ArrayList<>();
        List<FlipkartProducts> flipkartProductsList = flipkartProductsRepository.findAll();
        for (FlipkartProducts flipkartProducts : flipkartProductsList) {
            Product product = new Product();
            product.setUniqId(flipkartProducts.getUniq_id());
            product.setCrawlTimestamp(flipkartProducts.getCrawl_timestamp());
            product.setProductUrl(flipkartProducts.getProduct_url());
            product.setProductName(flipkartProducts.getProduct_name());
            product.setPid(flipkartProducts.getPid());
            product.setRetailPrice(flipkartProducts.getRetail_price());
            product.setDiscountedPrice(flipkartProducts.getDiscounted_price());
            product.setImage(flipkartProducts.getImage());
            product.setIsFKAdvantageProduct(flipkartProducts.getIs_FK_Advantage_product());
            product.setDescription(flipkartProducts.getDescription());
            product.setProductRating(flipkartProducts.getProduct_rating());
            product.setOverallRating(flipkartProducts.getOverall_rating());
            product.setBrand(flipkartProducts.getBrand());

            String string = flipkartProducts.getProduct_category_tree();
            List<String> categories = Arrays.asList(string.toString().split(">>"));

            String previous = "";
            for (int i = 0; i < categories.size(); i++) {
                String s = categories.get(i);
                StringBuilder stringBuilder1 = new StringBuilder(s);
                stringBuilder1.deleteCharAt(0);
                s = stringBuilder1.toString();
                if (i == 0) {
                    previous = s;
                } else {
                    previous = s;
                }
            }
            product.setCategory(categoryRepository.findByName(previous).getId());
            productRepository.save(product);
            productList.add(product);
        }

        return productList;
    }
}
