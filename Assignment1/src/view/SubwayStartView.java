package view;

import model.domain.Subway;
import controller.SubwayController;

public class SubwayStartView {
	public static void main(String[] args) {
		
		//데이터 전체 삭제
		SubwayController.deleteAll();
		
		System.out.println();
		System.out.println("*** 데이터 추가 ***");
		SubwayController.insertSubway(new Subway(1,"모란", 0, 1050));
		SubwayController.insertSubway(new Subway(2,"수진", 1, 1050));
		SubwayController.insertSubway(new Subway(3,"신흥", 3, 1050));
		SubwayController.insertSubway(new Subway(4,"단대오거리", 5, 1050));
		SubwayController.insertSubway(new Subway(5,"남한산성입구", 6, 1050));
		SubwayController.insertSubway(new Subway(6,"산성", 9, 1050));
		SubwayController.insertSubway(new Subway(7,"복정", 12, 1050));
		SubwayController.insertSubway(new Subway(8,"장지", 15, 1050));
		SubwayController.insertSubway(new Subway(9,"문정", 16, 1050));
		SubwayController.insertSubway(new Subway(10,"가락시장", 19, 1050));
		SubwayController.insertSubway(new Subway(11,"송파", 20, 1050));
		SubwayController.insertSubway(new Subway(12,"석촌", 22, 1050));
		SubwayController.insertSubway(new Subway(13,"잠실", 24, 1050));
		SubwayController.insertSubway(new Subway(14,"몽촌토성", 26, 1050));
		SubwayController.insertSubway(new Subway(15,"광동구청", 28, 1050));
		SubwayController.insertSubway(new Subway(16,"천호", 30, 1050));
		SubwayController.insertSubway(new Subway(17,"암사", 31, 1050));
		

		//Subway01 데이터 모두 출력
		System.out.println("*** Subway01 데이터 모두 출력 ***");
		SubwayController.getAllSubway();
		
		System.out.println("*** Subwayno:7369 데이터 출력 ***");
		SubwayController.getOneSubway(7369);
		
		System.out.println();
		System.out.println("*** Subwayno:7369 데이터 삭제 ***");
		SubwayController.deleteSubway(7369);
		
		System.out.println();
		System.out.println("*** 삭제 된 Subwayno:7369 데이터 출력 ***");
		SubwayController.getOneSubway(7369);
		
		System.out.println();
		System.out.println("*** 추가된 데이터 출력 ***");
		SubwayController.getOneSubway(1);
		
		System.out.println();
		System.out.println("*** 수정 전 Subwayno:7934 데이터 출력 ***");
		SubwayController.getOneSubway(7934);
		
		System.out.println("*** Subwayno:7934 데이터 수정 ***");
		SubwayController.updateSubway(7934, "ucamp");
		
		System.out.println();
		System.out.println("*** 수정 후 Subwayno:7934 데이터 출력 ***");
		SubwayController.getOneSubway(7934);
		
	}
}
