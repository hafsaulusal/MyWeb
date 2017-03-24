package org.hafsa.InstantMess.model;

public class Anahtar {
	private int anahtarId;
	private String anahtar;
	private Kullanici kullanici;
	
	public Anahtar()
	{
		
	}

	public Kullanici getKullanici() {
		return kullanici;
	}


	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public int getAnahtarId() {
		return anahtarId;
	}

	public void setAnahtarId(int anahtarId) {
		this.anahtarId = anahtarId;
	}

	public String getAnahtar() {
		return anahtar;
	}

	public void setAnahtar(String anahtar) {
		this.anahtar = anahtar;
	}
	
}
