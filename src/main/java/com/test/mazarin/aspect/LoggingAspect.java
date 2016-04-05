package com.test.mazarin.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.mazarin.entity.Customer;
import com.test.mazarin.entity.Log;
import com.test.mazarin.service.LogService;

@Component
@Aspect
public class LoggingAspect {

	@Autowired
	private LogService logService;
	
	
	/*
	 * test comment change
	 */
	@After("execution(* com.test.mazarin.service.CustomerService.save(..))")
    public void logAfterAdd(JoinPoint joinPoint) {
		Object object = joinPoint.getArgs()[0];
		if(object instanceof Customer){
			Customer customer = (Customer) object;
			Log log = new Log();
			log.setMessage("customer id = "+customer.getId()+" is added");
			log.setDate(new Date());
			logService.addLog(log);
		}
    }
	
	@After("execution(* com.test.mazarin.service.CustomerService.deleteCustomer(..))")
    public void logAfterDelete(JoinPoint joinPoint) {
		Object object = joinPoint.getArgs()[0];
		if(object instanceof Integer){
			int id = (Integer) object;
			Log log = new Log();
			log.setMessage("customer id = "+id+" is deleted");
			log.setDate(new Date());
			logService.addLog(log);
		}
    }
	
	@After("execution(* com.test.mazarin.service.CustomerService.updateCustomer(..))")
    public void logAfterEdit(JoinPoint joinPoint) {
		Object object = joinPoint.getArgs()[0];
		if(object instanceof Customer){
			Customer customer = (Customer) object;
			Log log = new Log();
			log.setMessage("customer id = "+customer.getId()+" is edited");
			log.setDate(new Date());
			logService.addLog(log);
		}
    }
}
