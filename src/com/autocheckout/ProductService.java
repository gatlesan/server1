package com.autocheckout;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.autocheckout.res.Product;  
   
@Path("/ProductService")  
public class ProductService {  
     @GET  
     @Path("/getPrice/{barcode}")  
     @Produces({"application/json"})  
      public Product getProduct(@PathParam("barcode") String code) {  
   
       Product p = new Product(code,"product1", 10.10d);
        
        return p;  
      }  
   
      @Path("/FeetToInch/{f}")  
      @GET  
      @Produces(MediaType.TEXT_XML)  
      public String convertFeetToInch(@PathParam("f") int f) {  
       int inch=0;  
          int feet = f;  
          inch = 12*feet;  
    
         return "<FeetToInchService>"  
         + "<Feet>" + feet + "</Feet>"  
            + "<Inch>" + inch + "</Inch>"  
            + "</FeetToInchService>";  
      }  
}  

