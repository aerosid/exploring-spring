package codepen.web;

import codepen.jdbc.DbOperation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@WebMvcTest(controllers = {codepen.web.SomeController.class})
public class UnitTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DbOperation dbOperation;

  @Test
  public void doGet() throws Exception {
    String uri = "/do-get";
    MockHttpServletRequestBuilder reqBuilder =
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders
        .get(uri)
        .header("User-Agent", "Spring Boot")
        .header("User-Agent", "Java");
    ResultHandler resHandler =
        org.springframework.test.web.servlet.result.MockMvcResultHandlers.print();
    this.mockMvc.perform(reqBuilder).andDo(resHandler);
    return;
  }

  @Test
  public void getVersion() throws Exception {
    String uri = "/";
    MockHttpServletRequestBuilder reqBuilder =
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri);
    ResultHandler resHandler =
        org.springframework.test.web.servlet.result.MockMvcResultHandlers.print();
    org.mockito.Mockito.when(this.dbOperation.getVersion()).thenReturn("0.0.0-MOCK");
    this.mockMvc.perform(reqBuilder).andDo(resHandler);
    return;
  }
}