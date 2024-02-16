package doIt.collection.arrayList;

import doIt.collection.Member;

public class MemberArrayListTest {
	public static void main(String[] args) {
		MemberArrayList2 memberArrayList = new MemberArrayList2();
		Member memberLee = new Member(1001, "이지원");
		Member memberKim = new Member(1002, "Kim");
		Member memberPark = new Member(1003, "Park");
		Member memberGu = new Member(1004, "Gu");
		
		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberKim);
		memberArrayList.addMember(memberPark);
		memberArrayList.addMember(memberGu);
		
		memberArrayList.showAllMember();
		
		memberArrayList.removeMember(memberGu.getMemberID());
		memberArrayList.showAllMember();
		
	}
}
