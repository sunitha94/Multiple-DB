package com.mysqlpostgres.postgres.repo;

import com.mysqlpostgres.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepository  extends JpaRepository<Customer, Long> {
    Customer findById(Integer id);

}
