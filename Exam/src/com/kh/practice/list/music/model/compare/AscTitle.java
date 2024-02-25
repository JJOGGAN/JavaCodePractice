package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle  implements Comparator<Music> {
// 곡 명을 오름차순 기준으로 하는 정렬을 제공하는 메소드

	@Override
	public int compare(Music o1, Music o2) {
		int result = 0;
		o1.getTitle().compareTo(o2.getTitle());
		
		if (o1.getTitle().equals(o2.getTitle())) { //title이 같은 경우 singer로 정렬
			o1.getSinger().equals(o2.getSinger());
		}else {
			result = o1.getTitle().compareTo(o2.getTitle());
		}
		return result;
	}
}
