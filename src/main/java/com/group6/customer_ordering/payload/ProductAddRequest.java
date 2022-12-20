package com.group6.customer_ordering.payload;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductAddRequest {

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    @Size(max = 30)
    private String code;

}
