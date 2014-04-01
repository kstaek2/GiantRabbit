package rabbit.view;

import java.sql.SQLException;

import rabbit.dao.SubwayDAO;
import rabbit.dto.Subway;

public class SubwayTest {
	
	public static void main(String[] args) {
		
		try {
			SubwayDAO.deleteAllSubway();
			
			System.out.println();
			System.out.println("*** 데이터 추가 ***");
			
			SubwayDAO.insertSubway(new Subway(1,"모란", 0, 1050));
			SubwayDAO.insertSubway(new Subway(2,"수진", 1, 1050));
			SubwayDAO.insertSubway(new Subway(3,"신흥", 3, 1050));
			SubwayDAO.insertSubway(new Subway(4,"단대오거리", 5, 1050));
			SubwayDAO.insertSubway(new Subway(5,"남한산성입구", 6, 1050));
			SubwayDAO.insertSubway(new Subway(6,"산성", 9, 1050));
			SubwayDAO.insertSubway(new Subway(7,"복정", 12, 1050));
			SubwayDAO.insertSubway(new Subway(8,"장지", 15, 1050));
			SubwayDAO.insertSubway(new Subway(9,"문정", 16, 1050));
			SubwayDAO.insertSubway(new Subway(10,"가락시장", 19, 1050));
			SubwayDAO.insertSubway(new Subway(11,"송파", 20, 1050));
			SubwayDAO.insertSubway(new Subway(12,"석촌", 22, 1050));
			SubwayDAO.insertSubway(new Subway(13,"잠실", 24, 1050));
			SubwayDAO.insertSubway(new Subway(14,"몽촌토성", 26, 1050));
			SubwayDAO.insertSubway(new Subway(15,"광동구청", 28, 1050));
			SubwayDAO.insertSubway(new Subway(16,"천호", 30, 1050));
			SubwayDAO.insertSubway(new Subway(17,"암사", 31, 1050));
			
			System.out.println("\n\n*** 선택 된 두 역사이 길이 출력 ***");
			System.out.println(SubwayDAO.subwayLength("암사", "모란")+"Km");
			System.out.println(SubwayDAO.subwayLength("수진", "산성")+"Km");
			
			System.out.println("\n\n*** 선택 된 두 역사이 가격 출력 ***");
			System.out.println(SubwayDAO.subwayPrice("수진", "모란")+"원");
			System.out.println(SubwayDAO.subwayPrice("수진", "암사")+"원");
			
			System.out.println("\n\n*** Subway01 데이터 모두 출력 ***");
			for(int i = 0; i < SubwayDAO.getAllSubway().size(); i++){
				System.out.println(SubwayDAO.getAllSubway().get(i).toString());
			}
			
			System.out.println("\n\n*** Subwayno : 3 데이터 출력 ***");
			System.out.println(SubwayDAO.getOneSubway(3).toString());
			
			System.out.println("\n\n*** Subwayno : 4 데이터 삭제 ***");
			SubwayDAO.deleteSubway(4);
			
			System.out.println("\n\n*** Subway01 데이터 모두 출력 ***");
			for(int i = 0; i < SubwayDAO.getAllSubway().size(); i++){
				System.out.println(SubwayDAO.getAllSubway().get(i).toString());
			}
			
			System.out.println("\n\n*** 추가된 데이터 출력 ***");
			System.out.println(SubwayDAO.getOneSubway(1).toString());
			
			System.out.println("\n\n*** 수정 전 Subwayno : 5 데이터 출력 ***");
			System.out.println(SubwayDAO.getOneSubway(5).toString());
			
			System.out.println("\n\n*** Subwayno : 7934 데이터 수정 ***");
			SubwayDAO.updateSubway(new Subway(5, "ucamp"));
			
			System.out.println("\n\n*** 수정 후 Subwayno : 7934 데이터 출력 ***");
			System.out.println(SubwayDAO.getOneSubway(5).toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
