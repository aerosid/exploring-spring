package com.example;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class DefaultController {

  private Logger logger;

  @Autowired
  public DefaultController() {
    super();
    this.logger = LoggerFactory.getLogger(this.getClass());
  }

  @RequestMapping(
      path = "*",
      method = {RequestMethod.GET, RequestMethod.POST},
      produces = "application/json")
  public Map<String, String> doRequest() {

    try {
      Thread.sleep(2000L);
    } catch (InterruptedException e) {
      this.logger.error("Exception:" + e.getMessage());
    }

    Map<String, String> map = java.util.Map.of("status", "ok");
    this.logger.info("status: " + map.get("status"));
    return map;
  }
}