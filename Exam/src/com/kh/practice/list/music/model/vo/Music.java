package com.kh.practice.list.music.model.vo;

import java.io.Serializable;
import java.util.Objects;

public class Music implements Serializable, Comparable<Music>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1920237084129639547L;
	private String title;
	private String singer;

	public Music() {
		super();
	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	} 

//	객체의 정보 리턴
	@Override
	public String toString() {
		return title + " - " + singer ;
	}
//	해시코드 오버라이딩
	@Override 
	public int hashCode() { //파라미터 안 들어감
		return Objects.hash(singer,title);
	}

	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj ==null) return false;
		if(getClass() != obj.getClass()) return false;
		Music other  = (Music) obj;
		
		return Objects.equals(singer, other.singer) && Objects.equals(title, other.title);
	}

// 정렬 기준 메소드
	@Override
	public int compareTo(Music o) {
		int result = this.singer.compareTo(o.getSinger());
		return -result; // 내림차순 : 음수
	}

}
