package com.javajungsuk_basic.exercise.ch06;
class SutdaCard {
	public static void main(String args[]) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
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
}
