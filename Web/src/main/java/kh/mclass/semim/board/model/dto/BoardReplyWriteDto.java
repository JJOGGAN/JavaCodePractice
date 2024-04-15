package kh.mclass.semim.board.model.dto;

public class BoardReplyWriteDto {
/*	BOARD_REPLY_ID         NOT NULL NUMBER         
	BOARD_ID               NOT NULL NUMBER         
	MEM_ID                 NOT NULL VARCHAR2(20)   ...??????
	BOARD_REPLY_CONTENT    NOT NULL VARCHAR2(4000) 
	BOARD_REPLY_WRITE_TIME NOT NULL TIMESTAMP(6)   
	BOARD_REPLY_LOG_IP              VARCHAR2(15)   
	BOARD_REPLY_LEVEL      NOT NULL NUMBER(2)      
	BOARD_REPLY_REF        NOT NULL NUMBER         
	BOARD_REPLY_STEP                NUMBER(3)    */
	
	private Integer boardReplyId;
	private Integer boardId;
	private String boardReplyWriter;
	private String boardReplyContent;
	private String boardReplyLogIp;
	//아래 3가지는 제외하면 안됨 - 클라이언트가 넣는 값이 아님 이건 개발자가 넣어줘야함
	//쓰고 등록을 완료해야 아래의 3가지가 필요함
//	private Integer boardReplyLevel;
//	private Integer boardReplyRef;
//	private Integer boardReplyStep;
	public BoardReplyWriteDto(Integer boardReplyId, Integer boardId, String boardReplyWriter, String boardReplyContent,
			String boardReplyLogIp) {
		super();
		this.boardReplyId = boardReplyId;
		this.boardId = boardId;
		this.boardReplyWriter = boardReplyWriter;
		this.boardReplyContent = boardReplyContent;
		this.boardReplyLogIp = boardReplyLogIp;
	}
	@Override
	public String toString() {
		return "BoardReplyWriteDto [boardReplyId=" + boardReplyId + ", boardId=" + boardId + ", boardReplyWriter="
				+ boardReplyWriter + ", boardReplyContent=" + boardReplyContent + ", boardReplyLogIp=" + boardReplyLogIp
				+ "]";
	}
	public Integer getBoardReplyId() {
		return boardReplyId;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public String getBoardReplyWriter() {
		return boardReplyWriter;
	}
	public String getBoardReplyContent() {
		return boardReplyContent;
	}
	public String getBoardReplyLogIp() {
		return boardReplyLogIp;
	}
	
	
	
	
}