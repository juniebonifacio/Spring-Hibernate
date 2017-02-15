package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesFileFortuneService implements FortuneService {

	@Value("${foo.fortune}")
	private String data;
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		System.out.println("data: " + data);
		String[] listOfFortunes = data.split(",");
		System.out.println("listOfFortunes: " + listOfFortunes);
		int index = myRandom.nextInt(listOfFortunes.length);
		
		String theFortune = listOfFortunes[index];
		
		return theFortune;
	}

}
