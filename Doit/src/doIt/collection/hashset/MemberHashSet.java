package doIt.collection.hashset;

import doIt.collection.Member;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {
    private HashSet<Member> hashSet; //선언

    public MemberHashSet() {
       hashSet = new HashSet<Member>(); //생성
    }
    public void addMember(Member member) { //회원 추가
        hashSet.add(member);
    }
    public boolean removeMember(int memberId) {
        Iterator<Member> ir = hashSet.iterator();

        while (ir.hasNext()) {
            Member member =ir.next();
            int tempId = member.getMemberID();
            if (tempId == member.getMemberID()) {
                hashSet.remove(member);
                return true;
            }
        }
        System.out.println(memberId+"가 존재하지 않습니다."); //값을 찾지 못한 경우
        return false;
    }

    public void showAllMember() {
        for (Member member : hashSet) {
            System.out.println(member);
        }
        System.out.println();
    }
}
