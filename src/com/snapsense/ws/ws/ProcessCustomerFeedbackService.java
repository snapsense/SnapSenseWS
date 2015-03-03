package com.snapsense.ws.ws;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.snapsense.ws.bl.SearchManager;
import com.snapsense.ws.util.AppConstants;

@Path("/processfeedback")
public class ProcessCustomerFeedbackService implements AppConstants{
	
	@GET
	@Path("getspeech")
	@Produces("application/json")
	public Response helloWorld()
	{
		String output = "GET METHOD IS WORKING";
		System.out.println(output);
		
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Path("savespeech")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String processCustomerFeedback(String json)
	{
		List<String> keyWords = Arrays.asList(json.split(" "));
		
		SearchManager.findKeyWords(json, keyWords);
		
		return "{ \"response\" : \"Successfully saved the following text : " +json + "\" }";
	}
	
}
