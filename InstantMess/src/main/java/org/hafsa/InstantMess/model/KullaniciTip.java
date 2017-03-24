package org.hafsa.InstantMess.model;

public class KullaniciTip {

	private int tipId;
	private String tip;
	
	public KullaniciTip(){
		super();
	}
	
	public KullaniciTip(String tip) {
		super();
		this.tip = tip;
	}
	
	
	public KullaniciTip(int tipId) {
		super();
		this.tipId = tipId;
	}


	public KullaniciTip(int tipId, String tip) {
		super();
		this.tipId = tipId;
		this.tip = tip;
	}

	public int getTipId() {
		return tipId;
	}

	public void setTipId(int tipId) {
		this.tipId = tipId;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
		
}
