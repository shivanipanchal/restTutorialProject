package org.shivani.practice.RESTproject.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.shivani.practice.RESTproject.messenger.dataase.DatabaseClass;
import org.shivani.practice.RESTproject.messenger.model.Messages;

public class MessageService {
	
	public MessageService(){
		messages.put(1L, new Messages(1, "Hello World", "Shivani"));
		messages.put(2L, new Messages(2, "Hello Jersey!!!", "Shivani"));
		
	}

	private Map<Long, Messages> messages = DatabaseClass.getMessages();

	public List<Messages> getAllMessages() {
		return new ArrayList<Messages>(messages.values());
	}
	
	public Messages getMessage(long id){
		System.out.println("Entered getMessage Method ");
		return messages.get(id);
	}
	
	public  Map<Long, Messages> addMessage(Messages message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return messages;
	}
	
	public Map<Long, Messages> updateMessage(Messages message){
		System.out.println("Entered updateMessage of MessageService: " + message.getMessage());
		if(message.getId()<=0){
			System.out.println("Message Id is 0");
			return null;
		}
		messages.put(message.getId(), message);
		System.out.println(messages);
		return messages;
	}
	
	public Map<Long, Messages> removeMessage(long id){
		if(messages.remove(id) != null){
			System.out.println("Message is removed successfully");
		}
		return messages;
	}
}
