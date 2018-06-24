package com.mysqlpostgres.controller;

import com.mysqlpostgres.domain.Customer;
import com.mysqlpostgres.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private @Autowired
    CustomerService customerService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);


    @PostMapping("/save")
    public @ResponseBody Customer save(@RequestBody Customer customer){
        LOGGER.info("*****Controller*******"+customer.getType());
        return customerService.saveDetails(customer);
    }

    @RequestMapping("/get-details-by-id")
    public @ResponseBody
    Customer getDetails(Integer customerId) {
        LOGGER.info("*****CUSTOMERID*******", customerId);
        return customerService.getDetails(customerId);
    }
}
