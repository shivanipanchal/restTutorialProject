package org.shivani.practice.RESTproject.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.shivani.practice.RESTproject.messenger.model.Messages;
import org.shivani.practice.RESTproject.messenger.services.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messages> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Messages getMessage(@PathParam("messageId")long messageId){
		System.out.println("Provided Message ID :" + messageId);
		return messageService.getMessage(messageId);
	}
}
