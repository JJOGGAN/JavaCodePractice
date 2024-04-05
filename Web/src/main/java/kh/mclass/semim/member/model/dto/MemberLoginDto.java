package kh.mclass.semim.member.model.dto;

public class MemberLoginDto {
//	MEM_ID    NOT NULL VARCHAR2(20)  
//	MEM_PWD   NOT NULL VARCHAR2(20)  
//	MEM_EMAIL NOT NULL VARCHAR2(100) 
	
	private String memId;
	private String memPwd;
	


	public MemberLoginDto(String memId, String memPwd) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;

	}
	
	
	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPwd=" + memPwd + "]";
	}
	
	public String getMemId() {
		return memId;
	}

	public String getMemPwd() {
		return memPwd;
	}
//생성자에서 파라미터 값으로 받아오기 때문에 setter가 필요 없음

}
