import java.util.*;

class IdentityInfo {
	public String jumin;
	public int age;
	public String name;

	public IdentityInfo(String jumin) {
		this.jumin = jumin;
	}

	public IdentityInfo(String name, int age, String jumin) {
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof IdentityInfo)) {
			return false;
		}
		IdentityInfo info = (IdentityInfo)o;
		return jumin.equals(info.jumin);
	}

	@Override
	public int hashCode() {
		return jumin.hashCode() % 4;
	}
}

class HumanInfo {
	public IdentityInfo infos;
	public String addr;
	public int height;
	public double weight;

	public HumanInfo(IdentityInfo infos, String addr, int height, double weight ){
		this.infos = infos;
		this.addr = addr;
		this.height = height;
		this.weight = weight;
	}
}
class JuminCenter {
	private Hashtable<IdentityInfo, HumanInfo> juminList;

	public JuminCenter() {
		juminList = new Hashtable<IdentityInfo, HumanInfo>();

		HumanInfo info1 = new HumanInfo(new IdentityInfo("A", 20, "111111-2222222"), "감만100", 170, 60);	
		HumanInfo info2 = new HumanInfo(new IdentityInfo("B", 21, "111111-2222223"), "감만102", 165, 50);	
		HumanInfo info3 = new HumanInfo(new IdentityInfo("C", 22, "111111-2222224"), "감만103", 172, 70);	
		HumanInfo info4 = new HumanInfo(new IdentityInfo("D", 23, "111111-2222225"), "감만104", 177, 80);	
		HumanInfo info5 = new HumanInfo(new IdentityInfo("E", 40, "111111-2222226"), "감만105", 160, 40);	
		HumanInfo info6 = new HumanInfo(new IdentityInfo("F", 26, "111111-2222227"), "감만106", 155, 50);	

		juminList.put(info1.infos, info1);
		juminList.put(info2.infos, info2);
		juminList.put(info3.infos, info3);
		juminList.put(info4.infos, info4);
		juminList.put(info5.infos, info5);
		juminList.put(info6.infos, info6);
	}

	public HumanInfo find(String jumin) {
		return juminList.get(new IdentityInfo(jumin));
	}
}
class HashCodeEx3 {
	public static void main(String[] args) {
		JuminCenter center = new JuminCenter();
		HumanInfo info = center.find("111111-2222226");
		System.out.println(info.infos.name);
	}
}