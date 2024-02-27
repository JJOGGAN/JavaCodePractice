package doIt.collection.treeset;

import doIt.collection.Member;

public class MemberTreeSetTest {
    public static void main(String[] args) {
        MemberTreeSet memberTreeSet = new MemberTreeSet();

        Member memberSon = new Member(1003, "박지성");
        Member memberLee = new Member(1001, "리정혁");
        Member memberPark = new Member(1004, "손흥민");
        Member memberHong = new Member(1002, "홍길동");

        memberTreeSet.addMember(memberLee);
        memberTreeSet.addMember(memberPark);
        memberTreeSet.addMember(memberSon);
        memberTreeSet.addMember(memberHong);

        memberTreeSet.showAllMember();

        Member memberCho = new Member(1002, "초저녁"); //아이디 중복
        memberTreeSet.addMember(memberCho);
        memberTreeSet.showAllMember();
    }
}
