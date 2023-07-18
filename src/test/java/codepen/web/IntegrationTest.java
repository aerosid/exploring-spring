package codepen.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
    properties = {
        "server.port=18080",
        "management.server.port=19080"},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void test() throws Exception {
    String url = "http://localhost:" + this.port + "/";
    String response = this.restTemplate.getForObject(url, String.class);
    System.out.println("response: " + response);
  }

}