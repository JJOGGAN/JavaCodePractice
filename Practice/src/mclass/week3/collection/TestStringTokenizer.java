package mclass.week3.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestStringTokenizer {
	public static void main(String[] args) {
		String str = "AA|BB|CC";
		StringTokenizer st = new StringTokenizer(str, "|");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		// StringTokenizer에서 nextToken을 하면 buffer에서 값을 꺼내옴
		// 꺼낸만큼 buffer에서 사라짐
		// 다 꺼내고 나면 st엔 암것도 없다(?)
		
		StringBuffer ss1 =new StringBuffer("스프링버퍼값");
		StringBuffer ss2= ss1; //얕은 복사 = 주소값 복사 / heap에 있는 공간 공유
		
		System.out.println("ss1 : "+ss1);
		System.out.println("ss2 : "+ss2);
		ss1.append("AAA");
		System.out.println("ss1 : "+ss1);
		System.out.println("ss2 : "+ss2);
	}
}
