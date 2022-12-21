package com.group6.customer_ordering.controller;

import com.group6.customer_ordering.controller.reponse.ApiResponse;
import com.group6.customer_ordering.controller.reponse.Pagination;
import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.Orders;
import com.group6.customer_ordering.entity.projection.OrderProjection;
import com.group6.customer_ordering.payload.Order.OrderAddRequest;
import com.group6.customer_ordering.service.CustomerService;
import com.group6.customer_ordering.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/group6/order")
public class OrderRestController {
    private OrderService orderService;
    private CustomerService customerService;

    public OrderRestController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @Operation(summary = "Find Order By Pagination")
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

    @GetMapping("/by-page")
    public ApiResponse<List<OrderProjection>> findOrderProjectionByDesc(
            @Parameter(hidden = true) Pagination pagination
    ){

        List<OrderProjection> orderList =
                (List<OrderProjection>) this.orderService.findOrderProjectionByOrderByCreatedAtDesc(pagination);
        if(orderList.size() == 0){
            return new ApiResponse<>("404","No data!");
        }
        return new ApiResponse<List<OrderProjection>>("200", "Successfully" , orderList);
    }

    @GetMapping
    public ApiResponse<List<OrderProjection>> findAll(){
        List<OrderProjection> orderList = this.orderService.findAll();
        if(orderList.size() == 0){
            return new ApiResponse<>("404","No data!");
        }
        return new ApiResponse<List<OrderProjection>>("200", "Successfully" , orderList);
    }

    @GetMapping("{id}")
    public ApiResponse findOrderById(@PathVariable Long id){
        Orders orders = this.orderService.findOrderById(id);
        if(orders == null){
            return new ApiResponse<>("404", "Order with id "+ id +" is not found");
        }
        return new ApiResponse<>("200","Successfully", orders);
    }

    @PostMapping
    public ApiResponse createNewOrder(@RequestBody OrderAddRequest orderAddRequest){

        Customers customer = this.customerService.findCustomerById(orderAddRequest.getCustomerId());
        if(customer == null){
      return new ApiResponse("404","Customer ID "+ orderAddRequest.getCustomerId() +" not found!");
     }

        Orders orders = new Orders();
        orders.setOrder_date(orderAddRequest.getOrder_date());
        orders.setCustomers(customer);
        orders = this.orderService.createNewOrder(orders);

        if(orders == null){
            return new ApiResponse<>("500", "Order has not been inserted.");
        }
        return new ApiResponse<>("201","Order has been inserted.");
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteById(@PathVariable Long id){
        Orders orders = this.orderService.findOrderById(id);
        if(orders == null){
            return new ApiResponse<>("404", "Order with id "+ id +" is not found");
        }
        this.orderService.deleteById(id);
        return new ApiResponse<>("200","Order has been deleted.");
    }


}
