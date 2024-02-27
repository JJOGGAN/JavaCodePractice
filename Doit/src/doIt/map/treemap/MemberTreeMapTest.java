package doIt.map.treemap;

import doIt.collection.Member;

import java.util.TreeMap;

public class MemberTreeMapTest {
    public static void main(String[] args) {
        MemberTreeMap memberTreeMap = new MemberTreeMap();

        Member memberSon = new Member(1003, "박지성");
        Member memberLee = new Member(1001, "리정혁");
        Member memberPark = new Member(1004, "손흥민");
        Member memberHong = new Member(1002, "홍길동");

        memberTreeMap.addMember(memberSon);
        memberTreeMap.addMember(memberLee);
        memberTreeMap.addMember(memberPark);
        memberTreeMap.addMember(memberHong);

        memberTreeMap.showAllMember();

        memberTreeMap.removeMember(1004);
        System.out.println("**** after ****");
        memberTreeMap.showAllMember();
    }
}
