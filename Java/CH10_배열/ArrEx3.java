class Marine{
	private int power = 10;
	private String name;
	
	public Marine(String name){
		this.name = name;
	}

	public void attackToSky(){
		System.out.println("다다다다닥~: " + power);
	}

	public void stimpack(){
		power += 2;
	}
}

class ArrEx3 {
	public static void main(String[] args) {
		// 객체들의 배열
		// Marine[] list = new Marine[3]; 주소에 지성된 객체가 없는 경우 Null로 되어있다.
		Marine[] list = {//list 3칸 배열 객체 주소 3개를 가지고 있다.
			new Marine("A"),
			new Marine("B"),
			new Marine("C")
		};

		for(Marine temp : list){
			temp.stimpack();
			temp.attackToSky();
		}
	}
}