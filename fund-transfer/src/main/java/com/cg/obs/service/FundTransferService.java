/**
 * 
 */
package com.cg.obs.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cg.obs.model.Account;
import com.cg.obs.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;

/**
 * @author sohel
 *
 */
@Service
public class FundTransferService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ObjectMapper mapper;

	public Account getAccountByAccountNo(String accountNo) {
		return restTemplate.getForEntity("http://localhost:5060/accounts/accounts/" + accountNo, Account.class)
				.getBody();
	}

	public void postTransaction(Transaction transaction) {
		System.out.println(transaction);
		// transaction.setTransactionId("id");
		String jsonString;

		try {
			jsonString = mapper.writeValueAsString(transaction);
			System.out.println(jsonString);
			final String baseUrl = "http://localhost:5060/transactions/transactions/add";
			URI uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate
					.postForEntity(uri, transaction, String.class);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// restTemplate.post
	}

	public void updateAccount(Account account) {
		restTemplate.put("http://localhost:5060/accounts/accounts/update", account);
	}
}
