package hu.rate.tanul.jpa;

import hu.rate.tanul.jpa.entity.User;
import hu.rate.tanul.jpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MysqlVaadinDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(MysqlVaadinDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MysqlVaadinDemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(UserRepository repository) {
//		return (args) -> {
//			// save a couple of customers
//			repository.save(new User("Jack", "Bauer"));
//			repository.save(new User("Chloe", "O'Brian"));
//			repository.save(new User("Kim", "Bauer"));
//			repository.save(new User("David", "Palmer"));
//			repository.save(new User("Michelle", "Dessler"));
//			repository.flush();
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (User customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			User customer = repository.findOne(1L);
//			log.info("Customer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
//			log.info("--------------------------------------------");
//			for (User bauer : repository.findByNameStartsWithIgnoreCase("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
//		};
//	}
}
