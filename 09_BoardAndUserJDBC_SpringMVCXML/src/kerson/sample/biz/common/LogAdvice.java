package kerson.sample.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAdvice")
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* kerson.sample.biz..*(..))")
	private void allPointCut() {}
	@Pointcut("execution(* kerson.sample.biz.board.*Impl.get*(..))")
	private void getPointCut() {} 
	
	@Before("getPointCut()")
	public void beforeLogPrint(JoinPoint jp) {    
		System.out.println("====> ADVISOR beforeLogPrint() 호출!!"); 
	}
	
	@AfterReturning(pointcut="getPointCut()", returning="returnObj")
	public void afterReturnLogPrint(JoinPoint jp, Object returnObj) {
		System.out.println("====> ADVISOR afterReturnLogPrint() 호출!!");
	}
	
	@AfterThrowing(pointcut="getPointCut()", throwing="except")
	public void afterThrowLogPrint(JoinPoint jp, Exception except) {
		System.out.println("====> ADVISOR afterThrowLogPrint() 호출!!");
	}
	
	@Around("getPointCut()")
	public Object aroundLogPrint(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("====> ADVISOR aroundLogPrint() 호출!!");
		System.out.println("====> Around BEFORE 호출!!");
		Object returnObj = pjp.proceed();
		System.out.println("====> Around AFTER 호출!!");
		
		return returnObj;
	}
}
