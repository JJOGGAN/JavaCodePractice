package doIt.map.hashmap;

import doIt.collection.Member;

public class MemberHashMapTest {
    public static void main(String[] args) {
        MemberHashMap memberHashMap = new MemberHashMap();

        Member memberSon = new Member(1003, "박지성");
        Member memberLee = new Member(1001, "리정혁");
        Member memberPark = new Member(1004, "손흥민");
        Member memberHong = new Member(1002, "홍길동");

        memberHashMap.addMember(memberLee);
        memberHashMap.addMember(memberPark);
        memberHashMap.addMember(memberSon);
        memberHashMap.addMember(memberHong);

        memberHashMap.showAllMember();

        memberHashMap.removeMember(1004);
        System.out.println("**** after ****");
        memberHashMap.showAllMember();
    }
}
