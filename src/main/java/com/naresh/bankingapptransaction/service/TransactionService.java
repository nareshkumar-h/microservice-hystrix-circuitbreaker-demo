package com.naresh.bankingapptransaction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TransactionService {

	@HystrixCommand(fallbackMethod = "defaultTransactions")
	public List<String> list(Integer accountId){
		System.out.println("Actual Method - accountId:" + accountId);
		ArrayList<String> list = new ArrayList<>();
		list.add("T1");
		list.add("T2");
		if ( accountId == 1) {		
			return list;
		}
		else {
			throw new RuntimeException("DB is down");
		}
	}

    public List<String> defaultTransactions(Integer accountId) {
    	System.out.println("Fallback Method - AccountId:" + accountId);
        List<String> arrayList = new ArrayList<>();
		return arrayList;
    }
    
    public List<String> listAllAccounts(){
		System.out.println("listAllAccounts");
		ArrayList<String> list = new ArrayList<>();
		list.add("T1");
		list.add("T2");
		list.add("T3");
		list.add("T4");
		return list;
	}
    
}
