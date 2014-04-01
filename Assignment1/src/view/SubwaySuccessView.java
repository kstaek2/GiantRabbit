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
				System.out.println(i+"�� : "+all.get(i));
			}
		}else{
			System.out.println("Subway���� ������ ������ �ϳ��� �����ϴ�. ");
		}
	}
	
	public static void printSubway(Subway subway){
		if(subway!=null){
			System.out.println(subway);
		}else{
			System.out.println("����Ҽ� �ִ� �����Ͱ� �����ϴ�. ");
		}
	}
}
