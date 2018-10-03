package org.shivani.practice.RESTproject.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.shivani.practice.RESTproject.messenger.model.Messages;
import org.shivani.practice.RESTproject.messenger.services.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Messages> getMessages(){
		return messageService.getAllMessages();
	}
}
