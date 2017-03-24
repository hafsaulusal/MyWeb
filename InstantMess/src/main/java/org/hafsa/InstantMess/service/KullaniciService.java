package org.hafsa.InstantMess.service;


import java.util.List;
import org.hafsa.InstantMess.dao.KullaniciDao;
import org.hafsa.InstantMess.model.Kullanici;


public class KullaniciService {
	
	//Kullanici kullanicis=new Kullanici();	
	public List<Kullanici> getAllKullanici()
	{
		 return  KullaniciDao.tumKullanicilar();	 
	}
	
	public List<Kullanici> getKullaniciAd(String kullaniciAd) {
		return KullaniciDao.kullaniciBul(kullaniciAd);
	}
	
	 public Kullanici getKullaniciId(int id){
	 
		return KullaniciDao.kullaniciGetir(id);	
	}	
	
	public boolean addKullanici(Kullanici kullanicis)
	{
			return KullaniciDao.kullaniciEkle(kullanicis);
	}
	
	public Kullanici controlKullanicis(String kullaniciTel,String parola)
	{
			return	KullaniciDao.login(kullaniciTel,parola);
	}

	public Kullanici controlTel(String kullaniciTel) {
		return KullaniciDao.controlTelefon(kullaniciTel);
	}
	
	public List<Kullanici> yonlendirTel(int kullaniciId) {
		return KullaniciDao.yonlendir(kullaniciId);	
	}

	
	
//	public Kullanici updateKullanici(Kullanici kullanicis)
//	{
//		if(kullanicis.getKullaniciid()<=0)
//		{
//			return null;
//		}
//		tumKullanicilar.put(kullanicis.getKullaniciid(),kullanicis);
//		return kullanicis;
//	}

//	public Kullanici removeKullanici(int id)
//	{
//		return tumKullanicilar.remove(id);
//	}
	

}
