package com.springboot.web;

import com.google.common.collect.ImmutableList;
import com.springboot.model.Company;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompaniesControllerIT {

    private TestRestTemplate template = new TestRestTemplate();

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void before(){
        mongoTemplate.dropCollection(Company.class);
        mongoTemplate.save(new Company("company1", "logo", "website", "address", "phone"));
        mongoTemplate.save(new Company("company2", "logo", "website", "address", "phone"));
    }

    @Test
    public void testGetListOfCompanies() throws Exception {
        ResponseEntity<List<Company>> responseEntity =
                template.exchange("http://localhost:8090/api/companies", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Company>>() {
                });

        List<Company> actualList = responseEntity.getBody();
        assertThat(actualList.size(), is(2));
        List<String> actualName = actualList.stream()
                .map(Company::getName)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertThat(actualName, containsInAnyOrder("company1","company2"));
    }
}