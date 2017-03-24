package org.hafsa.InstantMess.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hafsa.InstantMess.model.Mesaj;
import org.hafsa.InstantMess.service.MesajService;


@Path("/kullanici/resim")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResimResource {

	MesajService mesajService=new MesajService();
	
	@POST
	public boolean addResim(Mesaj mesaj)
	{
		return mesajService.ekleResim(mesaj);
	}
	
}
