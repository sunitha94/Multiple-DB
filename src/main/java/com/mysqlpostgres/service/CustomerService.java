package com.mysqlpostgres.service;

import com.mysqlpostgres.domain.Customer;
import com.mysqlpostgres.mysql.repo.MysqlRepository;
import com.mysqlpostgres.postgres.repo.PostgresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private @Autowired
    MysqlRepository mysqlRepository;
    private @Autowired
    PostgresRepository postgresRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public Customer saveDetails(Customer customer) {

        LOGGER.info("*****CUSTOMERID*******"+customer.getType());

        if(customer.getType().equals("Corpo")){
            return mysqlRepository.save(customer);
        }
       else
        return postgresRepository.save(customer);
    }

    public Customer getDetails(Integer customerId) {
        Customer customer=null;
        customer=mysqlRepository.findById(customerId);
        if(null==customer){
            customer=postgresRepository.findById(customerId);
        }
        return customer;

    }
}
