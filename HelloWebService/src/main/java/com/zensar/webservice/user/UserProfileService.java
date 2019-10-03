package com.zensar.webservice.user;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserProfileService {
	@POST
	@Path("/add")
	@Produces("text/html")
	public Response addUser(@FormParam("clientName") String name, @FormParam("gender")String Gen,@FormParam("age")int age)
{
	
      return Response.status(200).entity("<p>new user record is added <br>Name:"+name+"Gender:"+Gen+"age:"+age+"</p>").build();
}
}