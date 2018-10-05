package org.shivani.practice.RESTproject.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.shivani.practice.RESTproject.messenger.dataase.DatabaseClass;
import org.shivani.practice.RESTproject.messenger.model.Profile;

public class ProfileService {

	
	public ProfileService(){
		profiles.put("Shivani Panchal", new Profile(1, "Shivani Panchal", "Shivani", "Panchal"));
		profiles.put("Rahul Panchal", new Profile(2, "Rahul Panchal", "Rahul", "Panchal"));
		
	}

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public List<Profile> getAllProfile() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String pName){
		System.out.println("Entered getProfile Method ");
		return profiles.get(pName);
	}
	
	public  Map<String, Profile> addMessage(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profiles;
	}
	
	public Map<String, Profile> updateMessage(Profile profile){
		System.out.println("Entered updateProfile of ProfileService: " + profile.getProfileName());
		if(profile.getId()<=0){
			System.out.println("Profile Id is 0");
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		System.out.println(profiles);
		return profiles;
	}
	
	public Map<String, Profile> removeMessage(String pName){
		if(profiles.remove(pName) != null){
			System.out.println("Profile is removed successfully");
		}
		return profiles;
	}
}
