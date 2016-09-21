package com.erick.calendarioalmoco.util.loggin;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producer class which returns a logger object {@link Logger}
 * 
 * @author Erick
 */
public class LoggerProducer {
	
	@Produces
	public Logger criaLogger(InjectionPoint injectionPoint){
		
		Class<?> clazz = injectionPoint.getMember()
				.getDeclaringClass();
		
		return LoggerFactory.getLogger(clazz.getName());
	}
}