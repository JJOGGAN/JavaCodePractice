package com.kh.example.practice5.model.vo;

import java.util.Random;

public class Lotto {
//  random함수 활용해야할 것 같은데 어케 활용해야할지 아직 감이 안 잡힘
	
	private int[] lotto = new int[6];
	
	public Lotto() {
		lotto = new int[6];
		
//		Math.random
		for(int i = 0 ; i < lotto.length;i++) {
			//Math.random();
			lotto[i] = new Random().nextInt(45);
			System.out.println(lotto[i]);
		}
		
	}
	
	boolean run = true;
	private void setLotto() {
//		while(run) {
//			lotto[i].random;
//		}
	}
	
	public void information() {
		for(int i = 0; i< lotto.length;i++) {
			System.out.print(lotto[i]+"\n");
		}
	}
}
