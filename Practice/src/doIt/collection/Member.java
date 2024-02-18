package doIt.collection;

public class Member implements Comparable<Member>{
	private int memberID;
	private String memberName;
	public Member(int memberID, String memberName) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getMemberName() {
		return memberName;
	}
	@Override
	public String toString() {
		return memberName +"님의 회원번호는 " + memberID + "입니다.";
	}

	@Override
	public int hashCode() {
		return memberID;//hashCode로 맴버아이디 반환
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			if (this.memberID == member.memberID) { // 파라미터로 받은 아이디가 같으면 true 반환
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Member member) {      // method 재정의
		return (this.memberID - member.memberID); //아이디비교 오름차순 *(-1) : 내림차순
		//새로 추가되는 값 : this.memverID
		//비교되는 값 : 파라미터값
	}

//	public int compare(Member2 member1, Member2 member2) {
//		int result = (member1.getMemberName()).compareTo(member2.getMemberName()) ;
//		return result; //member1이 크면 양수 반환, 오름차순 정렬
//	}


}
