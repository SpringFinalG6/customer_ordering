package com.group6.customer_ordering.controller;

import com.group6.customer_ordering.controller.reponse.ApiResponse;
import com.group6.customer_ordering.entity.Products;
import com.group6.customer_ordering.entity.projection.ProductProjection;
import com.group6.customer_ordering.payload.Product.ProductAddRequest;
import com.group6.customer_ordering.service.OrderService;
import com.group6.customer_ordering.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group6/product")
public class ProductRestController {

    private ProductService productService;
    private OrderService orderService;

    @Autowired
    public ProductRestController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @Operation(summary = "Find Product By Pagination")
    @Parameters({
            @Parameter(in = ParameterIn.QUERY
                    , description = "Page you want to retrieve (0..N)"
                    , name = "page"
                    , content = @Content(schema = @Schema(type = "integer", defaultValue = "0"))),
            @Parameter(in = ParameterIn.QUERY
                    , description = "Number of records per page."
                    , name = "size"
                    , content = @Content(schema = @Schema(type = "integer", defaultValue = "20")))
    })


    @GetMapping
    public ApiResponse<List<ProductProjection>> findAll(){
        List<ProductProjection> productList = (List<ProductProjection>) this.productService.findAll();
        if(productList.size() == 0){
            return new ApiResponse<>("404","No product data!");
        }
        return new ApiResponse<List<ProductProjection>>("200", "Successfully" , productList);
    }

    @GetMapping("{id}")
    public ApiResponse findProductById(@PathVariable Long id){
        Products products = this.productService.findProductById(id);
        if(products == null){
            return new ApiResponse<>("404", "Product with id "+ id +" is not found");
        }
        return new ApiResponse<>("200","Successfully", products);
    }

    @GetMapping("{name}")
    public ApiResponse findProductByName(@PathVariable String name){
        Products products = this.productService.findByNameContainsIgnoreCase(name);
        if(products == null){
            return new ApiResponse<>("404", "Product with name "+ name +" is not found");
        }
        return new ApiResponse<>("200","Successfully", products);
    }
    @GetMapping("{code}")
    public ApiResponse findProductByCode(@PathVariable String code){
        Products products = this.productService.findProductByCode(code);
        if(products == null){
            return new ApiResponse<>("404", "Product with code "+ code +" is not found");
        }
        return new ApiResponse<>("200","Successfully", products);
    }

    @GetMapping("{products}")
    public ApiResponse updateProduct(@PathVariable Products product) {
        Products products = this.productService.updateExistingProduct(product);
        if(products == null){
            return new ApiResponse<>("404", "Product "+ product +" is not found");
        }
        return new ApiResponse<>("200","Update product Successfully", products);
    }


    @PostMapping
    public ApiResponse createNewProduct(@RequestBody ProductAddRequest productAddRequest){

        Products products = new Products();
        products.setName(productAddRequest.getName());
        products.setCode(productAddRequest.getCode());
        products.setPrice(productAddRequest.getPrice());

        products = this.productService.createNewProduct(products);

        if(products == null){
            return new ApiResponse<>("500", "Product has not been inserted.");
        }
        return new ApiResponse<>("201","Product has been inserted.");
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteById(@PathVariable Long id){
      Products products = this.productService.findProductById(id);
       if(products == null){
          return new ApiResponse<>("404", "Product with id "+ id +" is not found");
       }
       this.productService.deleteExistingProductById(id);
       return new ApiResponse<>("200","Product has been deleted.");
   }
}
