package codepen.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@SpringBootTest(
    properties = {
        "server.port=18080",
        "management.server.port=19080"},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void test() throws Exception {
    String uri = "/";
    MockHttpServletRequestBuilder reqBuilder = 
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri);
    ResultHandler resHandler = 
        org.springframework.test.web.servlet.result.MockMvcResultHandlers.print();
    this.mockMvc.perform(reqBuilder).andDo(resHandler);
    return;
  }
}