package doIt.collection.arrayList;

import doIt.collection.Member;

public class MemberArrayListTest {
    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();
        Member memberLee = new Member(1001, "이지원");
        Member memberKim = new Member(1002, "Kim");
        Member memberPark = new Member(1003, "Park");
        Member memberGu = new Member(1004, "Gu");

        memberArrayList.addMember(memberLee);
        memberArrayList.addMember(memberKim);
        memberArrayList.addMember(memberPark);
        memberArrayList.addMember(memberGu);

        memberArrayList.showAllMember();

        System.out.println("-----Gu remove-----");
        memberArrayList.removeMember(memberGu.getMemberID());
        memberArrayList.showAllMember();

        System.out.println("*********Iterator*********");
        MemberArrayList2 memberArrayList2 = new MemberArrayList2();
        Member memberOh = new Member(1006, "오혜정");
        Member memberHong = new Member(1007, "Hong");
        Member memberGo = new Member(1008, "Go");
        Member memberGal = new Member(1009, "Gal");

        memberArrayList2.addMember(memberOh);
        memberArrayList2.addMember(memberHong);
        memberArrayList2.addMember(memberGo);
        memberArrayList2.addMember(memberGal);

        memberArrayList2.showAllMember();

        System.out.println("-----Hong remove-----");
        memberArrayList2.removeMember(memberHong.getMemberID());
        memberArrayList2.showAllMember();

    }
}
