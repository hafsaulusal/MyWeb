package org.hafsa.InstantMess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hafsa.InstantMess.Security.IPasswords;
import org.hafsa.InstantMess.Security.Keccak;
import org.hafsa.InstantMess.Security.Passwords;
import org.hafsa.InstantMess.model.Kullanici;
import org.hafsa.InstantMess.model.KullaniciTip;

public class KullaniciDao {
	
	private static Connection con=null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	public static List<Kullanici> tumKullanicilar() {
		 List<Kullanici> kullanicilar=new ArrayList<>(); 
		String sql="select k.kullaniciId ,k.kullaniciAd,k.kullaniciTel,k.parola,k.tuz,k.durum,k.aktif ,k.aktifSaat,kt.tip "
				+ "from tbl_kullanici as k "
				+ "inner join  "
				+ "tbl_kullanicitip as kt  "
				+ "on (k.kullaniciTipId=kt.tipId)";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while(rs.next())
			{
				Kullanici kullanici=new Kullanici();
				kullanici.setKullaniciId(rs.getInt(1));
				kullanici.setKullaniciAd(rs.getString(2));
				kullanici.setKullaniciTel(rs.getString(3));
				kullanici.setParola(rs.getString(4));
				kullanici.setTuz(rs.getString(5));
				kullanici.setDurum(rs.getBoolean(6));
				kullanici.setAktif(rs.getString(7));
				kullanici.setAktifSaat(rs.getTimestamp(8));
				kullanici.setKullaniciTip(new KullaniciTip(rs.getString(9)));
				kullanicilar.add(kullanici);	
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConDao.kapat(con, psmt);
		}
		return kullanicilar;
	}
	
	public static Kullanici kullaniciGetir(int kullaniciId) {
		// List<Kullanici> kullanicilar=new ArrayList<>(); 
		Kullanici kullanici=null;
		 String sql="select k.kullaniciId ,k.kullaniciAd,k.kullaniciTel,k.parola,k.tuz,k.durum,k.aktif ,k.aktifSaat,kt.tip "
					+ "from tbl_kullanici as k "
					+ "inner join  "
					+ "tbl_kullanicitip as kt  "
					+ "on (k.kullaniciTipId=kt.tipId) where kullaniciId = ?";
			try {
				con=ConDao.getConnection();
				psmt=con.prepareStatement(sql);
				kullanici=new Kullanici();
				psmt.setInt(1,kullaniciId);
				rs=psmt.executeQuery();
				
				if(rs.next()){
					kullanici.setKullaniciId(rs.getInt(1));
					kullanici.setKullaniciAd(rs.getString(2));
					kullanici.setKullaniciTel(rs.getString(3));
					kullanici.setParola(rs.getString(4));
					kullanici.setTuz(rs.getString(5));
					kullanici.setDurum(rs.getBoolean(6));
					kullanici.setAktif(rs.getString(7));
					kullanici.setAktifSaat(rs.getTimestamp(8));
					kullanici.setKullaniciTip(new KullaniciTip(rs.getString(9)));
				}
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				ConDao.kapat(con, psmt, rs);
			}
			return kullanici;
	}
	
	public static boolean kullaniciEkle(Kullanici kullanici)
	{
		IPasswords passwords = new Passwords();
		Keccak keccak=new Keccak();
		final String salt=passwords.getSalt32();
	
		boolean state=false;
		String sql="insert into tbl_kullanici(kullaniciAd,kullaniciTel,"
				+ "parola,parolaTekrar,durum,tuz,aktif,aktifSaat,kullaniciTipId) values (?,?,?,?,?,?,1,Now(),3)";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,kullanici.getKullaniciAd());
			psmt.setString(2, kullanici.getKullaniciTel());
			try {
				psmt.setString(3,Keccak.hashToString(passwords.hash(kullanici.getParola(), salt)));
			} catch (Exception e) {
				System.out.println(e);
			}
			psmt.setString(4,Keccak.hashToString(passwords.hash(kullanici.getParolaTekrar(), salt)));
			
