package doIt.exception;

public class IDFormatTest {
	private String userID;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) throws IDFormatException { // 예외 처리 미룸
		if (userID == null) {
			throw new IDFormatException("아이디는 null일 수 없습니다.");
		} else if (userID.length() < 8 || userID.length() > 20) {
			throw new IDFormatException("아이디는 8이상 20자 이하로 쓰세요");
		}
		this.userID = userID;
	}

	public static void main(String[] args) {
		IDFormatTest test = new IDFormatTest();
		String userID = null;
		try {
			test.setUserID(userID);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
		String userID2 = "melona";
		try {
			test.setUserID(userID2);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
		String userID3 = "TodayIsFriday";
		try {
			test.setUserID(userID3);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
	
	}
}
