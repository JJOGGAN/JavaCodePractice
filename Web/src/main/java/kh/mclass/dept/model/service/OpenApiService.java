package kh.mclass.dept.model.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

import kh.mclass.dept.model.vo.OpenApiVo;
import kh.mclass.jdbc.JdbcTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class OpenApiService {// ArpltnInforInqireSvc

	private Properties prop = new Properties();

	public void getMinuDustFrcstDspth() throws IOException {// 대기질 예보
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=서비스키"); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
				+ URLEncoder.encode("xml", "UTF-8")); /* xml 또는 json */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수(조회 날짜로 검색 시 사용 안함) */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
				+ URLEncoder.encode("1", "UTF-8")); /* 페이지번호(조회 날짜로 검색 시 사용 안함) */
		urlBuilder.append("&" + URLEncoder.encode("searchDate", "UTF-8") + "="
				+ URLEncoder.encode("2020-11-14", "UTF-8")); /* 통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인) */
		urlBuilder.append("&" + URLEncoder.encode("InformCode", "UTF-8") + "="
				+ URLEncoder.encode("PM10", "UTF-8")); /* 통보코드검색(PM10, PM25, O3) */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

	}

	public List<OpenApiVo> getCtprvnRltmMesureDnsty() { // 실시간
		List<OpenApiVo> volist = null;
		System.out.println("****");
		try {
			String currentPath = JdbcTemplate.class.getResource("./").getPath();
			prop.load(new FileReader(currentPath + "driver.properties"));
			System.out.println(prop.getProperty("openApi.serviceKey.encoding"));
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="
					+ prop.getProperty("openApi.serviceKey.encoding")); // encoding된 서비스키를 넣었기 때문에 굳이 encode 할 필요 없음
			// + URLEncoder.encode(prop.getProperty("openApi.serviceKey", "UTF-8")));
			// decoding된 코드를 setvicekey에 담겨있을 때 쓰는 코드/* Service Key */
			urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
					+ URLEncoder.encode("xml", "UTF-8")); /* xml 또는 json */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			urlBuilder.append("&" + URLEncoder.encode("sidoName", "UTF-8") + "=" + URLEncoder.encode("서울",
					"UTF-8")); /*
								 * 시도 이름(전국, 서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)
								 */
			urlBuilder.append("&" + URLEncoder.encode("ver", "UTF-8") + "="
					+ URLEncoder.encode("1.0", "UTF-8")); /* 버전별 상세 결과 참고 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;

//    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//    } else {
//        rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//    }

//    StringBuilder sb = new StringBuilder();
//    String line;
//    while ((line = rd.readLine()) != null) {
//        sb.append(line);
//    }
//    rd.close();
//    conn.disconnect();
//    //System.out.println(sb.toString());
//    
//    return sb.toString();

//    Document doc = parseXML(conn.getInputStream());
//    
//    volist = new ArrayList<OpenApiVo>(); 
//    return volist; //list의 vo를 리턴할거임

			// 방법 2 - a - conn --> InputStream --> Xml --> Document( HTMLXML) --> item 들 -->
			// node들을 하나씩 읽기
			// parseXML(conn.getInputStream())를 사용해 Document doc 생성
			Document doc = parseXML(conn.getInputStream());
			conn.disconnect();
			// item 들을 NodeList nodelist 담기
			NodeList nodelist = doc.getElementsByTagName("item");

			// item 데이터가 없다면 바로 null return;
			if (nodelist.getLength() < 1) {
				return volist;
			}

			// item 데이터가 있다면
			volist = new ArrayList<OpenApiVo>();
			for (int i = 0; i < nodelist.getLength(); i++) {// nodelist면 item 한 번
				Node item = nodelist.item(i); // 하나만 꺼내서 보여줘 // 첫번쨰 벨류 보여줌
				// Node안에는 item 전체값을 갖고 있음
				OpenApiVo vo = new OpenApiVo();

				/* 초기식 */
				Node n = item.getFirstChild(); // item의 첫번째 자식을 꺼내줘
//		sysout찍어서 돌아가는 과정 꼭 확인하기 복기 필요
				while (n != null/* 조건식 */) { // while이 5번 돌아야 vo 하나 완성
					String nodeName = n.getNodeName();
					String nodeText = n.getTextContent(); // node사이의 값 꺼내기
					switch (nodeName) { // 나머지 item value는 버림
					case "so2Grade":
						vo.setSo2Grade(nodeText);
						System.out.println(nodeName);
						break;
					case "so2Value":
						vo.setSo2Value(nodeText);
						break;
					case "pm10Value":
						vo.setPm10Value(nodeText);
						break;
					case "dataTime":
						vo.setDataTime(nodeText);
						break;
					case "stationName":
						vo.setStationName(nodeText);
						break;
					// 다른 값들은 필요없으니 default 값 버림
					}
					/* 증감식 */
					n = n.getNextSibling(); // 나 다음에 있는 형제로 해줘 하면서 노드가 바뀜/ 다음 형제로 바뀌어서 while조건문으로 간다.
				}
				volist.add(vo); // while이 다 돈 후 volist에 vo 하나 넣어줌
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return volist;
	}

//	json 모양으로 변환
	public Map<String, Object> getCtprvnRltmMesureDnstyByJson() throws IOException { // 실시간

		String currentPath = JdbcTemplate.class.getResource("./").getPath();
		prop.load(new FileReader(currentPath + "driver.properties"));
		System.out.println(prop.getProperty("openApi.serviceKey"));
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="
				+ prop.getProperty("openApi.serviceKey")); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml 또는 json */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder
				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("sidoName", "UTF-8") + "=" + URLEncoder.encode("서울",
				"UTF-8")); /*
							 * 시도 이름(전국, 서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)
							 */
		urlBuilder.append(
				"&" + URLEncoder.encode("ver", "UTF-8") + "=" + URLEncoder.encode("1.0", "UTF-8")); /* 버전별 상세 결과 참고 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;

		// 방법1. console 뿌리기
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		rd.close();
		conn.disconnect();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>(); // 파라미터 json,
		map = (Map) gson.fromJson(sb.toString(), map.getClass());
		System.out.println(map.get("items") + "\n");
		System.out.println("----------------------------------");
		System.out.println(map.get("item"));
		System.out.println(map);

		/*--------------------------------------------------------------------------------------------------*/
		// 원하는 값만 나오게 설정하기
		/*--------------------------------------------------------------------------------------------------*/

		// gson.toJson(null);
		return map;
	}

	// xml to Java Object 검색 : xml을 Java로 바꿔주는 메소드
	// inputstream형태는 주면 document 형태로 바꿔준대
	private Document parseXML(InputStream stream) {
		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objDocumentBuilder = null;
		Document result = null;

		try {
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			result = objDocumentBuilder.parse(stream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { // Simple API for XML
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
