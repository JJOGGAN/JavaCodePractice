package mclass.week3.collection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		Date today = new Date();
		Date when = new Date(12345678L);
		System.out.println("today : " + today);
		System.out.println("when :" + when);

		SimpleDateFormat ft = new SimpleDateFormat("yy년 MM월dd일 hh:mm:ss");
		String ftToday = ft.format(today);
		System.out.println(ftToday);
		// today에 포맷을 적용한 결과를 문자열로 리턴
		// 24년 02월14일 11:48:24

		System.out.println(Math.floor(3.145192));
	}
}
