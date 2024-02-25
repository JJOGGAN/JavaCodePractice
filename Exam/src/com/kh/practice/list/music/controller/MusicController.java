package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {

	private List<Music> list = new ArrayList<Music>();
//	private List list = new ArrayList(); 
	// 이렇게 작성해도 문제 없음 이후에 문제가 될 순 있음 자료형이 fix가 되어 있지 않지 때문

	// 리스트 마지막에 값 저장
	public int addList(Music music) {
//		boolean result = list.add(music);
		// return (result) ? 1 : 0 ; //
		int result = -1;
		if (list.add(music)) {
			result = list.size();
		}
		return result; // -1 , 0-n now size
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
		// list에서 title을 찾으면 자료형은 Music이니까 반환되는 것은 Music이 맞음
		// list에서 title을 반환해야하니 list.get(i)라고해야겠죵?
		// list.get(i)를 찾기 위한 코드를 메소드(searchMusic)에 넣어주면 되겠죵??

		Music search = null;
		for (Music m : list) {
			if (m.getTitle().equals(title)) {
				search = list.get(list.indexOf(m));
				break;
			} else {
				search = null;
			}
		}

		return search;
	}

//
	public Music removeMusic(String title) {
		Music remove = new Music();
		for (Music music : list) {
			if (music.getTitle().equals(title)) {
				remove = music;
				list.remove(music);
				break;
			} else {
				remove = null;
			}
		}
		return remove;
	}

	public Music setMusic(String title, Music music) {
		Music set = new Music();
		for (Music m : list) {
			if (m.getTitle().equals(title)) {
				set = list.set(list.indexOf(m), music);
				System.out.println(m.getSinger()+" - "+m.getTitle()+"의 값이 변경 되었습니다.");
				return set;
			}else {
				set = null;
				System.out.println("수정할 곡이 없습니다.");
			}
		}

		return set;
	}

	public int ascTitle() {
		Collections.sort(list, new AscTitle());
		return 1;
	}

	public int descSinger() {
		Collections.sort(list);
		return 1;
	}

}
