package doIt.collection;

public class Member {
	private int memberID;
	private String member;
	public Member(int memberID, String member) {
		super();
		this.memberID = memberID;
		this.member = member;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getMember() {
		return member;
	}
	@Override
	public String toString() {
		return member+"님의 회원번도는 " + member + "입니다.";
	}

}
