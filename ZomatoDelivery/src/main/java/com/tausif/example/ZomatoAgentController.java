package com.tausif.example;

import java.util.Map;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/zomato/delivery")
public class ZomatoAgentController {
 
	private final ZomatoAgentDeliveryService zomatoAgentDeliveryService;
	
	
	@PatchMapping("/getLocationOfAGent")
	public Map<String,String> getUpdatedLocation()
	{	
		int range=100;
		
		while(range>0)
		{
			zomatoAgentDeliveryService.updateDeleiveryAgentLocation(Math.random()+","+Math.random());
			
			range--;
		}
		return Map.of("message","Location Updated every Second");
		
	}
	
	
	
}
 