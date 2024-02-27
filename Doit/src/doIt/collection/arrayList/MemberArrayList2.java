package doIt.collection.arrayList;

import java.util.ArrayList;
import java.util.Iterator;

import doIt.collection.*;

public class MemberArrayList2 {
	private ArrayList<Member> arrayList; // ArrayList 선언

	public MemberArrayList2() {
		arrayList = new ArrayList<Member>();
	}

	public void addMember(Member member) { // arrayList에 member 타입 추가
		arrayList.add(member);
	}

	public boolean removeMember(int memberId) {
		Iterator<Member> ir = arrayList.iterator();
		//enhaned for 문의 구버전이라 생각하면 될 듯 합니다.
		//arrayList를 Iterator 형으로 바꿔서 hasNext와 next를 이용하여 순차적으로 출력

		while(ir.hasNext()) {
			Member member = ir.next( );
			int tempId = member.getMemberID();
			if (tempId == memberId) {
				arrayList.remove(member);
				return true;
			}
		}
		for(Member member : arrayList) {
			int tempId = member.getMemberID();
			if (tempId == memberId) {
				arrayList.remove(member);
				return true;
			}
		}
		
		//끝날 때까지 삭제하려는 값을 찾지 못한 경우
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	public void showAllMember() {
		for (Member member : arrayList) {
			System.out.println(member);
		}
		System.out.println();
	}

}
