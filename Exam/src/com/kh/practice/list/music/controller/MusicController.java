package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {

	private List<Music> list = new ArrayList<Music>();
//	private List list = new ArrayList(); // 이렇게 작성해도 문제 없음 이후에 문제가 될 순 있음 자료형이 fix가 되어 있지 않지 때문

	
	//리스트 마지막에 값 저장
	public int addList(Music music) {
//		boolean result = list.add(music);
		//return (result) ? 1 : 0 ;  // 
		int result = -1; 
		if(list.add(music)) {
			result = list.size();
		}
		return result;   // -1 , 0-n now size
	}

	// 0번째에 값 저장
	public int addAtZero(Music music) {

		list.add(0, music);
		
		return 1;

	}

	public List printAll() {
		return list;
	}
//
	public Music searchMusic(String title) {
//		// TODO enhanced for 문으로 작성해보기
		// list에서 title을 찾으면 자료형은 Music이니까 반환되는 것은 Music이 맞음
		// list에서 title을 반환해야하니 list.get(i)라고해야겠죵?
		// list.get(i)를 찾기 위한 코드를 메소드(searchMusic)에 넣어주면 되겠죵??
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(title)) {
				return list.get(i);
			}
		}
		
		return null;
	}
//
	public Music removeMusic(String title) {
		Music result = null;
		for (Music music : list) {
			if(music.getTitle().equals(title)) {
				result = music;
				list.remove(music);
				return result; // 삭제한 데이터 반환 해 줌
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		Music result = null;
		for (Music music2 : list) {
			if(music2.getTitle().equals(title)) {
				music2 = music;
				result = music;
				return result;
			}
		}
		
		return null;
	}

	public int ascTitle() {
		Collections.sort(list, new AscTitle());
		return 1;
	}

	public int descSinger() {
		// TODO 거꾸로 정렬
		return 1;
	}


}
