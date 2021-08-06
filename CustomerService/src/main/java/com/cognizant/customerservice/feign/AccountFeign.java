package com.cognizant.customerservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cognizant.customerservice.model.Account;
import com.cognizant.customerservice.model.AccountCreationStatus;

@FeignClient(name = "account-ms", url = "${feign.url-account-service}")
public interface AccountFeign {

	@PostMapping("/createAccount/{customerId}")
	public AccountCreationStatus createAccount(@RequestHeader("Authorization") String token,
			@PathVariable String customerId, @RequestBody Account account);

	@GetMapping("/getAccounts/{customerId}")
	public List<Account> getCustomerAccount(@RequestHeader("Authorization") String token,
			@PathVariable String customerId);
	
	@DeleteMapping("deleteCustomer/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deleteCustomer(@RequestHeader("Authorization") String token, @PathVariable String id);

}
