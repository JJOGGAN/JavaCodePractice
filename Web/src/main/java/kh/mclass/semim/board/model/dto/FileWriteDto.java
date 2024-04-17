package kh.mclass.semim.board.model.dto;

public class FileWriteDto {
	private String filePath;
	private String orginFileName;
	@Override
	public String toString() {
		return "FileWriteDto [filePath=" + filePath + ", orginFileName=" + orginFileName + "]";
	}
	public FileWriteDto(String filePath, String orginFileName) {
		super();
		this.filePath = filePath;
		this.orginFileName = orginFileName;
	}
	public String getFilePath() {
		return filePath;
	}

	public String getOrginFileName() {
		return orginFileName;
	}

	
}
