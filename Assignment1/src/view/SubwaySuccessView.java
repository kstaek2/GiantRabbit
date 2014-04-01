package view;

import java.util.ArrayList;

import model.domain.Subway;

public class SubwaySuccessView {
	public static void successMsg(String msg){
		System.out.println(msg);
	}
	
	public static void printAll(ArrayList<Subway> all){
		if(all.size()!=0){
			for (int i = 0; i < all.size(); i++) {
				System.out.println(i+"번 : "+all.get(i));
			}
		}else{
			System.out.println("Subway관련 데이터 정보가 하나도 없습니다. ");
		}
	}
	
	public static void printSubway(Subway subway){
		if(subway!=null){
			System.out.println(subway);
		}else{
			System.out.println("출력할수 있는 데이터가 없습니다. ");
		}
	}
}
