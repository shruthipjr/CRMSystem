package com.virtualpairprogrammers.services.diary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.virtualpairprogrammers.domain.Action;

public class DiaryManagementMockImpl implements DiaryManagementService {

	private Set<Action> allAction = new HashSet<Action>();
	
	
	@Override
	public void recordAction(Action action) {

		allAction.add(action);
	}

	@Override
	public List<Action> getAllIncompleteActions(String requiredUser) {
		
		List<Action> actionList = new ArrayList<Action>();
		for(Action next: allAction){
			if(next.getOwningUser().equals(requiredUser) && !next.isComplete()){
				actionList.add(next);
			}
		}
		return actionList;
	}

}
