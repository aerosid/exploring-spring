package codepen.reactjs;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@EnableAutoConfiguration
@ContextConfiguration(
    classes = {
        codepen.reactjs.DummyDataSource.class,
        codepen.reactjs.QuoteRepository.class,
        codepen.reactjs.DefaultController.class})
@SpringBootTest(
    properties = {
        "server.port=18080",
        "management.server.port=19080"},
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class DefaultControllerTest {

  private Logger logger;

  @Autowired
  private MockMvc mockMvc;

  public DefaultControllerTest() {
    super();
    this.logger = LoggerFactory.getLogger(this.getClass());
  }

  @Test
  public void nextQuote() throws Exception {
    String uri = "/api/ksadfa";
    MockHttpServletRequestBuilder reqBuilder =
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri);

    MvcResult result = this.mockMvc.perform(reqBuilder).andReturn();
    String response = result.getResponse().getContentAsString();
    this.logger.info("response: " + response);

    result = this.mockMvc.perform(reqBuilder).andReturn();
    response = result.getResponse().getContentAsString();
    this.logger.info("response: " + response);

    return;
  }

}