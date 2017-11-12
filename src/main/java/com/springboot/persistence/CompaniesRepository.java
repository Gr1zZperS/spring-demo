package com.springboot.persistence;

import com.springboot.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompaniesRepository extends MongoRepository<Company, String> {

    List<Company> findByName(String name);

}
