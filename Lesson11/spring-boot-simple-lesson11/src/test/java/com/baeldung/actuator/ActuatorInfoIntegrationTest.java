package com.baeldung.actuator;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)

public class ActuatorInfoIntegrationTest {

    @Autowired 
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
       System.out.println("Setting up test");
   }
   @After
   public void teardown() {
       System.out.println("tearing down");
   }

    @Test
    public void whenGetInfo_thenReturns200() {
        final ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/actuator/info", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void whenFeatures_thenReturns200() {
        final ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/actuator/features", String.class);
        System.out.println("body: " + responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}