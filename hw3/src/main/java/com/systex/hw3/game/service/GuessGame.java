package com.systex.hw3.game.service;

public class GuessGame {
	private int remains;
	private int luckyNumber;

	public GuessGame(int range, int remains) {
		this.remains = remains;
		this.luckyNumber = generateLuckyNumber(range);
	}

	private int generateLuckyNumber(int range) {
		return (int) (Math.random() * range) + 1;
	}

	public boolean guess(int number) {
		if (remains > 0) {
			remains--;
			return number == luckyNumber;
		}
		return false; // 如果沒有剩餘次數，返回 false
	}

	public int getRemains() {
		return remains;
	}

	public boolean hasRemains() {
		return remains > 0;
	}
}
