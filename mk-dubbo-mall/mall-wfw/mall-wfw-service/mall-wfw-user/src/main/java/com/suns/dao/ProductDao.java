package com.suns.dao;


import com.suns.entity.ProductEntiry;

public interface ProductDao {
    ProductEntiry getDetail(String id);
    ProductEntiry modify(ProductEntiry product);
    boolean status(String id, boolean upDown);
}
