package doIt.collection.hashset;

import doIt.collection.Member;

public class MemberHashSetTest {
    public static void main(String[] args) {
        MemberHashSet memberHashSet = new MemberHashSet();

        Member memberLee = new Member(1001,"Lee");
        Member memberPark = new Member(1002,"Park");
        Member memberKim = new Member(1003,"Kim");

        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberPark);
        memberHashSet.addMember(memberKim);
        memberHashSet.showAllMember();

        Member memberHong = new Member(1003, "Hong");
        memberHashSet.addMember(memberHong); //동일한 아이디를 가진 회원 추가
        memberHashSet.showAllMember();

    }
}
