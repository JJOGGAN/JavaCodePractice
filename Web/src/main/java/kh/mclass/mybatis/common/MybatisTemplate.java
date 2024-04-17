package kh.mclass.mybatis.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//package명에는 절대 대문자가 들어가면 안된다. 온점으로만 구분
public class MybatisTemplate {
//class는 반드시 대문자로 시작한다. 낙타표기법
	
	public static SqlSession getSqlSession() { //jdbctamplate의 getConnection 메소드와 비슷해요
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		try {
			
			//InputStream으로 Mybatis의 설정 정보를 읽어 온다
			//InputStream is = Resources.getResourceAsStream(resource);  ->  org.apache.ibatis.io.Resources에서 제공하는 기능
			//getResourceAsStream 싱글통이라 get으로 설정한 것으로 보임 꼭 clase를 해줘야한다는 것
			//읽어 온 Mybatis의 설정 정보를 바탕으로 SqlSessionFactoryBuilder를 생성한다
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = ssfb.build(inputStream);
			//줄이면 이렇게 됨 : SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			 
			//파일은 까서 거기서 꺼내서 SqlFactory를 실행해다오
			sqlSession=factory.openSession(); //autocommit의 기본 설정이 버전마다 설정이 다름 true,false
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
