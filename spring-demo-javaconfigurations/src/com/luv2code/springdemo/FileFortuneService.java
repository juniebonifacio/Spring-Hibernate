package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "C:/workspace/Spring-Hibernate/spring-demo-annotations/src/fortune-data.txt";
	private List<String> theFortunes;
	
	// create a random number generator
	private Random myRandom = new Random();
	
	public FileFortuneService() {

		theFortunes = new ArrayList<String>();
		
/*		BufferedReader br = null;
		try {
			File theFile = new File(fileName);
			System.out.println("Reading fortunes from file: " + theFile);
			System.out.println("File exists: " + theFile.exists());
			br = new BufferedReader(new FileReader(theFile));
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(theFortunes.size());

		String tempFortune = theFortunes.get(index);

		return tempFortune;
	}
	
	@PostConstruct
	public void readFortunesFromFileSystem() {
		
		theFortunes = new ArrayList<String>();
		
		BufferedReader br = null;
		try {
			File theFile = new File(fileName);
			System.out.println("Reading fortunes from file: " + theFile);
			System.out.println("File exists: " + theFile.exists());
			br = new BufferedReader(new FileReader(theFile));
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
