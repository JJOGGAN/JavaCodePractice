package doIt.collection;

import java.util.Comparator;

public class Member2 implements Comparator<Member2> {

    private int memberID;
    private String memberName;

    public int getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Member2(int memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }

    @Override
    public int compare(Member2 member1, Member2 member2) {
        return member1.getMemberID() - member2.getMemberID(); //member1이 크면 양수 반환, 오름차순 정렬
    }



}
