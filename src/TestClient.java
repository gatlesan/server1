

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.sun.jersey.api.client.Client; 
import com.sun.jersey.api.client.WebResource;  
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig; 

public class TestClient {
public static String shopURL = 
"http://www.searchupc.com/handlers/upcsearch.ashx?request_type=3&access_token=1016AD43-9D38-4078-A9BF-086E6B7973F3&upc=0024100440689";
public static void main(String[] args) throws ClientProtocolException, IOException { 

 // ClientConfig config = new DefaultClientConfig();  
 // Client client = Client.create(config); 
 // WebResource service = client.resource(UriBuilder.fromUri(shopURL).build()); 

  // getting XML data 
  //System.out.println(service. path("restPath").path("resourcePath").accept(MediaType.APPLICATION_JSON).get(String.class)); 

  // getting JSON data 
  //System.out.println(service.accept(MediaType.APPLICATION_XML).get(String.class));

	 HttpClient client = new DefaultHttpClient(); 
	 
	  HttpGet request = new HttpGet(shopURL); 	 
	  HttpResponse response = client.execute(request); 	
	  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent())); 	
	  String line = ""; 	
	  while ((line = rd.readLine()) != null) {  
	    System.out.println(line); 	
	  } 
 } 
}
