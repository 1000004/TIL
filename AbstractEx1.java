/*
	모든 도형은 면적을 구할 수 있다.(+getArea():int)

	Shape을 상속받는 Rectangle, Triangle, Circle을 구현하라.
*/


abstract class Shape {
	public abstract int getArea();

	@Override
	public String toString(){
		return "area : " + getArea();
	}
}

class Circle extends Shape {
	private int r;
	public static final double PI = 3.14;
	public Circle(int r){
		setR(r);
	}
	public int getR(){
		return r;
	}
	public void setR(int r){
		this.r = r;
	}
	@Override
	public int getArea(){
		return (int)(r*r*PI);
	}

	@Override
	public String toString(){
		String info = "<< Circle >>\n";
		info += "radius : " + r + "\n";
		info += super.toString();

		return info;
	}
}

abstract class BasicShape extends Shape{
	private int h;
	private int l;
	
	public BasicShape(int h,int l) {
		setH(h);
		setL(l);
	}
	public int getH(){
		return h;
	}
	public int getL(){
		return l;
	}
	public void setH(int h){
		this.h = h;
	}
	public void setL(int l){
		this.l = l;
	}
	@Override
	public String toString(){
		String info = "width : " + h + "\n";
		info += "length : " + l + "\n";
		info += super.toString();

		return info;
	}
}
class Rectangle extends BasicShape {
	public Rectangle(int h,int l) {
		super(h,l);
	}
	@Override
	public int getArea(){
		return getH()*getL();
	}
	@Override
	public String toString(){
		String info = "<< Rectangle >>\n";
		info += super.toString();
		return info;
	}
}

class Triangle extends BasicShape {

	public Triangle(int h,int l) {
		super(h,l);
	}
	@Override
	public int getArea(){
		return getL()*getH()/2;
	}
	@Override
	public String toString(){
		String info = "<< Triangle >>\n";
		info += super.toString();
		return info;
	}
}

public class AbstractEx1 {
	public static void main(String[] args) {
		System.out.println(new Circle(5));
		System.out.println(new Rectangle(4,5));
		System.out.println(new Triangle(6,8));


	}
}