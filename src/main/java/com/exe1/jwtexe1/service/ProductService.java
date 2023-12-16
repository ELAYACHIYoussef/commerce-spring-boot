package com.exe1.jwtexe1.service;


import com.exe1.jwtexe1.dao.ProductDao;
import com.exe1.jwtexe1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductDao productDao;

    public Product addNewProduct(Product product){
        productDao.save(product);
        return product;
    }

    public List<Product>getAllProduct(){
        return (List<Product>) productDao.findAll();
    }
    public Product getProductById(Integer productId){
       return productDao.findById(productId).get();
    }
    public void deletProductDetail(Integer productId){
        productDao.deleteById(productId);
    }

    public Product updateProduct(Integer productId, Product updatedProduct) {

        Product product = productDao.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Le produit avec l'ID spécifié n'existe pas"));


        product.setProductName(updatedProduct.getProductName());
        product.setProductDescription(updatedProduct.getProductDescription());
        product.setProductDiscountPrice(updatedProduct.getProductDiscountPrice());
        product.setProductActualPrice(updatedProduct.getProductActualPrice());
        product.setProductImages(updatedProduct.getProductImages());
        Product updatedProduct1 = productDao.save(product);

        // Retourne le produit mis à jour
        return updatedProduct1;
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout,Integer productId){
        if(isSingleProductCheckout){


            List<Product> list=new ArrayList<>();
            Product product=productDao.findById(productId).get();
            list.add(product);
            return list;
        }else{

        }

        return new ArrayList<>();
    }

}
