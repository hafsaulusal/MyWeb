package org.hafsa.InstantMess.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hafsa.InstantMess.model.Mesaj;
import org.hafsa.InstantMess.service.MesajService;

@Path("/kullanici/mesaj")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MesajResource {

	MesajService mesajService=new MesajService();
	
	@GET
	@Path("/{k1}/{k2}")
	public List<Mesaj> getMesajlar(@PathParam ("k1") int k1,
			@PathParam ("k2") int k2)
	{
		return mesajService.getirMesaj(k1,k2);
	}
	
	@GET
	@Path("/arkadas/{k1}")
	public List<Mesaj> getKullaniciMesajlar(@PathParam ("k1") int k1)
	{
		return mesajService.kullaniciMesaj(k1);
	}
	
	@GET
	public List<Mesaj> getTumMesaj()
	{
		return mesajService.tumMesaj();
	}
	
	
	@POST
	public boolean addMesaj(Mesaj mesaj)
	{
		return mesajService.ekleMesaj(mesaj);
	}
	

			
	
}
