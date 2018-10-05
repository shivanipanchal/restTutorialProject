package org.shivani.practice.RESTproject.messenger.resource;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	@POST
	@Path("/addMessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<Long, Messages> addMessage(Messages msg){
		return messageService.addMessage(msg);
	}
	
	@PUT
	@Path("/updateMsg/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<Long, Messages> updateMessage(@PathParam("messageId") long id, Messages msg){
		System.out.println("Entered updateMessage in MessageResource");
		msg.setId(4);
		return messageService.updateMessage(msg);
	}
	
	@DELETE
	@Path("/deleteMessage/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<Long, Messages> deleteMessage(@PathParam("messageId") long id){
		System.out.println("Message Id :" + id);
		return messageService.removeMessage(id);
	}
}
