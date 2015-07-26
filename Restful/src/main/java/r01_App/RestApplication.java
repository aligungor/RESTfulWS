package r01_App;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import r02_Hello.HelloWorld;
import r03_Json.JsonRest;
import r04_Xml.XmlRest;
import r05_FileDownload.FileDownloaderRest;
import r06_FileUpload.FileUploaderRest;
import r07_JDBC.PlayerRest;

@ApplicationPath("restws")
public class RestApplication extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rootResources = new HashSet<Class<?>>();
		rootResources.add(HelloWorld.class);
		rootResources.add(JsonRest.class);
		rootResources.add(XmlRest.class);
		rootResources.add(FileDownloaderRest.class);
		rootResources.add(FileUploaderRest.class);
		rootResources.add(MultiPartFeature.class);
		rootResources.add(PlayerRest.class);
		return rootResources;
	}
	
}
