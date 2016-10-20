package com.moussi.rest;

/**
 * Created by amoussi on 20/10/16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
public class RestControllerClientEureka {
  @Autowired
  private DiscoveryClient discoveryClient;
  @LoadBalanced
  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/infosDiscoveryClient")
  String infos() throws Exception {
    final StringBuilder sb = new StringBuilder();
    final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRANCE);
    discoveryClient.getInstances("service-client-eureka")
        .forEach(
            si ->
            {
              sb.append(si.getServiceId());
              sb.append(" uri=");
              sb.append(si.getUri());
            }
        );
    return "<h2>Infos (à " + df.format(new Date()) + ") : " + sb.toString() + "</h2>\n";
  }

  @RequestMapping({"/infos", "/"})
  String restInfos() throws Exception {
    final String retour = restTemplate.getForObject("http://service-client-eureka/infosDiscoveryClient", String.class);

    return retour;
  }
}
