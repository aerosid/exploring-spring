package codepen.web;

import codepen.jdbc.DbOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

  private DbOperation dbOperation;

  @Autowired
  public SomeController(DbOperation dbOperation) {
    super();
    this.dbOperation = dbOperation;
  }

  @GetMapping(path = "/", produces = "text/plain; charset=UTF-8")
  public String getVersion() {
    String version = this.dbOperation.getVersion();
    return version;
  }

}