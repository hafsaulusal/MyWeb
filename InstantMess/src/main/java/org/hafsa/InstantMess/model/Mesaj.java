package org.hafsa.InstantMess.model;

import java.io.InputStream;
import java.sql.Timestamp;

import com.mysql.jdbc.Blob;

public class Mesaj {
	private int mesajId;
	private String mesaj;
	private String mesajOzeti;
	private String resim;
	private String dosya;
	private Timestamp gonderimSaat;
	private Timestamp okumaSaat;
	private Arkadas arkadasId;
	private Kullanici kullaniciId;


	public Arkadas getArkadasId() {
		return arkadasId;
	}
	public void setArkadasId(Arkadas arkadasId) {
		this.arkadasId = arkadasId;
	}
	public Kullanici getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(Kullanici kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public String getMesajOzeti() {
		return mesajOzeti;
	}
	public void setMesajOzeti(String mesajOzeti) {
		this.mesajOzeti = mesajOzeti;
	}
	public int getMesajId() {
		return mesajId;
	}
	public void setMesajId(int mesajId) {
		this.mesajId = mesajId;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

	public String getResim() {
		return resim;
	}
	public void setResim(String resim) {
		this.resim = resim;
	}
	public String getDosya() {
		return dosya;
	}
	public void setDosya(String dosya) {
		this.dosya = dosya;
	}
	public Timestamp getGonderimSaat() {
		return gonderimSaat;
	}
	public void setGonderimSaat(Timestamp gonderimSaat) {
		this.gonderimSaat = gonderimSaat;
	}
	public Timestamp getOkumaSaat() {
		return okumaSaat;
	}
	public void setOkumaSaat(Timestamp okumaSaat) {
		this.okumaSaat = okumaSaat;
	}

}
