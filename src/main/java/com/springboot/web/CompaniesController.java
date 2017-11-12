package com.springboot.web;

import com.springboot.model.Company;
import com.springboot.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {

    @Autowired
    private CompaniesService companiesService;

    @RequestMapping
    public List<Company> getListOfCompanies() {
        return companiesService.findAll();
    }

}
