package com.snapsense.ws.ws;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.snapsense.ws.bl.SearchManager;
import com.snapsense.ws.util.AppConstants;

@Path("/ProcessCustomerFeedback")
public class ProcessCustomerFeedbackService implements AppConstants{
	
	@GET
	@Produces("text/plain")
	public Response helloWorld()
	{
		String output = "GET METHOD IS WORKING";
		System.out.println(output);
		
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public Response processCustomerFeedback(String json)
	{
		System.out.println("Received JSON: ");
		System.out.println(json);
		
		ArrayList<String> keyWords = new ArrayList<String>() {{
            add("doesn't");
            add("work");
            add("hate");
            add("bad");
            add("good");
            add("not");
            add("jacket");
            add("rip");
            add("size");
            add("zipper");
            add("return");
            add("sick");
            add("worst");
            add("Customer");
            add("service");
            add("elsewhere");
        }};
		
		SearchManager.findKeyWords(json, keyWords);
		
		return Response.status(200).entity("Response JSON").build();
	}
	
}
