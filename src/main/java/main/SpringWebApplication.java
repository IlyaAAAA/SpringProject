package main;

import main.entity.ExpenseItem;
import main.repository.ExpenseItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebApplication {

  @Autowired
  ExpenseItemRepository expenseItemRepository;

  //private static final Logger log = LoggerFactory.getLogger(SpringWebApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringWebApplication.class, args);
  }

//  @Bean
//  public CommandLineRunner test(ExpenseItemRepository repository) {
//    return args -> {
//      repository.save(new ExpenseItem("First eee"));
//      repository.save(new ExpenseItem("Second eee"));
//
//      for (ExpenseItem item : repository.findAll()) {
//        log.info("The application is : " + item.toString());
//      }
//    };
//  }
}
