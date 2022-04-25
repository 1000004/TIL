//응집력
class Point{
	private int x;
	private int y;
	public void setX(int x){
		if(x>=0){
			this.x = x;
		}
	}
	public void setY(int y){
		if(x>=0){
			this.x=y;
		}
	}
	public void set(int x,int y){
		/*
			if(x>=0){
				this.x = x;
			}
			if(x>=0){
				this.x=y;
			}
		*/
		setX(x);
		setY(y);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String toString(){
		return "2차원 공간 좌표 ("+x+","+y+")";
	}
	public void print(){
		//자신의 참조값을 나타내는 키워드
		System.out.println(this);
	}
	
}

public class  PointTest {
	public static void main(String[] args) {
		Point p = new Point();
		p.set(1,2);
		p.print();
		System.out.println(p);


	}
}

