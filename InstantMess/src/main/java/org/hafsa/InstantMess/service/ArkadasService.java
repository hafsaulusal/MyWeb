package org.hafsa.InstantMess.service;

import java.util.List;

import org.hafsa.InstantMess.dao.ArkadasDao;
import org.hafsa.InstantMess.model.Arkadas;

public class ArkadasService {

	public boolean addArkadas(Arkadas arkadas)
	{
		return ArkadasDao.arkadasEkle(arkadas);
	}
	
	public List<Arkadas> arkadasGetir(int kullanici1)
	{
		return ArkadasDao.arkadasGetir(kullanici1);
	}
	
}
