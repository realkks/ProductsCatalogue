package com.productservice.products.Controller;

import com.productservice.products.DTO.CreateProductResponseDto;
import com.productservice.products.DTO.CreateProductRequestDto;
import com.productservice.products.Models.Product;
import com.productservice.products.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products") // /products path will be common for all methods in this class .
public class ProductController {

    //String serviceType;
    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreImpl") ProductService productService){    // In qualifier we will add service class name
        this.productService = productService;                  //Assigning object of productService
    }

    @PostMapping("") // This method will create products .
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {   // We will receive dto object as part of request body
        Product product = productService.createProduct(createProductRequestDto.toProduct());  // It will return a models

        // Convert product to response form
        return CreateProductResponseDto.fromProduct(product);  // It will return product
         //return "This product is priced at :"product.getPrice();
    }

    @GetMapping("")
    public void getAllProducts(){

    }
    @GetMapping("/{id}")        // Variable path
    public String getSingleProduct(@PathVariable ("id") long id){    // Defining path variable and receiving required id.
        return "Here is your product" + id ;
    }

    @DeleteMapping("/{id}")
    public void deleteSingleproduct(){

    }
    @RequestMapping(name="kamlesh",value="/kamlesh")    // To create user defined request type
    public String something(){
    return "Kamlesh magic ";
    }
}
