package com.kannanrameshrk.chatbot;

import org.json.simple.parser.ParseException;

import com.kannanrameshrk.chatbot.addchoice.SelectChoice;

public class Restaurant {

	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant();
		restaurant.start();
	}

	private void start() {
	        System.out.println("*+---Tamil Mersal Restaurant-----+*");
	        SelectChoice sc = null;
			try {
				sc = new SelectChoice();
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        sc.addChoice();  
	}
}