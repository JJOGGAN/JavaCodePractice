package chat.client;

import javax.swing.JOptionPane;

public class ClientRun {
	public static void main(String[] args) {

		String nickName = JOptionPane.showInputDialog("닉네임을 입력해주세요");
		// cancel --> null, 아무것도 입력 안하고 OK == >
		if (nickName != null && !nickName.equals("")) { // && : null먼저 체크한 다음에 "" 체크
			// if (!nickName.equals("")&&nickName != null ) { //NullPointExceptino Error
			// :null이니 애초에 ""이 인식 안 됨
			new ClientGUI(nickName);
		} else {
			System.out.println("닉네임 없이는 채팅창에 접속할 수 없습니다.");

		}

//		if (nickName == null || !nickName.equals("")) {
//			System.out.println("닉네임 없이는 채팅창에 접속할 수 없습니다.");
//		} else {
//			new ClientGUI(nickName);
//		}
	}
}
