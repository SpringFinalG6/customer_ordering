package com.group6.customer_ordering.controller;

import com.group6.customer_ordering.controller.reponse.ApiResponse;
import com.group6.customer_ordering.controller.reponse.Pagination;
import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.projection.CustomerProjection;
import com.group6.customer_ordering.payload.Customer.CustomerAddRequest;
import com.group6.customer_ordering.service.CustomerService;
import com.group6.customer_ordering.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/group6/customer")
public class CustomerRestController {
    private CustomerService customerService;
    private OrderService orderService;

    @Autowired
    public CustomerRestController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @Operation(summary = "Find Customer By Pagination")
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

//    @GetMapping("/by-page")
//    public ApiResponse<List<CustomerProjection>> findCustomerProjectionByOrderByCreatedAtDesc(
//            @Parameter(hidden = true) Pagination pagination
//    ){
//
//        List<CustomerProjection> customerList =
//                (List<CustomerProjection>) this.customerService.findCustomerProjectionByOrderByCreatedAtDesc(pagination);
//        if(customerList.size() == 0){
//            return new ApiResponse<>("404","No data!");
//        }
//        return new ApiResponse<List<CustomerProjection>>("200", "Successfully" , customerList);
//    }

    @GetMapping
    public ApiResponse<List<CustomerProjection>> findAll(){
        List<CustomerProjection> customerList = (List<CustomerProjection>) this.customerService.findAll();
        if(customerList.size() == 0){
            return new ApiResponse<>("404","No data!");
        }
        return new ApiResponse<List<CustomerProjection>>("200", "Successfully" , customerList);
    }

    @GetMapping("{id}")
    public ApiResponse findCustomerById(@PathVariable Long id){
        Customers customers = this.customerService.findCustomerById(id);
        if(customers == null){
            return new ApiResponse<>("404", "Customer with id "+ id +" is not found");
        }
        return new ApiResponse<>("200","Successfully", customers);
    }

    @GetMapping("{username}")
    public ApiResponse findByUsername(@PathVariable String username){
        Customers customers = this.customerService.findByUsernameContainsIgnoreCase(username);
        if(customers == null){
            return new ApiResponse<>("404", "Customer with name "+ username +" is not found");
        }
        return new ApiResponse<>("200","Successfully", customers);
    }

    @GetMapping("{customers}")
    public ApiResponse updateCustomer(@PathVariable Customers customer) {
        Customers customers = this.customerService.updateExistingCustomer(customer);
        if(customers == null){
            return new ApiResponse<>("404", "Customer "+ customer +" is not found");
        }
        return new ApiResponse<>("200","Update customer Successfully", customers);
    }

    @PostMapping
    public ApiResponse createNewCustomer(@RequestBody CustomerAddRequest customerAddRequest){

        List<Orders> orderList = new ArrayList<>();
        for(Long orderId : customerAddRequest.getOrderIdList()){
            Orders orders = this.orderService.findOrderById(orderId);
            if(orders == null){
                return new ApiResponse("404", "Book with id "+ orderId +" is not found!" );
            }
            orderList.add(orders);
        }

        Customers customers = new Customers();
//        customers.setOrdersCollections(orderList);
        customers.setUsername(customerAddRequest.getUsername());
        customers.setEmail(customerAddRequest.getEmail());
        customers.setGender(customerAddRequest.getGender());
        customers = this.customerService.createNewCustomer(customers);

        if(customers == null){
            return new ApiResponse<>("500", "Customer has not been inserted.");
        }
        return new ApiResponse<>("201","Customer has been inserted.");
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteById(@PathVariable Long id){
        Customers user = this.customerService.findCustomerById(id);
        if(user == null){
            return new ApiResponse<>("404", "Customer with id "+ id +" is not found");
        }
        this.customerService.delete(id);
        return new ApiResponse<>("200","Customer has been deleted.");
    }


}
