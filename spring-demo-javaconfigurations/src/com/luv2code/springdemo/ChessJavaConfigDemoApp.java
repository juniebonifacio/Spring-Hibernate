package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChessJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve bean from spring container
		ChessCoach theCoach = context.getBean("chessCoach", ChessCoach.class);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
	}

}
