package com.jbk.Product_Rest_API.AOP;

import java.text.SimpleDateFormat;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class printTimeAdvice {
	
	                          //this is POINTCUT
	//@After(pointcut="execution ( * com.jbk.Product_Rest_API.controller.ProductController.*(..))")
	//@Before(pointcut="execution ( * com.jbk.Product_Rest_API.controller.ProductController.*(..))")
	//@AfterReturning(pointcut="execution ( * com.jbk.Product_Rest_API.controller.ProductController.*(..))", returning="result")
	@AfterThrowing(pointcut="execution ( * com.jbk.Product_Rest_API.controller.ProductController.*(..))")
	public void printTimeToCall() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		String FormatDate = sdf.format(new java.util.Date());
		
		//System.err.println("Method Starts At  >>" + FormatDate);
		
		//System.err.println("Method Ends At  >>" + FormatDate);
		
		//System.err.println("Method Returned At >>" + FormatDate);
		//System.out.println("Returned Value"+result);
		
		System.err.println("Exception Thrown At >>>"+FormatDate);
	}
	

}
