package kh.mclass.semim.board.model.dto;

public class BoardListDto {
//	BOARD_ID     NOT NULL NUMBER         
//	SUBJECT      NOT NULL VARCHAR2(120)  
//	CONTENT      NOT NULL VARCHAR2(4000) 
//	WRITE_TIME   NOT NULL TIMESTAMP(6)   
//	LOG_IP                VARCHAR2(15)   
//	BOARD_WRITER NOT NULL VARCHAR2(20)   
//	READ_COUNT   NOT NULL NUMBER     
	
	private Integer boardId;
	private String subject;

	private String writeIime;

	private String boardWriter;
	private Integer readCount;
	
	
	
	
	public BoardListDto() {
		super();
	}
	public BoardListDto(Integer boardId, String subject, String content, String writeIime, String logIp, String boardWriter,
			Integer readCount) {
		super();
		this.boardId = boardId;
		this.subject = subject;
		this.writeIime = writeIime;
		this.boardWriter = boardWriter;
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", subject=" + subject + ", writeIime="
				+ writeIime + ", boardWriter=" + boardWriter + ", readCount=" + readCount + "]";
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriteIime() {
		return writeIime;
	}
	public void setWriteIime(String writeIime) {
		this.writeIime = writeIime;
	}

	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	
}
