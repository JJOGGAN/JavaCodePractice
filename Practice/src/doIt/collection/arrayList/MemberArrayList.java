package doIt.collection.arrayList;

import java.util.ArrayList;
import doIt.collection.*;

public class MemberArrayList {
	private ArrayList<Member> arrayList; // ArrayList 선언

	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
	}

	public void addMember(Member member) { // arrayList에 member 타입 추가
		arrayList.add(member);
	}

	public boolean removeMember(int memberId) {
		for (int i = 0; i < arrayList.size(); i++) {
			Member member = arrayList.get(i);
			int tempId = member.getMemberID();
			if (tempId == memberId) {
				arrayList.remove(i);
				return true;
			}
		}
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
