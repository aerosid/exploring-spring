package codepen.web;

import codepen.jdbc.DbOperation;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

  private DbOperation dbOperation;

  private Logger logger;

  @Autowired
  public SomeController(DbOperation dbOperation) {
    super();
    this.logger = LoggerFactory.getLogger(this.getClass());
    this.dbOperation = dbOperation;
  }

  @GetMapping(path = "/do-get", produces = "text/plain; charset=UTF-8")
  public String doGet(@RequestHeader HttpHeaders headers) {    
    Set<String> keys = headers.keySet();
    Iterator<String> i = keys.iterator();
    while (i.hasNext()) {
      String key = (String)i.next();
      List<String> values = headers.get(key);
      Iterator<String> j = values.iterator();
      while (j.hasNext()) {
        String value = (String)j.next();
        String message = "key:" + key + ", value:" + value;
        this.logger.info(message);
      }
    }
    return "do get";
  }

  @GetMapping(path = "/", produces = "text/plain; charset=UTF-8")
  public String getVersion() {
    String version = this.dbOperation.getVersion();
    return version;
  }

}