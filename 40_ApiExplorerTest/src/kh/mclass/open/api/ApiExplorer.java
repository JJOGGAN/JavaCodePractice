package kh.mclass.open.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
public class ApiExplorer {
	 public static void main(String[] args) throws IOException {
	        /*decoding 일 경우 */
	        //urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+URLEncoder.encode("blmIzRoNHpDgbhvdojev1P3GPzMFD7y0euvmyWTB6AsV7cnBjMbBPkEoJ0ZHDLjMnX1yvzW6TdeBKYEmZtWZCQ==","UTF-8")); /*Service Key*/
	     //http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty 
		 //?servicekdy=blmIzRoNHpDgbhvdojev1P3GPzMFD7y0euvmyWTB6AsV7cnBjMbBPkEoJ0ZHDLjMnX1yvzW6TdeBKYEmZtWZCQ%3D%3D
		 //&returnType = json
		 //&numOfRows = 10
		 //&pageNo = 4
		 //&sidoName = 서울
		 
		 	//String으로 설정하면 추가할 때마다 새로운 힙주소를 할당하기 때문에 메모리 낭비
		 	//StringBuilder를  사용한다 
		 	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=blmIzRoNHpDgbhvdojev1P3GPzMFD7y0euvmyWTB6AsV7cnBjMbBPkEoJ0ZHDLjMnX1yvzW6TdeBKYEmZtWZCQ%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        // encoding된 서비스키를 넣었기 때문에 굳이 URLEncoder.encode를 하지 않아도 된다. 다만 혹시 모를 경우를 대비해 encode를 사용함
	        //urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + 10); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode("서울", "UTF-8")); /*시도 이름(전국, 서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)*/
	        urlBuilder.append("&" + URLEncoder.encode("ver","UTF-8") + "=" + URLEncoder.encode("1.0", "UTF-8")); /*버전별 상세 결과 참고*/
	        
	        /*outputstream request 즉 요청 부분*/
	        URL url = new URL(urlBuilder.toString()); //해당 url에 접속해준다 toString가 명시적으로 코딩되어야 하는 class
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); /* = new URL(urlBuilder.toString()).openConnection()*/
	        /*openConnection --> URLConnection으로 return : URLConnection는 abstract 클래스*/
	        /*애초에 다형성을 해서 집어넣어야함 */
	        conn.setRequestMethod("GET"); /*doGet으로 이동*/
	        conn.setRequestProperty("Content-type", "application/json");
	        /**/
	        
	        
	        /*response inputstream*/
	        System.out.println("Response code: " + conn.getResponseCode()); /*정상 response*/
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {/*scope 200~300 : 정상 범위*/
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));/*InputStreamReader : 문자 단위로 바꿔주는 보조 스트림*/
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {/*readLine : BufferedReader의 메소드*/
	            sb.append(line); /*StringBuilder에 한줄씩 채워준 후 한 번에 출력*/
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
}
