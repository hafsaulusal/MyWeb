package org.hafsa.InstantMess.model;

public class Arkadas {
	
	
	private int arkadasId;
	private Kullanici kullanici1;
	private Kullanici kullanici2;

	

	public Arkadas(int arkadasId, Kullanici kullanici2) {
		super();
		this.arkadasId = arkadasId;
		this.kullanici2 = kullanici2;
	}

	public Arkadas(Kullanici kullanici2) {
		super();
		this.kullanici2 = kullanici2;
	}

	public Arkadas() {
		super();
	}

	public Arkadas(int arkadasId) {
		super();
		this.arkadasId = arkadasId;
	}

	public int getArkadasId() {
	return arkadasId;
	}
	public void setArkadasId(int arkadasId) {
	this.arkadasId = arkadasId;
	}
	public Kullanici getKullanici1() {
	return kullanici1;
	}
	public void setKullanici1(Kullanici kullanici1) {
	this.kullanici1 = kullanici1;
	}
	public Kullanici getKullanici2() {
	return kullanici2;
	}
	public void setKullanici2(Kullanici kullanici2) {
	this.kullanici2 = kullanici2;
	}



	
}
