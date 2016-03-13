package kerson.sample.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvice {
	
	public void beforeLogPrint(JoinPoint jp) { 
		System.out.println("====> ADVISOR beforeLogPrint() 호출!!"); 
	}
	
	public void afterReturnLogPrint(JoinPoint jp, Object returnObj) {
		System.out.println("====> ADVISOR afterReturnLogPrint() 호출!!");
	}
	
	public void afterThrowLogPrint(JoinPoint jp, Exception except) {
		System.out.println("====> ADVISOR afterThrowLogPrint() 호출!!");
	}
	
	public Object aroundLogPrint(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("====> ADVISOR aroundLogPrint() 호출!!");
		System.out.println("====> Around BEFORE 로직!!");
		Object returnObj = pjp.proceed();
		System.out.println("====> Around AFTER 로직!!");
		
		return returnObj;
	}
}
