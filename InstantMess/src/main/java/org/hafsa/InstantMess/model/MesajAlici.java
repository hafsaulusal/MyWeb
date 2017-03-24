package org.hafsa.InstantMess.model;

public class MesajAlici {

	private int mesajAliciId;
	private String durum;
	private String silinmeDurum;
	private Anahtar anahtar;
	private Mesaj mesaj;
	public int getMesajAliciId() {
		return mesajAliciId;
	}
	public void setMesajAliciId(int mesajAliciId) {
		this.mesajAliciId = mesajAliciId;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public String getSilinmeDurum() {
		return silinmeDurum;
	}
	public void setSilinmeDurum(String silinmeDurum) {
		this.silinmeDurum = silinmeDurum;
	}
	
	public Anahtar getAnahtar() {
		return anahtar;
	}
	public void setAnahtar(Anahtar anahtar) {
		this.anahtar = anahtar;
	}
	public Mesaj getMesaj() {
		return mesaj;
	}
	public void setMesaj(Mesaj mesaj) {
		this.mesaj = mesaj;
	}
	
	
	
}
