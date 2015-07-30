package com.autocheckout.client;

import javax.ws.rs.core.MediaType;

import com.autocheckout.res.Product;
import com.sun.jersey.api.client.Client;  
import com.sun.jersey.api.client.ClientResponse;  
import com.sun.jersey.api.client.WebResource;  
import com.sun.jersey.api.client.config.ClientConfig;  
import com.sun.jersey.api.client.config.DefaultClientConfig;  
  
public class ProductClient {  
    static final String REST_URI = "http://localhost:8080/NewProj1";  
    static final String INCH_TO_FEET = "/ProductService/getPrice/";  
   // static final String FEET_TO_INCH = "/ConversionService/FeetToInch/";  
  
    public static void main(String[] args) {  
  
       String barcode="111";  
       int feet=2;  
  
        ClientConfig config = new DefaultClientConfig();  
        Client client = Client.create(config);  
        WebResource service = client.resource(REST_URI);  
  
        WebResource addService = service.path("rest").path(INCH_TO_FEET+barcode);  
        System.out.println("Product Response: " + getResponse(addService));  
      //  System.out.println("INCH_TO_FEET Output as XML: " + getOutputAsXML(addService));  
        System.out.println("---------------------------------------------------");  
  
      //  WebResource subService = service.path("rest").path(FEET_TO_INCH+feet);  
      //  System.out.println("FEET_TO_INCH Response: " + getResponse(subService));  
     //   System.out.println("FEET_TO_INCH Output as XML: " + getOutputAsXML(subService));  
        System.out.println("---------------------------------------------------");  
  
    }  
  
    private static String getResponse(WebResource service) {  
        return service.accept(MediaType.APPLICATION_JSON).type("application/json").get(String.class ); 


    }  
  
    private static String getOutputAsXML(WebResource service) {  
        return service.accept(MediaType.APPLICATION_JSON).get(String.class);  
    }  
}  


