package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.EmpnoNotExistException;
import model.domain.Emp;
import util.DAOFactory;

public class EmpDAO {
	//모든 데이터 반환
	public static ArrayList<Emp> getAllEmp() throws SQLException {
		ArrayList<Emp> all=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		/*
		 private int empno;1
		private String ename;2
		private String job;3
		private int mgr;4
		private String date;5
		private int sal;6
		private int comm;7
		private int deptno;8
		 */
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("select * from emp01");
			rs=pstmt.executeQuery();
			all=new ArrayList<Emp>();
			
			while(rs.next()){
				all.add(new Emp(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8)));
			}
		}finally{
			DAOFactory.close(rs, pstmt, con);
		}
		return all;
	}
	
	//데이터 추가
	public static boolean insertEmp(Emp e) throws SQLException{
		
		if(isExist(e.getEmpno())){
			System.out.println("이미 존재하는 데이터 입니다.");
		}
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int rs;
		/*
		 private int empno;1
		private String ename;2
		private String job;3
		private int mgr;4
		private String date;5
		private int sal;6
		private int comm;7
		private int deptno;8
		 */
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement(""
					+ "insert into emp01 values(?,?,?,?,sysdate,?,?,?)");
			pstmt.setInt(1, e.getEmpno());
			pstmt.setString(2, e.getEname());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getMgr());
			//sysdate
			pstmt.setInt(5, e.getSal());
			pstmt.setInt(6, e.getComm());
			pstmt.setInt(7, e.getDeptno());
			
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		}finally{
			DAOFactory.close(pstmt, con);
		}
		return result;
	}
	
	//데이터 삭제
	public static boolean deleteEmp(int empno) throws SQLException, EmpnoNotExistException{
		
		if(!isExist(empno)){
			System.out.println("지울수 있는 데이터가 없습니다.");
		}
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int rs;
		
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("delete from emp01 where empno=?");
			pstmt.setInt(1, empno);
			
			while(pstmt.executeUpdate()==1){
				result=true;
			}
		}finally{
			DAOFactory.close(pstmt, con);
		}
		return result;
	}
	
	//데이터 수정
	public static boolean updateEmp(int empno, String ename, String job) throws SQLException{
		if(!isExist(empno)){
			System.out.println("수정할 데이터가 없습니다. ");
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int rs;
		/*
		 private int empno;1
		private String ename;2
		private String job;3
		private int mgr;4
		private String date;5
		private int sal;6
		private int comm;7
		private int deptno;8
		 */
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement(""
			+ "update emp01 set ename=?, job=? where empno=?");
			pstmt.setString(1, ename);
			pstmt.setString(2, job);
			pstmt.setInt(3, empno);
			
			if(pstmt.executeUpdate()==1){
				result=true;
			}
		}finally{
			DAOFactory.close(pstmt, con);
		}
		return result;
	}
	
	//하나의 데이터 검색
	public static Emp getOneEmp(int empno) throws SQLException{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Emp emp=null;
		/*
		 private int empno;1
		private String ename;2
		private String job;3
		private int mgr;4
		private String date;5
		private int sal;6
		private int comm;7
		private int deptno;8
		 */
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("select * from emp01 where empno=?");
			pstmt.setInt(1, empno);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				emp=new Emp(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8));
			}
			
		}finally{
			DAOFactory.close(rs, pstmt, con);
		}
		return emp;
	}
	
	//해당 데이터의 존재 유무
	public static boolean isExist(int empno) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		try{
			con=DAOFactory.getConnection();
			pstmt=con.prepareStatement("select * from emp01 where empno=?");
			pstmt.setInt(1, empno);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				result=true; //존재
			}
		}finally{
			DAOFactory.close(rs, pstmt, con);
		}
		return result; //미존재
	}
}
