package com.omada.pithia.model.mathimata;

public enum Eksamhno {

	A(1),B(2),C(3),D(4),E(5),F(6),G(7),H(8);

	private final int timh;

	Eksamhno(int timh) {
		this.timh = timh;
	}

	public boolean einaiMegaluteroEksamhno(Eksamhno eksamhno) {
		return timh > eksamhno.getTimh();
	}

	public int getTimh(){
		return timh;
	}

}
