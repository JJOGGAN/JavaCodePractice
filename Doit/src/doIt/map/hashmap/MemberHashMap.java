package doIt.map.hashmap;

import doIt.collection.Member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
    private HashMap<Integer, Member> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<Integer, Member>();

    }

    public void addMember(Member member) {
        hashMap.put(member.getMemberID(), member); //HashMap에 맴버 추가
    }

    public boolean removeMember(int memberID) {
        if (hashMap.containsKey(memberID)) { //만약 HashMap에 파라미터로 받은 키 값의 회원이 있다면
            hashMap.remove(memberID); //해당 해원 삭제
            return true;
        }
        System.out.println(memberID + "가 존재하지 않습니다");
        return false;
    }

    public void showAllMember() {
        Iterator<Integer> ir = hashMap.keySet().iterator(); //HashMap을 Set으로 변경 후
        while (ir.hasNext()) {
            int key = /*(int)*/ir.next();  // Iterator<T>로 한 후 여기서 타입 설정해도 정상작동
            Member member = hashMap.get(key);
            System.out.println(member);
        }
        System.out.println();
    }
}
