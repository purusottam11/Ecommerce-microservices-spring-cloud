package com.retail.shoping.productservice.controller;

import com.retail.shoping.productservice.model.Product;
import com.retail.shoping.productservice.model.ProductElasticSearch;
import com.retail.shoping.productservice.service.DataImportService;
import com.retail.shoping.productservice.serviceimpl.ElasticSearchServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dataImport")
public class DataImportController {

    Logger log = LoggerFactory.getLogger(ElasticSearchController.class);

    @Autowired
    private DataImportService dataImportService;

    @GetMapping("/importBulkDataToCategory")
    public List<String> importDataToCategoryTable() {
        return dataImportService.importDataToCategoryTable();
    }

    @GetMapping("/importBulkDataToProduct")
    public List<Product> getDataIntoProductTable() {
        return dataImportService.importDataIntoProductTable();
    }

    @Autowired
    private ElasticSearchServiceImpl productEsService;

    @GetMapping("/importProductToElasticSearch")
    public List<ProductElasticSearch> bulkImportToProductEs() {
        List<ProductElasticSearch> list = dataImportService.importDataIntoProductEs();
        log.debug("Response {}", list);
        return list;
    }

}
