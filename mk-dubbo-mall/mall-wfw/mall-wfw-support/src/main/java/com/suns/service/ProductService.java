package com.suns.service;


import com.suns.entity.ProductEntiry;

public interface ProductService {
    ProductEntiry getDetail(String id);
    ProductEntiry modify(ProductEntiry product);
    boolean status(String id, boolean upDown);
}
