package org.hafsa.InstantMess.model;

import java.sql.Timestamp;

import com.mysql.jdbc.Blob;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class Kullanici {
	
	
	private int kullaniciId;
	private String kullaniciAd;
	private String kullaniciTel;
	private String parola;
	private String parolaTekrar;
	private String tuz;
	private String aktif;
	private Timestamp aktifSaat;
	private KullaniciTip kullaniciTip;
	private Boolean durum;
	
	

	public Kullanici(int kullaniciId, String kullaniciAd) {
		super();
		this.kullaniciId = kullaniciId;
		this.kullaniciAd = kullaniciAd;
	}

	public Kullanici(String kullaniciAd) {
		super();
		this.kullaniciAd = kullaniciAd;
	}

	public Kullanici()
	{
		
	}

	public Kullanici(int kullaniciId) {
		super();
		this.kullaniciId = kullaniciId;
	}


	public Kullanici(String kullaniciAd,String kullaniciTel)
	{
		super();
		this.kullaniciAd=kullaniciAd;
		this.kullaniciTel=kullaniciTel;
	}
	
	
	
	public Kullanici(int kullaniciId, String kullaniciAd, String kullaniciTel) {
		super();
		this.kullaniciId = kullaniciId;
		this.kullaniciAd = kullaniciAd;
		this.kullaniciTel = kullaniciTel;
	}

	public Boolean getDurum() {
		return durum;
	}


	public void setDurum(Boolean durum) {
		this.durum = durum;
	}




	public int getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	public String getKullaniciAd() {
		return kullaniciAd;
	}

	public void setKullaniciAd(String kullaniciAd) {
		this.kullaniciAd = kullaniciAd;
	}

	public String getKullaniciTel() {
		return kullaniciTel;
	}

	public void setKullaniciTel(String kullaniciTel) {
		this.kullaniciTel = kullaniciTel;
	}



	public String getParola() {
		return parola;
	}


	public void setParola(String parola) {
		this.parola = parola;
	}


	public String getParolaTekrar() {
		return parolaTekrar;
	}


	public void setParolaTekrar(String parolaTekrar) {
		this.parolaTekrar = parolaTekrar;
	}


	public String getTuz() {
		return tuz;
	}

	public void setTuz(String tuz) {
		this.tuz = tuz;
	}

	public String getAktif() {
		return aktif;
	}

	public void setAktif(String aktif) {
		this.aktif = aktif;
	}

	public Timestamp getAktifSaat() {
		return aktifSaat;
	}

	public void setAktifSaat(Timestamp aktifSaat) {
		this.aktifSaat = aktifSaat;
	}

	public KullaniciTip getKullaniciTip() {
		return kullaniciTip;
	}

	public void setKullaniciTip(KullaniciTip kullaniciTip) {
		this.kullaniciTip = kullaniciTip;
	}
}