			//parola kontrol ediliyor
			psmt.setBoolean(5,passwords.isExpectedPassword(kullanici.getParolaTekrar(),salt,passwords.hash(kullanici.getParola(), salt)));
			psmt.setString(6,salt);
			
			if(psmt.executeUpdate()>0)
			{
				state=true;
			}
			con.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			ConDao.kapat(con, psmt);
		}
		return state;
	}	

	public static Kullanici login(String kullaniciTel,String parola){
		Kullanici kullanici=null;
		String sql="select * from tbl_kullanici where kullaniciTel = ? and parola = ?";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			kullanici=new Kullanici();
			psmt.setString(1,kullaniciTel);
			psmt.setString(2,parola);
			rs=psmt.executeQuery();
			if(rs.next()){
				kullanici=new Kullanici();
				kullanici.setKullaniciId(rs.getInt(1));
				kullanici.setKullaniciAd(rs.getString(2));
				kullanici.setKullaniciTel(rs.getString(3));
				kullanici.setParola(rs.getString(4));
				kullanici.setParolaTekrar(rs.getString(5));
				kullanici.setDurum(rs.getBoolean(6));	
				kullanici.setTuz(rs.getString(7));
				kullanici.setAktif(rs.getString(8));
				kullanici.setAktifSaat(rs.getTimestamp(9));
				kullanici.setKullaniciTip(new KullaniciTip(rs.getString(10)));
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDao.kapat(con, psmt, rs);
		}
		
		return kullanici;
	}
	
	public static Kullanici controlTelefon(String kullaniciTel) {
		
		Kullanici kullanici=null;
		String sql="select tuz from tbl_kullanici where kullaniciTel = ?";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			kullanici=new Kullanici();
			psmt.setString(1,kullaniciTel);
			rs=psmt.executeQuery();
			if(rs.next()){
				kullanici=new Kullanici();
				kullanici.setTuz(rs.getString(1));
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDao.kapat(con, psmt, rs);
		}
		
		return kullanici;
	}
	
	public static List<Kullanici> yonlendir(int kullaniciId) {
		 List<Kullanici> kullanicilar=new ArrayList<>(); 
		Kullanici kullanici=null;
		String sql="select * from tbl_kullanici where kullaniciId = ?";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,kullaniciId);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				kullanici=new Kullanici();
				kullanici.setKullaniciId(rs.getInt(1));
				kullanici.setKullaniciAd(rs.getString(2));
				kullanici.setKullaniciTel(rs.getString(3));
				kullanici.setParola(rs.getString(4));
				kullanici.setParolaTekrar(rs.getString(5));
				kullanici.setDurum(rs.getBoolean(6));	
				kullanici.setTuz(rs.getString(7));
				kullanici.setAktif(rs.getString(8));
				kullanici.setAktifSaat(rs.getTimestamp(9));
				kullanici.setKullaniciTip(new KullaniciTip(rs.getString(10)));
				kullanicilar.add(kullanici);	
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConDao.kapat(con, psmt);
		}
		return kullanicilar;
	}
	
	public static List<Kullanici> kullaniciBul(String kullaniciAd) {
	 List<Kullanici> kullanicilar=new ArrayList<>(); 

		String sql="select kullaniciId,kullaniciAd,kullaniciTel from tbl_kullanici where kullaniciAd = ?";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,kullaniciAd);
			rs=psmt.executeQuery();
			
				while(rs.next()){
				Kullanici kullanici=new Kullanici();
				kullanici.setKullaniciId(rs.getInt(1));
				kullanici.setKullaniciAd(rs.getString(2));
				kullanici.setKullaniciTel(rs.getString(3));
				kullanicilar.add(kullanici);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDao.kapat(con, psmt);
		}
		
		return kullanicilar;
	}
	
	

}
