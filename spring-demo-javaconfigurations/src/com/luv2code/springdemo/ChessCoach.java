package com.luv2code.springdemo;

public class ChessCoach implements Coach {

	private FortuneService fortuneService;
	
	public ChessCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Check game everyday!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
