package com.virtualpairprogrammers.client;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.domain.Action;
import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.services.calls.CallHandlingService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import com.virtualpairprogrammers.services.diary.DiaryManagementService;

public class Client {

	public static void main(String[] args) throws CustomerNotFoundException {

		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		CallHandlingService service = container.getBean("callHandling",CallHandlingService.class);
		
		
        DiaryManagementService diaryManagementService = container.getBean(DiaryManagementService.class);
		
//		List<Customer> allCustomers = service.getAllCustomers();
//
//		for (Customer next: allCustomers)
//		{
//			System.out.println(next);
//		}

         
		Call newCall = new Call("new call byshri");
		Action action1 = new Action("call back shri",new GregorianCalendar(2016,0,11),"shri");
		Action action2 = new Action("call back shri wih me",new GregorianCalendar(2016,0,0),"shri");
		Action action3 = new Action("call back shri not able to hear",new GregorianCalendar(2016,0,0),"shri");
		Collection<Action> actions = new HashSet<Action>();
		actions.add(action1);
		actions.add(action2);
		actions.add(action3);
		
 		service.recordCall("1", newCall, actions);
		
 	   List<Action> incompleteActions = diaryManagementService.getAllIncompleteActions("shri");
		for(Action next: incompleteActions){
			System.out.println(next);
		}
 	   
		container.close();
	}
}
