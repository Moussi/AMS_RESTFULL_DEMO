package com.moussi;

/**
 * Created by amoussi on 20/10/16.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceClientEurekaTests.class, RestTemplate.class})
public class ServiceClientEurekaTests {

  @Autowired
  RestTemplate restTemplate;

  @Test
  public void dicoverEurekaTest() throws Exception {

    final String retour = restTemplate.getForObject("http://service-client-eureka/infosDiscoveryClient", String.class);
    //Assert...
  }
}
