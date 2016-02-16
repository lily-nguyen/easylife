package product.manager.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/saveProducts")
public class SavingProducts {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlSavingProducts () {
	    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	        + "<body><h1>" + "Hello Jersey1111" + "</body></h1>" + "</html> ";
	} 
	
}
