package com.springboot.web;

import com.google.common.collect.ImmutableList;
import com.springboot.model.Company;
import com.springboot.service.CompaniesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompaniesControllerTest {

    @Mock
    private CompaniesService companiesService;

    @InjectMocks
    CompaniesController sut;

    @Test
    public void getListOfCompanies() throws Exception {
        when(companiesService.findAll()).thenReturn(ImmutableList.of());
        List<Company> listOfCompanies = sut.getListOfCompanies();
        verify(companiesService).findAll();
    }

}