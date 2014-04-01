package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.Subway;
import util.DAOFactory;
import exception.SubwayScodeNotExistException;

public class SubwayDAO {
	public static ArrayList<Subway> getAllSubway() throws SQLException {
		ArrayList<Subway> all=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("select * from Subway");
			rs=pstmt.executeQuery();
			all=new ArrayList<Subway>();
			
			while(rs.next()){
				all.add(new Subway(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4)));
			}
		}finally{
			DAOFactory.close(rs, pstmt, con);
		}
		return all;
	}
	
	//������ �߰�
	public static boolean insertSubway(Subway subway) throws SQLException{
		
		if(isExist(subway.getSubwayCode())){
			System.out.println("�̹� �����ϴ� ������ �Դϴ�.");
		}
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;

		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("insert into Subway values(?,?,?,?)");
			pstmt.setInt(1, subway.getSubwayCode());
			pstmt.setString(2, subway.getSubwayName());
			pstmt.setInt(3, subway.getSubwayLength());
			pstmt.setInt(4, subway.getSubwayPrice());
			
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		}finally{
			DAOFactory.close(pstmt, con);
		}
		return result;
	}
	
	//������ ����
	public static boolean deleteSubway(int subwayCode) throws SQLException, SubwayScodeNotExistException{
		
		if(!isExist(subwayCode)){
			System.out.println("����� �ִ� �����Ͱ� �����ϴ�.");
		}
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("delete from Subway where subway_code=?");
			pstmt.setInt(1, subwayCode);
			
			while(pstmt.executeUpdate()==1){
				result=true;
			}
		}finally{
			DAOFactory.close(pstmt, con);
		}
		return result;
	}
	
	//������ ����
	public static boolean updateSubway(int subwayCode, String subwayName) throws SQLException{
		if(!isExist(subwayCode)){
			System.out.println("������ �����Ͱ� �����ϴ�. ");
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("update Subway set subway_name=? where subway_code=?");
			pstmt.setString(1, subwayName);			
			pstmt.setInt(2, subwayCode);
			
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		}finally{
			DAOFactory.close(pstmt, con);
		}
		return result;
	}
	
	//�ϳ��� ������ �˻�
	public static Subway getOneSubway(int subwayCode) throws SQLException{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Subway Subway=null;

		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("select * from Subway where subway_code=?");
			pstmt.setInt(1, subwayCode);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				Subway=new Subway(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
			}
			
		}finally{
			DAOFactory.close(rs, pstmt, con);
		}
		return Subway;
	}
	
	//�ش� �������� ���� ����
	public static boolean isExist(int subwayCode) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("select * from Subway where subway_code=?");
			pstmt.setInt(1, subwayCode);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				result=true; //����
			}
		}finally{
			DAOFactory.close(rs, pstmt, con);
		}
		return result; //������
	}
	
	public static void deleteAll(){
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("delete from subway");
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
