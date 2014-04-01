package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.SubwayScodeNotExistException;
import view.SubwayFailView;
import view.SubwaySuccessView;
import model.dao.SubwayDAO;
import model.domain.Subway;

public class SubwayController {
	//��� ������ �˻�
	public static void getAllSubway(){
		try {
			SubwaySuccessView.printAll(SubwayDAO.getAllSubway());
		} catch (SQLException e) {
			e.printStackTrace();
			SubwayFailView.failMsg("��� �˻� ����");
		}
	}
	
	//�ϳ��� ������ �˻�
	public static void getOneSubway(int subwayCode){
		try {
			SubwaySuccessView.printSubway(SubwayDAO.getOneSubway(subwayCode));
		} catch (SQLException e) {
			e.printStackTrace();
			SubwayFailView.failMsg("�˻� ����");
		}
	}
	
	//�߰�
	public static void insertSubway(Subway e){
		try {
			if(SubwayDAO.insertSubway(e)){
				SubwaySuccessView.successMsg("������ �߰� ����");
			}else{
				SubwayFailView.failMsg("������ �߰� ����");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			SubwayFailView.failMsg("������ �߰� ���� �ٽ� �õ��ϼ���");
		}
	}
	
	//����
	public static void deleteSubway(int subwayCode){
		
			try {
				if(SubwayDAO.deleteSubway(subwayCode)){
					SubwaySuccessView.successMsg("���� ����");
				}else{
					SubwayFailView.failMsg("���� ����");
				}
			} catch (SubwayScodeNotExistException e) {
				e.printStackTrace();
				SubwayFailView.failMsg(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				SubwayFailView.failMsg("���� ���� �ٽ� �õ��ϼ���");
			}
	}
	//��ü����
	public static void deleteAll(){
			SubwayDAO.deleteAll();
			SubwaySuccessView.successMsg("���� ����");
	}
	//����
	public static void updateSubway(int subwayCode, String subwayName){
		try {
			if(SubwayDAO.updateSubway(subwayCode, subwayName)){
				SubwaySuccessView.successMsg("���� ����");
			}else{
				SubwayFailView.failMsg("���� ����");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			SubwayFailView.failMsg("���� ���� �ٽ� �õ��ϼ���");
		}
	}
}
