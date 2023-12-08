package com.kannanrameshrk.chatbot.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//model
public class ChatBotRepository {
	private static ChatBotRepository repository;

	private ChatBotRepository() {

	}

	public static ChatBotRepository getInstance() {
		if (repository == null) {
			repository = new ChatBotRepository();
		}
		return repository;
	}

	public JSONObject jsonAction() {
		JSONParser jsonParser = new JSONParser();
		File file = new File(
				"C:\\Users\\kanna\\eclipse-workspace\\webapp\\ChatBot\\src\\com\\kannanrameshrk\\chatbot\\repository\\item.json");
		Object object = null;
		try {
			object = jsonParser.parse(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject choicesObject = (JSONObject) object;

		return choicesObject;
	}
}
