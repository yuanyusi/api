package com.greglturnquist.payroll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringMVCRESTFulController {
	private final GoalRepository repository;

	@Autowired
	public SpringMVCRESTFulController(GoalRepository repository) {
		this.repository = repository;
	}

	
	/*@RequestMapping(value = "/dataSearch/{name}",  method=RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List<Integer> populateActivePSwapBasketGET(@PathVariable String name) {		
		
		if (name.equalsIgnoreCase("JavaHonk")) {
			return returnDataList();
			//Collection<Goal> lGoal = null;
			//return lGoal;
		}else {
			//int id = Integer.parseInt(name);
			//return this.repository.findById(id);
			List<Integer> list = new ArrayList<Integer>();
			list.add(12345);
			return list;
		}
		
	}*/
	
	@RequestMapping(value = "/api/goals/data/{name}",  method=RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List<Goal> populateActivePSwapBasketGET(@PathVariable String name) {		
		
		if (name.equalsIgnoreCase("JavaHonk")) {
			return null;
		}else {
			Long id = Long.parseLong(name);
			Goal goal = this.repository.findOne(id);
			List<Goal> lGoal = new ArrayList<Goal>();
			lGoal.add(goal);
			return lGoal;
		}
		
	}
	
	@RequestMapping(value = "/api/goals/data/{name}",  method=RequestMethod.PUT, produces={"application/json"})
	//public @ResponseBody List<Goal> populateActivePSwapBasketPUT(@PathVariable String name, @RequestBody String data ) throws ParseException {		
	public @ResponseBody Goal populateActivePSwapBasketPUT(@PathVariable String name){
		
		if (name.equalsIgnoreCase("JavaHonk")) {
			return null;
		}else {
			
			//JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(data);
			//String updatedAt = (String) genreJsonObject.get("updatedAt");
            
			Long id = Long.parseLong(name);
			Goal goal = this.repository.findOne(id);
			List<Goal> lGoal = new ArrayList<Goal>();
			lGoal.add(goal);
			
			ArrayList<Date> successes = goal.getSuccesses();
			successes.add(new Date()); 
			
			goal.setSuccesses(successes);
			//goal.setUpdatedAt(updatedAt);
			this.repository.save(goal);
			return goal;
		}
		
	}
	
	@RequestMapping(value = "/api/goals/failures/{name}",  method=RequestMethod.PUT, produces={"application/json"})
	public @ResponseBody List<Goal> populateFailuresPUT(@PathVariable String name) {		
		
		if (name.equalsIgnoreCase("JavaHonk")) {
			return null;
		}else {
			Long id = Long.parseLong(name);
			Goal goal = this.repository.findOne(id);
			List<Goal> lGoal = new ArrayList<Goal>();
			lGoal.add(goal);
			
			ArrayList<Date> failures = goal.getFailures();
			failures.add(new Date()); 
			
			goal.setFailures(failures);
			this.repository.save(goal);
			return lGoal;
		}
		
	}

	@RequestMapping(value = "/populateDataFromServer", method=RequestMethod.POST, produces={"application/json"})
	public @ResponseBody List<Integer> populateActivePSwapBasketPOST(@RequestParam String name) {		
		
		if (name.equalsIgnoreCase("JavaHonk")) {
			return returnDataList();
		}else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(12345);
			return list;
		}
	}
	
/*	@RequestMapping(value = "/populateDataFromServer/{name}", method=RequestMethod.PUT, produces={"application/json"})
	public @ResponseBody List<Integer> populateActivePSwapBasketPUT(@PathVariable String name) {		
		
		if (name.equalsIgnoreCase("JavaHonk")) {
			return returnDataList();
		}else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(12345);
			return list;
		}
	}*/
	
	@RequestMapping(value = "/populateDataFromServer/{name}", method=RequestMethod.DELETE, produces={"application/json"})
	public @ResponseBody List<Integer> populateActivePSwapBasketDelete(@PathVariable String name) {		
		
		if (name.equalsIgnoreCase("JavaHonk")) {
			return returnDataList();
		}else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(12345);
			return list;
		}
	}
	
	private List<Integer> returnDataList() {
		Random rand = new Random();
	    Integer randomNum = rand.nextInt();		
		List<Integer> list = new ArrayList<Integer>();
		list.add(randomNum);		
		return list;
	}

}
