package org.hafsa.InstantMess.service;

import java.util.List;

import org.hafsa.InstantMess.dao.MesajDao;
import org.hafsa.InstantMess.model.Mesaj;

public class MesajService {
	
	public List<Mesaj> getirMesaj(int k1,int k2)
	{
		return MesajDao.mesajGetir(k1,k2);
	}
	
	public List<Mesaj> kullaniciMesaj(int k1)
	{
		return MesajDao.kullaniciMesaj(k1);
	}

	public boolean ekleMesaj(Mesaj mesaj)
	{
		return MesajDao.mesajEkle(mesaj);
	}
	
	public List<Mesaj> tumMesaj()
	{
		return MesajDao.tumKullaniciMesaj();
	}
	
	public boolean ekleResim(Mesaj mesaj)
	{
		return MesajDao.ResimEkle(mesaj);
	}
	
	
	
}
