package com.group6.customer_ordering.controller;

import com.group6.customer_ordering.controller.reponse.ApiResponse;
import com.group6.customer_ordering.entity.Order_detail;
import com.group6.customer_ordering.payload.OrderDetail.OrderDetailAddRequest;
import com.group6.customer_ordering.payload.OrderDetail.OrderDetailUpdateRequest;
import com.group6.customer_ordering.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OrderDetailRestController.ROOT_URL)
@Slf4j
public class OrderDetailRestController {

    protected static final String ROOT_URL = "/api/v1/backoffice/order_detail";

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping
    public ApiResponse add(@RequestBody OrderDetailAddRequest addRequest){
        Order_detail addOrder = new Order_detail();
        addOrder.setProducts(addRequest.getProducts());
        addOrder.setOrders(addRequest.getOrders());
        addOrder.setQuantity(addRequest.getQuantity());
        addOrder.setPrice(addRequest.getPrice());
        addOrder = this.orderDetailService.add(addOrder);
        if(addOrder == null){
            return new ApiResponse<>("500", "Category has not been inserted.");
        }
        return new ApiResponse<>("201","Category has been inserted.");
    }

    @GetMapping
    public ApiResponse<List<Order_detail>> findAll(){
        List<Order_detail> order_details = this.orderDetailService.findAll();
        if(order_details.size() == 0){
            return new ApiResponse<>("404","No data!");
        }
        return new ApiResponse<List<Order_detail>>("200", "Successfully" , order_details);
    }

    @GetMapping("{id}")
    public ApiResponse findById(@PathVariable Long id){
        Order_detail order_detail = this.orderDetailService.findById(id);
        if(order_detail == null){
            return new ApiResponse<>("404", "Order_detail with id "+ id +" is not found");
        }
        return new ApiResponse<>("200","Successfully", order_detail);
    }

    @PutMapping
    public ApiResponse updateExistingUser(@RequestBody OrderDetailUpdateRequest orderDetailUpdateRequest){

        Order_detail order_detail = this.orderDetailService.findById(orderDetailUpdateRequest.getId());
        if(order_detail == null){
            return new ApiResponse<>("404", "Order_detail with id "+ orderDetailUpdateRequest.getId() +" is not found");
        }
        order_detail.setProducts(orderDetailUpdateRequest.getProducts());
        order_detail.setOrders(orderDetailUpdateRequest.getOrders());
        order_detail.setQuantity(orderDetailUpdateRequest.getQuantity());
        order_detail.setPrice(orderDetailUpdateRequest.getPrice());
        this.orderDetailService.update(order_detail);
        return new ApiResponse<>("201","Order_detail has been updated.");
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteById(@PathVariable Long id){
        Order_detail order_detail = this.orderDetailService.findById(id);
        if(order_detail == null){
            return new ApiResponse<>("404", "Order_detail with id "+ id +" is not found");
        }
        this.orderDetailService.delete(id);
        return new ApiResponse<>("200","Order_detail has been deleted.");
    }

}
