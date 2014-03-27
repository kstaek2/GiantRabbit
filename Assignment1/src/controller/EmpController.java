package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.EmpnoNotExistException;
import view.EmpFailView;
import view.EmpSuccessView;
import model.dao.EmpDAO;
import model.domain.Emp;

public class EmpController {
	//모든 데이터 검색
	public static void getAllEmp(){
		try {
			EmpSuccessView.printAll(EmpDAO.getAllEmp());
		} catch (SQLException e) {
			e.printStackTrace();
			EmpFailView.failMsg("모든 검색 실패");
		}
	}
	
	//하나의 데이터 검색
	public static void getOneEmp(int empno){
		try {
			EmpSuccessView.printEmp(EmpDAO.getOneEmp(empno));
		} catch (SQLException e) {
			e.printStackTrace();
			EmpFailView.failMsg("검색 실패");
		}
	}
	
	//추가
	public static void insertEmp(Emp e){
		try {
			if(EmpDAO.insertEmp(e)){
				EmpSuccessView.successMsg("데이터 추가 성공");
			}else{
				EmpFailView.failMsg("데이터 추가 실패");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			EmpFailView.failMsg("데이터 추가 실패 다시 시도하세요");
		}
	}
	
	//삭제
	public static void deleteEmp(int empno){
		
			try {
				if(EmpDAO.deleteEmp(empno)){
					EmpSuccessView.successMsg("삭제 성공");
				}else{
					EmpFailView.failMsg("삭제 실패");
				}
			} catch (EmpnoNotExistException e) {
				e.printStackTrace();
				EmpFailView.failMsg(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				EmpFailView.failMsg("삭제 실패 다시 시도하세요");
			}
	}
	//수정
	public static void updateEmp(int empno, String ename, String job){
		try {
			if(EmpDAO.updateEmp(empno, ename, job)){
				EmpSuccessView.successMsg("수정 성공");
			}else{
				EmpFailView.failMsg("수정 실패");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			EmpFailView.failMsg("수정 실패 다시 시도하세요");
		}
	}
}
