package com.kh.practice.list.music.model.vo;

public class Music {
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

	@Override // 상속도 안 했는데 왜 오버라이드..??
	public String toString() {
		// TODO return revision
		return title + " - " + singer ;
	}

//	@Override //TODO 오버라이딩하니까 오류발생
//	public int hashCode(Object obj) {
//		// TODO result?
//		int result = 0;
//		return result;
//	}

	public boolean equals(Object obj) {
		// TODO result?
		boolean result = false;
		return result;
	}

	public int compareTo(Object obj) {
		// TODO result? 정렬기준??
		int result = 0;
		return result;
	}

}
