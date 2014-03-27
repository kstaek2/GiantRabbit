package view;

import java.sql.SQLException;

import controller.EmpController;
import model.dao.EmpDAO;
import model.domain.Emp;

public class EmpStartView {
	public static void main(String[] args) {
		System.out.println("ㅎㅇhihello");
		System.out.println("준이천재바보");
		//emp01 데이터 모두 출력
		System.out.println("*** emp01 데이터 모두 출력 ***");
		EmpController.getAllEmp();
		
		System.out.println();
		System.out.println("*** empno:7369 데이터 출력 ***");
		EmpController.getOneEmp(7369);
		
		System.out.println();
		System.out.println("*** empno:7369 데이터 삭제 ***");
		EmpController.deleteEmp(7369);
		
		System.out.println();
		System.out.println("*** 삭제 된 empno:7369 데이터 출력 ***");
		EmpController.getOneEmp(7369);
		
		System.out.println();
		System.out.println("*** 데이터 추가 ***");
		EmpController.insertEmp(new Emp(1,"Im","programer", 11,  11, 22, 33));
		
		System.out.println();
		System.out.println("*** 추가된 데이터 출력 ***");
		EmpController.getOneEmp(1);
		
		System.out.println();
		System.out.println("*** 수정 전 empno:7934 데이터 출력 ***");
		EmpController.getOneEmp(7934);
		
		System.out.println("*** empno:7934 데이터 수정 ***");
		EmpController.updateEmp(7934, "ucamp", "manager");
		
		System.out.println();
		System.out.println("*** 수정 후 empno:7934 데이터 출력 ***");
		EmpController.getOneEmp(7934);
		
	}
}
