package com.exe1.jwtexe1.controller;


import com.exe1.jwtexe1.entity.ImageModel;
import com.exe1.jwtexe1.entity.Product;
import com.exe1.jwtexe1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProductController {



    @Autowired
    ProductService productService;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = {"/addNewProduct"},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(@RequestPart("product") Product product,
                           @RequestPart("imageFile")MultipartFile[] file) throws IOException {
       //productService.addNewProduct(product);
             try{
                 Set<ImageModel> images=uploadImage(file);
                 product.setProductImages(images);
                 return productService.addNewProduct(product);
             }catch(Exception e){
           System.out.println(e.getMessage());
           return null;
             }
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles)throws IOException {

        Set<ImageModel> imageModels= new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel= new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @GetMapping({"/getAllProduct"})
    public List<Product> getAllProduct(){
      return productService.getAllProduct();
    }
    @PreAuthorize("hasRole('Admin')")
    @PutMapping({"/updateProduct/{productId}"})
    public Product updateProduct(@PathVariable Integer productId,@RequestBody Product product){
     return productService.updateProduct(productId,product);
    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping({"/deletProductDetails/{productId}"})
    public void deletProductDetails(@PathVariable("productId") Integer productId){
        productService.deletProductDetail(productId);
    }


    @GetMapping({"/getProductById/{productId}"})
    public Product getProductById(@PathVariable("productId") Integer productId){
       return  productService.getProductById(productId);
    }



}
