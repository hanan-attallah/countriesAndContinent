package com.javahelps.mysql_rest_service;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.javahelps.restservice.repository.CountryRepository;
import com.javahelps.restservice.service.CountryService;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AppTest extends TestCase {
	
	
	
	@Autowired
    private TestRestTemplate restTemplate;
	@MockBean
    private CountryRepository countryRepository;
    @Autowired
    private CountryService carService;

	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void basicTest() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Not Found");
    }
    
    
    
    
}
