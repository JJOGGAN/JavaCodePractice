package com.kh.practice.file.controller;

import com.kh.practice.file.model.dao.FileDAO;

public class FileController {
	private FileDAO fd = new FileDAO();
	public boolean checkName(String file) {
		//DAO에 매개변수를 전달하고 값 다시 반환
		//TODO return
		fd.checkName(file);
		
		return false;
		
	}
	public void fileSave(String file, StringBuilder sb) {
		//전달받은 매개변수를 변경하고 DAO에 전달
		String s = sb.toString();
		fd.fileSave(file, s);
		
	}
	public StringBuilder fileOpen(String file) {
		//TODO return
		return null;
		
	}
	public void fileEdit(String file ,StringBuilder sb) {
		//전달받은 매개변수 변경, DAO 전달
	}
	
}
