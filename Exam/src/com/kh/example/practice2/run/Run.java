package com.kh.example.practice2.run;

import com.kh.example.practice2.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		Product product = new Product(); //기본 생성자로 객체 생성
		
		product.setpName("허쉬초코");
		product.setPrice(1500);
		product.setBrand("허쉬");
		
		product.information(); //출력
	}

}
