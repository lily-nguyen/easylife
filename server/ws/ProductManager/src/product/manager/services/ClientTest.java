package product.manager.services;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import product.manager.core.ProductSaverImpl;

public class ClientTest {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient(new ClientConfig());
		WebTarget webTarget = client.target("http://localhost:8080/ProductManager/saveProducts");
		Response response = webTarget.request().post(Entity.entity(ProductSaverImpl.getData().toString(), MediaType.TEXT_PLAIN), Response.class);
		System.out.println(response.readEntity(String.class));
	}

}
