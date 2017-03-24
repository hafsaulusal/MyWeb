package org.hafsa.InstantMess.resource;

import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hafsa.InstantMess.Security.IPasswords;
import org.hafsa.InstantMess.Security.Keccak;
import org.hafsa.InstantMess.Security.Passwords;
import org.hafsa.InstantMess.model.Kullanici;
import org.hafsa.InstantMess.service.KullaniciService;

@Path("/kullanici")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KullaniciResource {
	

	KullaniciService kullaniciservice=new KullaniciService();
	
	@GET
	public List<Kullanici> getAllKullanicis()
	{
		return kullaniciservice.getAllKullanici();
	}
	
	@GET
	@Path("/{kullaniciAd}")
	public List<Kullanici> getKullanicis(@PathParam("kullaniciAd") String kullaniciAd)
	{
		return kullaniciservice.getKullaniciAd(kullaniciAd);
	}

	@POST
	public boolean addKullanicis(Kullanici kullanicis) 
	{
		return kullaniciservice.addKullanici(kullanicis);
	}
	
	@GET
	@Path("/login")
	public Kullanici controlKullanicis(@QueryParam("kullaniciTel") String kullaniciTel,
			@QueryParam("parola")String parola)
	{
		IPasswords passwords = new Passwords();
		String tuz=kullaniciservice.controlTel(kullaniciTel).getTuz();
		String tuzparola=Keccak.hashToString(passwords.hash(parola,tuz));

		if (kullaniciTel!=null && parola!=null)
		{	
			return kullaniciservice.controlKullanicis(kullaniciTel,tuzparola);	
		}
		return null;
	}
	
	
	/*
	@GET
	@Path("/login")
	public Response controlKullanicis(@QueryParam("kullaniciTel") String kullaniciTel,
			@QueryParam("parola")String parola)
	{
		IPasswords passwords = new Passwords();
		String tuz=kullaniciservice.controlTel(kullaniciTel).getTuz();
		String tuzparola=Keccak.hashToString(passwords.hash(parola,tuz));
		

		if (kullaniciTel!=null && parola!=null)
		{
			int id=kullaniciservice.controlKullanicis(kullaniciTel,tuzparola).getKullaniciId();
			 try {
				 java.net.URI location = new java.net.URI("http://localhost:9090/InstantMess/webapi/kullanici/arkadas/"+id);
				   return Response.temporaryRedirect(location).build();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	*/
	
	/*@GET
	@Path("/arkadas/{kullaniciId}")
	public Kullanici yonlendir(@PathParam("kullaniciId") int kullaniciId)
	{
		return kullaniciservice.yonlendirTel(kullaniciId);
	}
	*/	
}
