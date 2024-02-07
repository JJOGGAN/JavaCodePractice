package practice.array;

public class EnhancedForLoop {

	public static void main(String[] args) {
		String[] strArray = {"Java","Android","C","JavaScript","Python"};

//		향상된 for문은 처음부터 끝까지 모든 요소를 참조할 때 사용
//		초기화, 종료조건 없음
//		for(변수 : 배열){
//			반복실행문;
//		}
		for(String lang : strArray) {
			System.out.println(lang);
		}
		
	}

}
