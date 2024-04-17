package kh.mclass.semim.board.model.dto;

import java.util.List;

import javax.swing.text.AbstractDocument.Content;

public class BoardReadDto {
//	BOARD_ID     NOT NULL NUMBER         
//	SUBJECT      NOT NULL VARCHAR2(120)  
//	CONTENT      NOT NULL VARCHAR2(4000) 
//	WRITE_TIME   NOT NULL TIMESTAMP(6)   
//	LOG_IP                VARCHAR2(15)   
//	BOARD_WRITER NOT NULL VARCHAR2(20)   
//	READ_COUNT   NOT NULL NUMBER     
	
	private Integer boardId;
	private String subject;
	private String content;
	private String writeIime;
	private String logIp;
	private String boardWriter;
	private Integer readCount;
//	private List<BoardReplyListDto> replydtolist;
	private List<FileReadDto> filedtolist;
	
	public BoardReadDto(Integer boardId, String subject, String content, String writeIime, String logIp, String boardWriter,
			Integer readCount) {
		super();
		this.boardId = boardId;
		this.subject = subject;
		//줄바꾸기, 띄워쓰기 HTML 태그로 변경하는 코드
		//DB를 꺼내오는 부분에 작성
		content=content.replaceAll("\\r?\\n","<br>"); //\r또는\n을 찾으면 <br>로 전환해달라
		content=content.replaceAll(" ","&nbsp"); //띄워쓰기는 &nbsp(jsp 띄워쓰기)로  표시해달라
		//jsp파일로 가면 변환 위 코드처럼 변환된 값이 들어간다.
		this.content = content;
		this.writeIime = writeIime;
		this.logIp = logIp;
		this.boardWriter = boardWriter;
		this.readCount = readCount;
	}

	

	@Override
	public String toString() {
		return "BoardReadDto [boardId=" + boardId + ", subject=" + subject + ", content=" + content + ", writeIime="
				+ writeIime + ", logIp=" + logIp + ", boardWriter=" + boardWriter + ", readCount=" + readCount + "]";
	}



	public Integer getBoardId() {
		return boardId;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getWriteIime() {
		return writeIime;
	}
	public String getLogIp() {
		return logIp;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public Integer getReadCount() {
		return readCount;
	}

	

	public List<FileReadDto> getFiledtolist() {
		return filedtolist;
	}

	public void setFiledtolist(List<FileReadDto> filedtolist) {
		this.filedtolist = filedtolist;
	}
	
	
	
}
