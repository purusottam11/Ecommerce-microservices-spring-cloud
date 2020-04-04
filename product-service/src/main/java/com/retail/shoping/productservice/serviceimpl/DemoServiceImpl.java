package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.model.Brand;
import com.retail.shoping.productservice.model.Category;
import com.retail.shoping.productservice.model.Demo;
import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.repository.BrandRepository;
import com.retail.shoping.productservice.repository.CategoryRepository;
import com.retail.shoping.productservice.repository.DemoRepository;
import com.retail.shoping.productservice.repository.ProductRepository;
import com.retail.shoping.productservice.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<String> getAllCategoryTree() {
        List<String> list = new ArrayList<>();
        List<Demo> demoList = demoRepository.findAll();
        int c = 0;
        for (Demo demo : demoList) {
            String string = demo.getProduct_category_tree();

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

        List<String> brands = new ArrayList<>();

        for (Demo demo : demoList) {
            String brand = demo.getBrand();
            if (brandRepository.findByName(brand) == null) {
                Brand brand1 = new Brand();
                brand1.setName(brand);
                brandRepository.save(brand1);
            }
        }
        return list;
    }


    @Override
    public List<Demo> getAllDemoData() {
        return demoRepository.findAll();
    }

    @Override
    public List<Product> addBulkDataIntoProduct() {
        List<Product> productList = new ArrayList<>();
        List<Demo> demoList = demoRepository.findAll();
        for (Demo demo : demoList) {
            Product product = new Product();
            product.setUniq_id(demo.getUniq_id());
            product.setCrawl_timestamp(demo.getCrawl_timestamp());
            product.setProduct_url(demo.getProduct_url());
            product.setProduct_name(demo.getProduct_name());
            product.setPid(demo.getPid());
            product.setRetail_price(demo.getRetail_price());
            product.setDiscounted_price(demo.getDiscounted_price());
            product.setImage(demo.getImage());
            product.setIs_FK_Advantage_product(demo.getIs_FK_Advantage_product());
            product.setDescription(demo.getDescription());
            product.setProduct_rating(demo.getProduct_rating());
            product.setOverall_rating(demo.getOverall_rating());
            String brandName = demo.getBrand();
            Brand brand = brandRepository.findByName(brandName);
            product.setBrand(brand.getId());

            String string = demo.getProduct_category_tree();
            String[] categories = string.toString().split(">>");

            String categoryName = categories[0];

            Category category1 = categoryRepository.findByName(categoryName);
            if (category1 != null) {
                product.setCategory(category1.getId());
            }
            productRepository.save(product);
            productList.add(product);
        }

        return productList;
    }
}