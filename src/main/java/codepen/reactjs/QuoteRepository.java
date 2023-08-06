package codepen.reactjs;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QuoteRepository {

  private String[] authors;

  private int currentIndex;

  private String[] messages;

  public QuoteRepository() {
    super();
    this.currentIndex = -1;
    this.authors = new String[]{ 
      "Robert C. Martin", 
      "Edward V.Berad", 
      "Roy Carlson",
      "Linus Torvalds" };
    this.messages = new String[]{ 
      "Truth can only be found in one place: the code.", 
      "Walking on water and developing software from a specification are easy if both are frozen.", 
      "The sooner you start to code, the longer the program will take.",
      "Talk is cheap. Please show me the code."};
  }

  public Quote nextQuote() {
    synchronized (this) {
      this.currentIndex = ((this.currentIndex + 1) > 3) ? 0 : this.currentIndex + 1;
      this.notifyAll();
    }
    Quote q = new Quote();
    q.id = this.currentIndex;
    q.message = this.messages[this.currentIndex];
    q.author = this.authors[this.currentIndex];
    return q;
  }

}