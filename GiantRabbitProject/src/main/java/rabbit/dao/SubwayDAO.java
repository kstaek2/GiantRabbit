package rabbit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import rabbit.dto.Subway;
import rabbit.util.DBUtil;

public class SubwayDAO {
	
	public static List getAllSubway () throws SQLException {
		
		SqlSession session = DBUtil.getSqlSession();
		List selectAll = null;
		
		try {
			selectAll = session.selectList("Subway.getAllSubway");
		} finally {
			session.close();
		}
		return selectAll;
	}

	public static Subway getOneSubway (int subwayCode) throws SQLException {
		
		SqlSession session = DBUtil.getSqlSession();
		Subway subway = null;
		
		try {
			subway = (Subway)session.selectOne("Subway.getOneSubway", new Integer(subwayCode));			
			if(subway == null){
				System.out.println("해당 역이 없습니다.");
			}			
		} finally {
			session.close();
		}		
		return subway;		
	}

	 public static void insertSubway (Subway subway) throws SQLException {
		 
		 SqlSession session = DBUtil.getSqlSession(true);
		 
		 try{
			 session.insert("Subway.insertSubway", subway);			 
		 } finally{
			session.close();
		 }
	 }
	 
	 public static void updateSubway (Subway subway) throws SQLException {
		 
		 SqlSession session = DBUtil.getSqlSession(true);
		 
		 try{
			 Subway subway2 = (Subway)session.selectOne("Subway.getOneSubway", new Integer(subway.getSubwayCode()));
			 subway2.setSubwayName(subway.getSubwayName());
			 session.update("Subway.updateSubway", subway2);
		 }finally{
			 session.close();
		 }
	 }
	 
	 public static void deleteSubway (int subwayCode) throws SQLException {
		 
		 SqlSession session = DBUtil.getSqlSession(true);
		 
		 try{
			 session.delete("Subway.deleteSubway", new Integer(subwayCode)); 
		 }finally{
			 session.close();
		 }
	 }
	 
	 public static void deleteAllSubway () throws SQLException {
		 
		 SqlSession session = DBUtil.getSqlSession(true);
		 
		 try{
			 session.delete("Subway.deleteAllSubway"); 
		 }finally{
			 session.close();
		 }
	 }
	 
	 public static int subwayLength (String subwayName1, String subwayName2) {
		 
		 int subwayLength;
		 SqlSession session = DBUtil.getSqlSession(true);
		 
		 Subway subway1 = null;
		 Subway subway2 = null;
		 
		 try{
			 subway1 = session.selectOne("Subway.getOneSubwayName", subwayName1);
			 subway2 = session.selectOne("Subway.getOneSubwayName", subwayName2);
			 subwayLength = subway1.getSubwayLength() - subway2.getSubwayLength();
			 
			 if(subwayLength < 0){
				 subwayLength=subwayLength*(-1);
			 }
		 }finally{
			 session.close();
		 }
		 return subwayLength;
	 }
	 
	 public static int subwayPrice (String subwayName1, String subwayName2) {
		 int subwayLength= 0;
		 int subwayPrice = 0;
		 
		 SqlSession session = DBUtil.getSqlSession(true);
		 
		 Subway subway1 = null;
		 Subway subway2 = null;
		 Subway subwayPrice1 = null;
		 
		 try{
			 subway1 = session.selectOne("Subway.getOneSubwayName", subwayName1);
			 subway2 = session.selectOne("Subway.getOneSubwayName", subwayName2);
			 subwayPrice1 = session.selectOne("Subway.getOneSubwayName", subwayName1);
			 subwayLength = subway1.getSubwayLength()-subway2.getSubwayLength();
			 
			 if(subwayLength < 0) {
				 subwayLength = subwayLength*(-1);
			 }
			 
			 if(subwayLength <= 3 && subwayLength > 0) {
				 subwayPrice = subwayPrice1.getSubwayPrice() + (100*0);
			 }else if(subwayLength <= 6 && subwayLength > 4) {
				 subwayPrice = subwayPrice1.getSubwayPrice() + (100*1);
			 }else if(subwayLength <= 9 && subwayLength > 7) {
				 subwayPrice = subwayPrice1.getSubwayPrice() + (100*2);
			 }else if(subwayLength <= 15 && subwayLength > 10) {
				 subwayPrice=subwayPrice1.getSubwayPrice() + (100*3);
			 }else if(subwayLength <= 21 && subwayLength > 16) {
				 subwayPrice=subwayPrice1.getSubwayPrice() + (100*4);
			 }else if(subwayLength <= 25 && subwayLength > 22) {
				 subwayPrice=subwayPrice1.getSubwayPrice() + (100*5);
			 }else if(subwayLength <= 33 && subwayLength > 26) {
				 subwayPrice=subwayPrice1.getSubwayPrice() + (100*6);
			 }
			 
		 }finally{
			 session.close();
		 }
		 return subwayPrice;
	 }
}