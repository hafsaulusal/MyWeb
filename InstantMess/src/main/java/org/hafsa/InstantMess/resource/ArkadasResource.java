package org.hafsa.InstantMess.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hafsa.InstantMess.model.Arkadas;
import org.hafsa.InstantMess.model.Kullanici;
import org.hafsa.InstantMess.service.ArkadasService;
import org.hafsa.InstantMess.service.KullaniciService;

@Path("/kullanici/arkadas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArkadasResource {
	
	ArkadasService arkadasService=new ArkadasService();
	KullaniciService kullaniciService=new KullaniciService();
	
	@GET
	@Path("/{kullanici1}")
	public List<Arkadas> Getir(@PathParam("kullanici1") int kullanici1)
	{
		return arkadasService.arkadasGetir(kullanici1);
	}
	
	@POST
	public boolean arkadasEkle(Arkadas arkadas)
	{
		return arkadasService.addArkadas(arkadas);
	}
		
	
	
	
	
	
	
	
	
	
	
	

}
