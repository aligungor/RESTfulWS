package r06_FileUpload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("uploadFile")
public class FileUploaderRest {

	private static final String BASE_PATH = "/Users/AliGungorGYT/Desktop/";
	 
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN) 
	public String test() {
		return "uploadFile test method works";
	}
	
	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadFile(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDisposition)
			throws FileNotFoundException, IOException {
		String fileName = fileDisposition.getFileName();
		String filePath = BASE_PATH + fileName;
		saveFile(fileInputStream, filePath);
		return Response.status(Status.OK).entity("Successful").build();
	}
	
	private void saveFile(InputStream is, String fileLocation) throws IOException {
    	OutputStream os = new FileOutputStream(new File(fileLocation));
		byte[] buffer = new byte[256];
	    int bytes = 0;
	    while ((bytes = is.read(buffer)) != -1) {
	        os.write(buffer, 0, bytes);
	    }
	    os.close();
	}
}
