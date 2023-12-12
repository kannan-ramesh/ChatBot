package com.kannanrameshrk.chatbot.addchoice;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.kannanrameshrk.chatbot.repository.ChatBotRepository;

public class AddChoiceViewModel {
	private SelectChoice selectchoice;
	private ChatBotRepository dat;
	ArrayList<String> choiceList = new ArrayList<>();

	public AddChoiceViewModel(SelectChoice selectChoice) {
		this.selectchoice = selectChoice;
		getData();
	}

	JSONObject data;
	
	public  void getData(){
		dat = ChatBotRepository.getInstance();
		data = dat.jsonAction();
	}

	public void print(int step, int choice) {
		for (String choiceString : getChoices(step, choice)) {
			System.out.println(choiceString);
		}
	}

	public ArrayList<String> getChoices(int step, int choice) {
		System.out.println(step);
		if (data.containsKey(String.valueOf(step))) {
			JSONObject levelObject = (JSONObject) data.get(String.valueOf(step));

			if (levelObject.containsKey(String.valueOf(choice))) {
				Object optionsObject = levelObject.get(String.valueOf(choice));

				if (optionsObject instanceof JSONArray) {
					choiceList.addAll((JSONArray) optionsObject);
				} else if (optionsObject instanceof JSONObject) {
					choiceList.addAll(((JSONObject) optionsObject).values());
				}
			}
		}
		return choiceList;
	}

}
