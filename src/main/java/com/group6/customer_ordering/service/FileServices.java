package com.group6.customer_ordering.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.repository.CustomerRepository;
import com.group6.customer_ordering.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileServices{

    @Autowired
    CustomerRepository customerRepository;

    // Store File Data to Database
    public void store(MultipartFile file){
        try {
            List<Customers> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
            // Save Customers to DataBase
            customerRepository.saveAll(lstCustomers);
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

    // Load Data to Excel File
    public ByteArrayInputStream loadFile() {
        List<Customers> customers = (List<Customers>) customerRepository.findAll();

        try {
            ByteArrayInputStream in = ExcelUtils.customersToExcel(customers);
            return in;
        } catch (IOException e) {}

        return null;
    }

}

