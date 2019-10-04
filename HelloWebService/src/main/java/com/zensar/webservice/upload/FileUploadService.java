package com.zensar.webservice.upload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class FileUploadService {
	@POST
	@Produces("text/html")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
 public Response uploadFile(@FormDataParam("myFile") InputStream in, @FormDataParam("myFile") FormDataContentDisposition fileDetails)
 {
	 String fileloc="D:/uploads/"+fileDetails.getFileName();
	 try
	 {
	 FileOutputStream fos=new FileOutputStream(fileloc);
	 byte b[]=new byte[1024];
	 int data=0;
	 while((data=in.read(b))!=-1)
	 {
		 fos.write(b, 0, data);
	 }
	 fos.flush();
	 fos.close();
	 in.close();
 }catch(Exception e) {
	 e.printStackTrace();
 }
return Response.status(200).entity("file uploaded to location"+fileloc).build();
}
}

