package com.virtualpairprogrammers.services.calls;

import java.util.Collection;

import com.virtualpairprogrammers.domain.Action;
import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import com.virtualpairprogrammers.services.diary.DiaryManagementService;

public class CallHandlingServiceImpl implements CallHandlingService {
	
	private CustomerManagementService customerService;
	private DiaryManagementService diaryService;
	
	public CallHandlingServiceImpl(CustomerManagementService customerManagementService,DiaryManagementService diaryManagementService){
		
		this.customerService = customerManagementService;
		this.diaryService = diaryManagementService;
		
	}
	

	@Override
	public void recordCall(String customerId, Call newCall, Collection<Action> actions)
			throws CustomerNotFoundException {
		customerService.recordCall(customerId, newCall);
		
		for(Action action: actions){
			diaryService.recordAction(action);
		}
		
	}

}
