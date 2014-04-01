package view;

import model.domain.Subway;
import controller.SubwayController;

public class SubwayStartView {
	public static void main(String[] args) {
		
		//������ ��ü ����
		SubwayController.deleteAll();
		
		System.out.println();
		System.out.println("*** ������ �߰� ***");
		SubwayController.insertSubway(new Subway(1,"���", 0, 1050));
		SubwayController.insertSubway(new Subway(2,"����", 1, 1050));
		SubwayController.insertSubway(new Subway(3,"����", 3, 1050));
		SubwayController.insertSubway(new Subway(4,"�ܴ���Ÿ�", 5, 1050));
		SubwayController.insertSubway(new Subway(5,"���ѻ꼺�Ա�", 6, 1050));
		SubwayController.insertSubway(new Subway(6,"�꼺", 9, 1050));
		SubwayController.insertSubway(new Subway(7,"����", 12, 1050));
		SubwayController.insertSubway(new Subway(8,"����", 15, 1050));
		SubwayController.insertSubway(new Subway(9,"����", 16, 1050));
		SubwayController.insertSubway(new Subway(10,"��������", 19, 1050));
		SubwayController.insertSubway(new Subway(11,"����", 20, 1050));
		SubwayController.insertSubway(new Subway(12,"����", 22, 1050));
		SubwayController.insertSubway(new Subway(13,"���", 24, 1050));
		SubwayController.insertSubway(new Subway(14,"�����伺", 26, 1050));
		SubwayController.insertSubway(new Subway(15,"������û", 28, 1050));
		SubwayController.insertSubway(new Subway(16,"õȣ", 30, 1050));
		SubwayController.insertSubway(new Subway(17,"�ϻ�", 31, 1050));
		

		//Subway01 ������ ��� ���
		System.out.println("*** Subway01 ������ ��� ��� ***");
		SubwayController.getAllSubway();
		
		System.out.println("*** Subwayno:7369 ������ ��� ***");
		SubwayController.getOneSubway(7369);
		
		System.out.println();
		System.out.println("*** Subwayno:7369 ������ ���� ***");
		SubwayController.deleteSubway(7369);
		
		System.out.println();
		System.out.println("*** ���� �� Subwayno:7369 ������ ��� ***");
		SubwayController.getOneSubway(7369);
		
		System.out.println();
		System.out.println("*** �߰��� ������ ��� ***");
		SubwayController.getOneSubway(1);
		
		System.out.println();
		System.out.println("*** ���� �� Subwayno:7934 ������ ��� ***");
		SubwayController.getOneSubway(7934);
		
		System.out.println("*** Subwayno:7934 ������ ���� ***");
		SubwayController.updateSubway(7934, "ucamp");
		
		System.out.println();
		System.out.println("*** ���� �� Subwayno:7934 ������ ��� ***");
		SubwayController.getOneSubway(7934);
		
	}
}
