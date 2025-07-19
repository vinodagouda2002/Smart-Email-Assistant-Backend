package com.AI_Project_smart_Email_Assistance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
 
@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailGeneratorController {
	
	private final EmailGeneratorService emailGeneratorService;
	
	@PostMapping("/generate")
	public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
		String response =emailGeneratorService.generateEmailReply(emailRequest);
		
		return ResponseEntity.ok(response);
		 

	}

}
