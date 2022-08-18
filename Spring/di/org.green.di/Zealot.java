package org.green.di;

import org.springframework.stereotype.Component;

@Component("myZealot")
//id=zealot
public class Zealot implements IUnit{
	private int hp;
	private int power;
	
	public Zealot() {
		setHp(50);
		setPower(10);
	}
	public Zealot(int hp, int power) {
		super();
		this.hp = hp;
		this.power = power;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Zealot [hp=" + hp + ", power=" + power + "]";
	}
}
