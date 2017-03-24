package org.hafsa.InstantMess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hafsa.InstantMess.model.Arkadas;
import org.hafsa.InstantMess.model.Kullanici;


public class ArkadasDao {
	
	private static Connection con=null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static boolean arkadasEkle(Arkadas arkadas)
	{
		boolean state=false;
		String sql="insert into tbl_arkadas(kullanici1,kullanici2)"
				+ "values (?,?)";
		try
		{
		con=ConDao.getConnection();
		psmt=con.prepareStatement(sql);
		psmt.setInt(1,arkadas.getKullanici1().getKullaniciId());
		psmt.setInt(2,arkadas.getKullanici2().getKullaniciId());
		
		if(psmt.executeUpdate()>0)
		{
			state=true;
		}
		con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConDao.kapat(con, psmt);
		}
		return state;
		
	}
	
	public static List<Arkadas> arkadasGetir(int kullaniciId) {
		Arkadas arkadas=null;
		List<Arkadas> arkadaslar=new ArrayList<>();
		String sql="select distinct a.arkadasId,k2.kullaniciId,k2.kullaniciAd, k2.kullaniciTel "+
				"from tbl_arkadas as a "+
				"inner join tbl_kullanici as k1 "+
				"on  a.kullanici1=k1.kullaniciId "+
				"inner join tbl_kullanici as k2 "+
				"on  a.kullanici2=k2.kullaniciId "+
				"where k1.kullaniciId=? ";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,kullaniciId);
			rs=psmt.executeQuery();
			
			while(rs.next()){
				arkadas=new Arkadas();
				arkadas.setArkadasId(rs.getInt(1));
				arkadas.setKullanici2(new Kullanici(rs.getInt(2),rs.getString(3),rs.getString(4)));
				arkadaslar.add(arkadas);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDao.kapat(con, psmt);
		}
		
		return arkadaslar;
	}
	
}
