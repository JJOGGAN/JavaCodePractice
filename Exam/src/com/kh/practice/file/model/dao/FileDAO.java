package com.kh.practice.file.model.dao;

import java.io.File;

public class FileDAO {
	
//	파일이 있는지 확인 후 반환
	public boolean checkName(String file) {
		
		//TODO return
		return true;
	}
//	파일에 문자열 s 저장
	public void fileSave(String file,String s) {
		File f = new File(file);
		
	}
//	파일 명을 이용하여 저장된 데이터 반환
	public StringBuilder fileOpen (String file) {
		//TODO return
		return null;
		
	}
//	파일에 문자열 저장
	public void fileEdit(String file) {
		
	}
}
