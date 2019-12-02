package io.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.java.dto.SquadDetails;
import io.java.services.SquadService;

@RestController
public class SquadController {
	
	@Autowired
	SquadService squadService;
	
	/**
	 * Method to insert the details of squad
	 * @param squadDetails
	 */
	@RequestMapping(method=RequestMethod.POST,value = "/squadDetails")
	public void insertSquadDetails(@RequestBody SquadDetails squadDetails){		
		squadService.insertSquadDetails(squadDetails);		
	}
	
	/**
	 * Method to retrieve the details of the squad
	 * @param name
	 * @return squadDetails
	 */
	@RequestMapping("/squadDetails/{name}")
	public SquadDetails getSquadDetails(@PathVariable String name){
		return squadService.getSquadDetails(name);	
	}
	
	
	/**
	 * Method to retrieve the details of the squad
	 * @param name
	 * @return squadDetails
	 */
	@RequestMapping("/squadDetailsWithoutPrimary/{tribe}")
	public List<SquadDetails> getSquadDetailsWithoutPrimaryKey(@PathVariable String tribe){
		return squadService.getSquadDetailsWithoutPrimaryKey(tribe);	
	}
	
	
	/**
	 * Method to retrieve all the squadDetails from DB
	 * @return List<squadDetails>
	 */
	@RequestMapping("/squadDetails")
	public List<SquadDetails> getAllSquadDetails(){
		return squadService.getAllSquadDetails();	
	}
	
	
	

}
