package kh.mclass.semim.board.model.dto;

public class FileReadDto {
	private String boardId;
	private String boardFileId; // 값을 변화시킬 것 아니면 int값이지만 String에 넣어도 됩니다.
	private String savedFilePathName;
	private String orginalFileName;
	@Override
	public String toString() {
		return "FileReadDto [boardId=" + boardId + ", boardFileId=" + boardFileId + ", savedFilePathName="
				+ savedFilePathName + ", orginalFileName=" + orginalFileName + "]";
	}
	public FileReadDto(String boardId, String boardFileId, String savedFilePathName, String orginalFileName) {
		super();
		this.boardId = boardId;
		this.boardFileId = boardFileId;
		this.savedFilePathName = savedFilePathName;
		this.orginalFileName = orginalFileName;
	}
	public String getBoardId() {
		return boardId;
	}
	public String getBoardFileId() {
		return boardFileId;
	}
	public String getSavedFilePathName() {
		return savedFilePathName;
	}
	public String getOrginalFileName() {
		return orginalFileName;
	}
	
	

}
