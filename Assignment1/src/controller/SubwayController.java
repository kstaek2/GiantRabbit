package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.SubwayScodeNotExistException;
import view.SubwayFailView;
import view.SubwaySuccessView;
import model.dao.SubwayDAO;
import model.domain.Subway;

public class SubwayController {
	//모든 데이터 검색
	public static void getAllSubway(){
		try {
			SubwaySuccessView.printAll(SubwayDAO.getAllSubway());
		} catch (SQLException e) {
			e.printStackTrace();
			SubwayFailView.failMsg("모든 검색 실패");
		}
	}
	
	//하나의 데이터 검색
	public static void getOneSubway(int subwayCode){
		try {
			SubwaySuccessView.printSubway(SubwayDAO.getOneSubway(subwayCode));
		} catch (SQLException e) {
			e.printStackTrace();
			SubwayFailView.failMsg("검색 실패");
		}
	}
	
	//추가
	public static void insertSubway(Subway e){
		try {
			if(SubwayDAO.insertSubway(e)){
				SubwaySuccessView.successMsg("데이터 추가 성공");
			}else{
				SubwayFailView.failMsg("데이터 추가 실패");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			SubwayFailView.failMsg("데이터 추가 실패 다시 시도하세요");
		}
	}
	
	//삭제
	public static void deleteSubway(int subwayCode){
		
			try {
				if(SubwayDAO.deleteSubway(subwayCode)){
					SubwaySuccessView.successMsg("삭제 성공");
				}else{
					SubwayFailView.failMsg("삭제 실패");
				}
			} catch (SubwayScodeNotExistException e) {
				e.printStackTrace();
				SubwayFailView.failMsg(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				SubwayFailView.failMsg("삭제 실패 다시 시도하세요");
			}
	}
	//전체삭제
	public static void deleteAll(){
			SubwayDAO.deleteAll();
			SubwaySuccessView.successMsg("삭제 성공");
	}
	//수정
	public static void updateSubway(int subwayCode, String subwayName){
		try {
			if(SubwayDAO.updateSubway(subwayCode, subwayName)){
				SubwaySuccessView.successMsg("수정 성공");
			}else{
				SubwayFailView.failMsg("수정 실패");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			SubwayFailView.failMsg("수정 실패 다시 시도하세요");
		}
	}
}
