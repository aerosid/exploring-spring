package codepen.reactjs;

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

  private QuoteRepository quoteRepository;

  @Autowired
  public DefaultController(QuoteRepository quoteRepository) {
    super();
    this.logger = LoggerFactory.getLogger(this.getClass());
    this.quoteRepository = quoteRepository;
  }

  @RequestMapping(
      path = "*",
      method = {RequestMethod.GET, RequestMethod.POST},
      produces = "application/json")
  public Quote nextQuote() {

    try {
      Thread.sleep(2000L);
    } catch (InterruptedException e) {
      this.logger.error("Exception:" + e.getMessage());
    }

    Quote q = this.quoteRepository.nextQuote();
    this.logger.info("Quote.id:" + q.id);
    return q;
  }
}