package product.manager.services;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import product.manager.core.ProcessStatus;
import product.manager.core.ProductSaverImpl;
import product.manager.core.ProductSaverInf;

@Path("/saveProducts")
public class SavingProducts {

	@GET
	@Produces(MediaType.TEXT_HTML) 
	public String sayHtmlSavingProducts () {
	    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	        + "<body><h1>" + "Hello Jersey1111" + "</body></h1>" + "</html> ";
	} 
	
	
	@POST
	@Consumes({MediaType.TEXT_PLAIN})
	public Response saveProduct (String data) {
		ProductSaverInf productSaver = new ProductSaverImpl();
		productSaver.saveProductList(data, true);
		JsonObject jO = ProcessStatus.getSuccess();
		return Response.status(201).entity(jO.toString()).build();
	}
	
}
