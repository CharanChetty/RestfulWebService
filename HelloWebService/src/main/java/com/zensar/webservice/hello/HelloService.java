package com.zensar.webservice.hello;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/hello")
public class HelloService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainHello()
	{
		return "welcome to Zensar Hello Service!!!..";
	}
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello()
	{
		return "<html><body bgclor='pink'><h1>welcome to Zensar</h1><p>Dear Welcome</p></body></html>";
				
	}
	@GET
	@Path("/xml")
	@Produces(MediaType.TEXT_XML)	
	public String xmlHello()
	{
		return "<?xml version='1.0'?><hello>Welcome to zensar</hello>";
	}
	@GET
	@Path("/{nm}")
	@Produces("text/plain")
	public String sayHelloUser(@PathParam("nm") String name)
	{
		return "Dear"+" "+name+" "+"Welcome to Zensar hello Service";
		
	}
	@GET
	@Path("res/{nm}")
	@Produces("text/plain")
	public Response sayHelloUserResponse(@PathParam("nm") String name)
	{
		Response res=Response.status(200).entity("Dear"+" "+name+" "+"Welcome to Zensar hello Service").build();
		return res;
		
	}
	
	@GET
	@Path("res/{nm}/{dd}/{mm}/{yy}")
	@Produces("text/plain")
	public Response sayHappyBirthday(@PathParam("nm") String name, @PathParam("dd") int day,@PathParam("mm") int month,@PathParam("yy") int year)
	{
		LocalDate bd=LocalDate.of(year, month, day);
		Response res=Response.status(200).entity("Dear"+" "+name+" "+"Happy birthday to you! on"+" "+bd).build();
		return res;
		
	}
}
