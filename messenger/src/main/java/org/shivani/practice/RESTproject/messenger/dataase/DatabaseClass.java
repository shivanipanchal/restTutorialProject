package org.shivani.practice.RESTproject.messenger.dataase;

import java.util.HashMap;
import java.util.Map;

import org.shivani.practice.RESTproject.messenger.model.Messages;
import org.shivani.practice.RESTproject.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Messages> messages = new HashMap<Long, Messages>();
	private static Map<Long, Profile> profiles = new HashMap<Long, Profile>();
	
	public static Map<Long, Messages> getMessages(){
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles(){
		return profiles;
	}
}
