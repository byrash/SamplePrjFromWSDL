package com.shivaji;

import javax.xml.ws.BindingProvider;
import com.thomas_bayer.blz.BLZService;
import com.thomas_bayer.blz.BLZServicePortType;
import com.thomas_bayer.blz.DetailsType;

/**
 * Sample project to generate stubs from WSDL File and trigger a service
 * 
 * @author Shivaji
 *
 */
public class Main {

  public static void main(String[] args) {
    // If you want to parse existings ample request
    // JAXBContext jaxbContext = JAXBContext.newInstance(JAXBGeneratedClassName.class);
    // Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    // Random random = new Random();

    // To dump soap messages to console
    System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
    System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump",
        "true");
    System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
    System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

    // Get Service and get port form service.
    // Port is your trigger point to web service operations
    BLZService blzService = new BLZService();
    BLZServicePortType blzServiceHttpport = blzService.getBLZServiceHttpport();

    // If you want to customize an default generated behaviors or add authentication values or so
    BindingProvider bindingsProvider = (BindingProvider) blzServiceHttpport;
    // If your web service wants to authenticate
    // bindingsProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "auth_username");
    // bindingsProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "auth_password");
    // Change the end point service URL
    bindingsProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
        "http://www.thomas-bayer.com/axis2/services/BLZService");

    DetailsType bank = blzServiceHttpport.getBank("DUMMY");
    System.out.println(bank);

  }

}
