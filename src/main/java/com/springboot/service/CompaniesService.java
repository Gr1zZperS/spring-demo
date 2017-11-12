package com.springboot.service;

import com.springboot.model.Company;
import com.springboot.persistence.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompaniesService {

    @Autowired
    private CompaniesRepository repository;

    public List<Company> findAll() {
        return repository.findAll();
    }

}