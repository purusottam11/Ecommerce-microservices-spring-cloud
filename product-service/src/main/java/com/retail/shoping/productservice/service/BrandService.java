package com.retail.shoping.productservice.service;

import java.io.FileNotFoundException;

public interface BrandService {

    public void saveBrand() throws FileNotFoundException;

    public void saveDatatoMysqlDb();
}
