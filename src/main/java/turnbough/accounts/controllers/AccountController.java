package turnbough.accounts.controllers;

import org.springframework.web.bind.annotation.*;
import turnbough.accounts.models.Account;
import turnbough.accounts.services.AccountService;

import java.util.List;

/**
 *
 *
 * @author David Turnbough
 */
@RestController
@RequestMapping("/accounts")
public class AccountController
{
	/*
	 * VARIABLES
	 */
	private final AccountService accountService;

	/**
	 * Constructor
	 * Injection is handled automatically via constructor-based dependency injection.
	 *
	 * @param accountService the business service layer responsible for executing account operations
	 */
	public AccountController(AccountService accountService)
	{
		this.accountService = accountService;
	}

	/*
	 * GET MAPPING
	 */
	/**
	 * Retrieves a list of active accounts in the system.
	 *
	 * @return List of Account objects
	 */
	@GetMapping("/allAccounts")
	public List<Account> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}

	@GetMapping("/accountId={accountId}")
	public Account getAccountById(@PathVariable Long accountId)
	{
		return accountService.getAccountById(accountId);
	}

	@GetMapping("/accountName={accountName}")
	public Account getAccountByName(@PathVariable String accountName)
	{
		return accountService.getAccountByName(accountName);
	}

	@GetMapping("/accountType={accountType}")
	public List<Account> getAccountsByType(@PathVariable String accountType)
	{
		return accountService.getAccountsByAccountType(accountType);
	}

	/*
	 * POST MAPPING
	 */
	@PostMapping("")
	public Account createAccount(@RequestBody Account account)
	{
		return accountService.createAccount(account);
	}

	/*
	 * PUT MAPPING
	 */

	//TODO: Create a method to update an account
	//TODO: Change account attributes; account name, address, phone number, etc


	/*
	 * DELETE MAPPING
	 */
	@DeleteMapping("/account/")
	public void deleteAllAccounts()
	{
		//TODO: Not working properly
		//  HttpRequestMethodNotSpupportedException
		accountService.deleteAllAccounts();
	}

	@DeleteMapping("/accounts/{accountId}")
	public void deleteAccountById(@PathVariable Long accountId)
	{
		accountService.deleteAccountById(accountId);
	}
}
