package com.javajungsuk_basic.exercise.ch06;
class prac6_1_2 {
	public static void main(String args[]) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		SutdaCard card3 = new SutdaCard(10);

	}
}

class SutdaCard{
	int num;
	boolean isKwang;

	SutdaCard(){
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}

	SutdaCard(int num){
		this.num = num;
	}

	String info() {
		return num + (isKwang? "K" : "");
	}
}
