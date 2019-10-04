package com.zensar.webservice.download;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
@Path("/download")
public class FileDownloadService {
	private static final String textFile="D:\\WhyReact.txt";
	@GET
	@Path("/text")
	@Produces("text/plain")
	public Response getTextfile()
	{
		File file= new File(textFile);
		ResponseBuilder builder=Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename=charan.txt");
		return builder.build();
	}
	

	private static final String imageFile="D:\\homescreen.png";
	@GET
	@Path("/image")
	@Produces("image/png")
	public Response getImagefile()
	{
		File file= new File(imageFile);
		ResponseBuilder builder=Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename=image.png");
		return builder.build();
	}

	private static final String pdfFile="D:\\pay.pdf";
	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPdffile()
	{
		File file= new File(pdfFile);
		ResponseBuilder builder=Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename=pay1.png");
		return builder.build();
	}
}
