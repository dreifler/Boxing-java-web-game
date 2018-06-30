package com.BoxingGame.springsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Boxers")
public class Boxer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="str")
	private int str;
	
	@Column(name="spd")
	private int spd;
	
	@Column(name="agl")
	private int agl;
	
	@Column(name="cnd")
	private int cnd;
	
	public Boxer() {}

	public Boxer(String name, int str, int spd, int agl, int cnd) {
		this.name = name;
		this.str = str;
		this.spd = spd;
		this.agl = agl;
		this.cnd = cnd;
	}
	
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getAgl() {
		return agl;
	}

	public void setAgl(int agl) {
		this.agl = agl;
	}

	public int getCnd() {
		return cnd;
	}

	public void setCnd(int cnd) {
		this.cnd = cnd;
	}

	@Override
	public String toString() {
		return "Boxer [ID=" + ID + ", name=" + name + ", str=" + str + ", spd=" + spd + ", agl=" + agl + ", cnd=" + cnd
				+ "]";
	}

	
	
	
}
