package turnbough.accounts.controllers;

import org.springframework.web.bind.annotation.*;
import turnbough.accounts.models.Account;
import turnbough.accounts.services.AccountService;

import java.util.List;

/**
 * Rest Controller responsible for endpoints related to accounts.
 * All routes exposed by this controller are mapped under the {@code /accounts} base path.
 *
 * @author David Turnbough
 */
@RestController
@RequestMapping("/accounts")
public class AccountController
{
	/*
	 * Variables
	 */
	private final AccountService accountService;

	/*
	* Constructors
	 */
	/**
	 * Constructs a new {@code AccountService} and initializes its required dependencies.
	 * Injection is handled automatically via constructor-based dependency injection.
	 *
	 * @param accountService the business service layer responsible for executing account operations
	 */
	public AccountController(AccountService accountService)
	{
		this.accountService = accountService;
	}

	/*
	* Get Mapping
	 */
	/**
	 *
	 *
	 * @return the list of active accounts in the system
	 */
	@GetMapping("/allAccounts")
	public List<Account> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}

	/**
	 *
	 *
	 * @param accountId
	 * @return
	 */
	@GetMapping("/accountId={accountId}")
	public Account getAccountById(@PathVariable Long accountId)
	{
		return accountService.getAccountById(accountId);
	}

	/**
	 * Retrieves an account by its unique name.
	 *
	 * @param accountName
	 * @return
	 */
	@GetMapping("/accountName={accountName}")
	public Account getAccountByName(@PathVariable String accountName)
	{
		return accountService.getAccountByName(accountName);
	}

	/**
	 * Retrieves a list of {@code accounts} by the account type.
	 *
	 * @param accountType the type of account to search the system
	 * @return the list of accounts with the account type
	 */
	@GetMapping("/accountType={accountType}")
	public List<Account> getAccountsByType(@PathVariable String accountType)
	{
		return accountService.getAccountsByAccountType(accountType);
	}

	/*
	* POST MAPPING
	 */
	/**
	 * Creates a new account in the system.
	 *
	 * @param account the account to be added to the system
	 * @return the {@code account} added to the system
	 */
	@PostMapping("")
	public Account createAccount(@RequestBody Account account)
	{
		return accountService.createAccount(account);
	}

	// Put Mapping
	/**
	 * Updates an existing account in the system.
	 *
	 * @param account
	 * @return
	 */
	public Account updateAccount(@RequestBody Account account)
	{
		//TODO: Make sure the account exists, if not reject it

		return accountService.updateAccount(account);
	}

	/*
	* DELETE MAPPING
	 */
	/**
	 * Removes all accounts from the system.
	 */
	@DeleteMapping("/account/")
	public void deleteAllAccounts()
	{
		//TODO: Not working properly
		//  HttpRequestMethodNotSpupportedException
		accountService.deleteAllAccounts();
	}

	/**
	 * Removes an account with the given {@code accountId} from the system.
	 *
	 * @param accountId the id of the account to be deleted
	 */
	@DeleteMapping("/accounts/{accountId}")
	public void deleteAccountById(@PathVariable Long accountId)
	{
		accountService.deleteAccountById(accountId);
	}
}
