package org.green.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//id=mutal
public class Mutal implements IUnit{
	@Value("200")
	private int hp;
	@Value("15")
	private int power;
	
	public Mutal() {}
	public Mutal(int hp, int power) {
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
		return "Mutal [hp=" + hp + ", power=" + power + "]";
	}
}
