package turnbough.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Accounts microservice, responsible for managing user account data, balances, and repository
 *  operations.
 *
 * @author David Turnbough
 */
@SpringBootApplication
public class AccountsApplication {

	/**
	 * Boots the Spring Boot application context and initializes embedded server.
	 *
	 * @param args command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}