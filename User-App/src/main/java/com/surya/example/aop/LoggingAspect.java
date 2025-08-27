package com.surya.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect // we are to spring this extra logic iam writing
@Component // a spring take care of this class (object creation)
@Slf4j
public class LoggingAspect {

	
	//this this methods 
	@Before("execution(* com.surya.example.controllers.UserController.addUser(..)) ")
	public void logbeforeAddUser(JoinPoint joinPoint) {
		log.error("loging something before addNewUser Endpoint");
		log.error("which method we are calling! {}",joinPoint.getSignature().getName());
		log.error("loging something before addNewUser Endpoint");
	}

}
