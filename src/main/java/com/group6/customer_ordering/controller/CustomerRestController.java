package com.group6.customer_ordering.controller;

import com.group6.customer_ordering.controller.reponse.ApiResponse;
import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.projection.CustomerProjection;
import com.group6.customer_ordering.payload.Customer.CustomerAddRequest;
import com.group6.customer_ordering.payload.Customer.CustomerUpdateRequest;
import com.group6.customer_ordering.service.CustomerService;
import com.group6.customer_ordering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group6/customer")
public class CustomerRestController {
    private CustomerService customerService;
//    private OrderService orderService;

    @Autowired
    public CustomerRestController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
//        this.orderService = orderService;
    }


    @GetMapping
    public ApiResponse<List<CustomerProjection>> findAll(){
        List<CustomerProjection> customerList = this.customerService.findAll();
        if(customerList.size() == 0){
            return new ApiResponse<>("404","No data!");
        }
        return new ApiResponse<List<CustomerProjection>>("200", "Successfully" , customerList);
    }

    @GetMapping("{id}")
    public ApiResponse findCustomerById(@PathVariable Long id){
        Customers customers = this.customerService.findCustomerById(id);
        if(customers == null){
            return new ApiResponse<>("404", "User with id "+ id +" is not found");
        }
        return new ApiResponse<>("200","Successfully", customers);
    }

    @GetMapping("{username}")
    public ApiResponse findByUsername(@PathVariable String username){
        Customers customers = this.customerService.findByUsernameContainsIgnoreCase(username);
        if(customers == null){
            return new ApiResponse<>("404", "Customer with id "+ username +" is not found");
        }
        return new ApiResponse<>("200","Successfully", customers);
    }

    @PostMapping
    public ApiResponse createNewCustomer(@RequestBody CustomerAddRequest customerAddRequest){
        Customers customers = new Customers();

        customers.setUsername(customerAddRequest.getUsername());
        customers.setPhone(Integer.parseInt(customerAddRequest.getPhone()));
        customers.setEmail(customerAddRequest.getEmail());
        customers.setAddress(customerAddRequest.getAddress());
        customers.setGender(customerAddRequest.getGender());
        customers = this.customerService.createNewCustomer(customers);

        if(customers == null){
            return new ApiResponse<>("500", "Customer has not been inserted.");
        }
        return new ApiResponse<>("201","Customer has been inserted.");
    }

    @PutMapping
    public ApiResponse updateCustomer(@PathVariable CustomerUpdateRequest customerUpdateRequest) {
        Customers customers = this.customerService.findCustomerById(customerUpdateRequest.getId());
        if(customers == null){
            return new ApiResponse<>("404", "Customer with id "+ customerUpdateRequest.getId() +" is not found");
        }
        customers.setUsername(customerUpdateRequest.getUsername());
        customers.setPhone(Integer.parseInt(customerUpdateRequest.getPhone()));
        customers.setEmail(customerUpdateRequest.getEmail());
        customers.setAddress(customerUpdateRequest.getAddress());
        customers.setGender(customerUpdateRequest.getGender());
        this.customerService.updateExistingCustomer(customers);
        return new ApiResponse<>("201","Customer has been updated.");
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteById(@PathVariable Long id){
        Customers user = this.customerService.findCustomerById(id);
        if(user == null){
            return new ApiResponse<>("404", "User with id "+ id +" is not found");
        }
        this.customerService.delete(id);
        return new ApiResponse<>("200","User has been deleted.");
    }

}
