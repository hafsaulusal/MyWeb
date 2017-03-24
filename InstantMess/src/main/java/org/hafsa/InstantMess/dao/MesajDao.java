package org.hafsa.InstantMess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.RSA;
import org.hafsa.InstantMess.Security.Keccak;
import org.hafsa.InstantMess.model.Arkadas;
import org.hafsa.InstantMess.model.Kullanici;
import org.hafsa.InstantMess.model.Mesaj;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class MesajDao {
	
	private static Connection con=null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static List<Mesaj> mesajGetir(int k1,int k2)
	{
		List<Mesaj> mesajlar=new ArrayList<>();
		Mesaj mesaj=null;
		
		String sql="select m.mesajId,m.arkadasId,k2.kullaniciId,k2.kullaniciAd , "+
				" k.kullaniciId ,k.kullaniciAd ,m.mesaj from tbl_mesaj as m "+

				" inner join tbl_arkadas as a " +
				" on m.arkadasId=a.arkadasId " +
				
				" inner join tbl_kullanici as k "+
				" on m.kullaniciId=k.kullaniciId " +
				
				" inner join tbl_kullanici as k2 "+
				" on a.kullanici2=k2.kullaniciId "+
				" where " +
	                " (a.kullanici1=? or a.kullanici2=?) " +
	               " and  " +
	               " (a.kullanici1=? or a.kullanici2=?) " +
	                " order by m.gonderimSaat asc";
		
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,k1);
			psmt.setInt(2,k1);
			psmt.setInt(3,k2);
			psmt.setInt(4,k2);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				mesaj=new Mesaj();
				mesaj.setMesajId(rs.getInt(1));
				mesaj.setArkadasId(new Arkadas((rs.getInt(2)),new Kullanici(rs.getInt(3), rs.getString(4))));
				mesaj.setKullaniciId(new Kullanici(rs.getInt(5),rs.getString(6)));
				mesaj.setMesaj(rs.getString(7));
				mesajlar.add(mesaj);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConDao.kapat(con, psmt);
		}
		return mesajlar;
	
	}
	
	public static boolean mesajEkle(Mesaj mesaj)
	{
		boolean state=false;
		String sql="insert into tbl_mesaj (mesaj,mesajozeti,gonderimSaat,"+
				" okumaSaat,arkadasId,kullaniciId) values (?,?,now(),now(),?,?)";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, mesaj.getMesaj());
			psmt.setString(2,Keccak.sha3(mesaj.getMesaj()));
			psmt.setInt(3, mesaj.getArkadasId().getArkadasId());
			psmt.setInt(4, mesaj.getKullaniciId().getKullaniciId());
			
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

	public static List<Mesaj> tumKullaniciMesaj()
	{
		List<Mesaj> mesajlar=new ArrayList<>();
		Mesaj mesaj=null;
		
		String sql="select m.mesajId,m.arkadasId,k2.kullaniciId,k2.kullaniciAd , "+
				" k.kullaniciId ,k.kullaniciAd from tbl_mesaj as m "+

				" inner join tbl_arkadas as a " +
				" on m.arkadasId=a.arkadasId " +
				
				" inner join tbl_kullanici as k "+
				" on m.kullaniciId=k.kullaniciId " +
				
				" inner join tbl_kullanici as k2 "+
				" on a.kullanici2=k2.kullaniciId "+
				" group by k2.kullaniciAd ";
				try {
					con=ConDao.getConnection();
					psmt=con.prepareStatement(sql);
					rs=psmt.executeQuery();
					while(rs.next())
					{
						mesaj=new Mesaj();
						mesaj.setMesajId(rs.getInt(1));
						mesaj.setArkadasId(new Arkadas((rs.getInt(2)),new Kullanici(rs.getInt(3), rs.getString(4))));
						mesaj.setKullaniciId(new Kullanici(rs.getInt(5),rs.getString(6)));
					
						mesajlar.add(mesaj);
						
					}
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					ConDao.kapat(con, psmt);
				}
				return mesajlar;
			
			}

	public static List<Mesaj> kullaniciMesaj(int k1)
	{
		List<Mesaj> mesajlar=new ArrayList<>();
		Mesaj mesaj=null;
		
		String sql="select m.mesajId,m.arkadasId,k2.kullaniciId,k2.kullaniciAd , "+
				" k.kullaniciId ,k.kullaniciAd  from tbl_mesaj as m "+

				" inner join tbl_arkadas as a " +
				" on m.arkadasId=a.arkadasId " +
				
				" inner join tbl_kullanici as k "+
				" on m.kullaniciId=k.kullaniciId " +
				
				" inner join tbl_kullanici as k2 "+
				" on a.kullanici2=k2.kullaniciId "+
				" group by k2.kullaniciAd " +
                 " having k.kullaniciId=? " ;
		
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,k1);
		
			rs=psmt.executeQuery();
			while(rs.next())
			{
				mesaj=new Mesaj();
				mesaj.setMesajId(rs.getInt(1));
				mesaj.setArkadasId(new Arkadas((rs.getInt(2)),new Kullanici(rs.getInt(3), rs.getString(4))));
				mesaj.setKullaniciId(new Kullanici(rs.getInt(5),rs.getString(6)));
				
				mesajlar.add(mesaj);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConDao.kapat(con, psmt);
		}
		return mesajlar;
	
	}

	public static boolean ResimEkle(Mesaj mesaj)
	{
		boolean state=false;
		String sql="insert into tbl_mesaj (resim,gonderimSaat,"+
				" okumaSaat,arkadasId,kullaniciId) values (?,now(),now(),?,?)";
		try {
			con=ConDao.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, mesaj.getResim());
			psmt.setInt(2, mesaj.getArkadasId().getArkadasId());
			psmt.setInt(3, mesaj.getKullaniciId().getKullaniciId());
			
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

}
