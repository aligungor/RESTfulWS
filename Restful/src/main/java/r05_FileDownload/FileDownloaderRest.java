package r05_FileDownload;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
//http://examples.javacodegeeks.com/enterprise-java/rest/jax-rs-download-file/
//http://howtodoinjava.com/2013/05/10/resteasy-file-download-example/
//http://stackoverflow.com/questions/23057566/download-a-zip-file-using-restful-services
@Path("fileDownload")
public class FileDownloaderRest {
	
	private static final String CONTENT_DISP = "Content-Disposition";
	private static final String HEADER_FORMAT = "attachment; filename=\"%s\"";
	
	private static final String PATH_TXT = "/Users/shared/sampleTextFile.txt";
	private static final String PATH_IMG = "/Users/shared/sampleImageFile.png";
	private static final String PATH_ZIP = "/Users/shared/sampleZipFile.zip";

	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN) 
	public String test() {
		return "fileDownload test method works";
	}
	
	@GET
	@Path("getTextFile")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTextFile() {
		File fileToServe = new File(PATH_TXT);
		ResponseBuilder responseBuilder = Response.ok((Object) fileToServe);
		responseBuilder.header(CONTENT_DISP, String.format(HEADER_FORMAT, fileToServe.getName()));
		return responseBuilder.build();
	}
	
	@GET
	@Path("getImageFile")
	@Produces("image/png")
	public Response getImageFile() {
		File fileToServe = new File(PATH_IMG);
		ResponseBuilder responseBuilder = Response.ok((Object) fileToServe);
		responseBuilder.header(CONTENT_DISP, String.format(HEADER_FORMAT, fileToServe.getName()));
		return responseBuilder.build();
	}
	
	@GET
	@Path("getZipFile")
	@Produces("application/zip")
	public Response getZipFile() {
		File fileToServe = new File(PATH_ZIP);
		ResponseBuilder responseBuilder = Response.ok((Object) fileToServe);
		responseBuilder.header(CONTENT_DISP, String.format(HEADER_FORMAT, fileToServe.getName()));
		return responseBuilder.build();
	}
	
}
