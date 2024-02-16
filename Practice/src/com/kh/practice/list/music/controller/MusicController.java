package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice.list.music.model.vo.Music;

public class MusicController {

	private List<Music> list = new ArrayList<Music>();
	// MUsic을 사용하려면 호출,상속을 해야하는데 표시가 없음
	// UML 다이어그램을 보면 클래스가 Music클래스의 불러와(?) 사용하는 것을 볼 수 있음
	// 자료형에 Music을 넣어서 사용
//	private List list = new ArrayList(); // 이렇게 작성해도 문제 없음 이후에 문제가 될 순 있음 자료형이 fix가 되어 있지 않지 때문

	public int addList(Music music) {
		// TODO result?
//		boolean result = list.add(music);
		//return (result) ? 1 : 0 ;  // 
		int result = -1; 
		if(list.add(music)) {
			//////
			result = list.size();
		}
		return result;   /// -1 , 0-n now size
	}

	// TODO 위에랑 같음
	public int addAtZero(Music music) {

		list.add(0, music);
		
		return 1;

	}

	public List<Music> printAll() {
		return list;
	}
//
//	public Music searchMusic(String title) {
//		// TODO 자료형이 Music인데 반환도 똑같이 Music이 아니라면 ..?
//		// 객체를 생성해서 return값을 지정해줘야하는 것...??
//		return list.get(i);
		// list에서 title을 찾으면 자료형은 Music이니까 반환되는 것은 Music이 맞음
		// list에서 title을 반환해야하니 list.get(i)라고해야겠죵?
		// list.get(i)를 찾기 위한 코드를 메소드(searchMusic)에 넣어주면 되겠죵??
//	}
//
//	public Music removeMusic(String title) {
//
//	}
//
//	public Music setMusic(String title, Music music) {
//
//	}

	public int ascTitle() {
		// TODO result?
		int result = 0;
		return result;
	}

	public int descSinger() {
		// TODO result?
		int result = 0;
		return result;
	}

}
