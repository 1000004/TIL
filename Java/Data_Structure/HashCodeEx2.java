class Some {
	@Override
	public String toString() {
		return "Some";
	}
}
class HashCodeEx2 {
	public static void main(String[] args) {
		Some s1 = new Some();
		Some s2 = new Some();
		
		// Object의 hashCode는 주소를 리턴한다.
		int s1Code = s1.hashCode();
		int s2Code = s2.hashCode();

		System.out.println("s1 hashCode : " + s1Code);
		System.out.println("s2 hashCode : " + s2Code);

		System.out.println("s1 hashCode(Hex) : " + Integer.toHexString(s1Code));
		System.out.println("s2 hashCode(Hex) : " + Integer.toHexString(s2Code));

		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);

		// 객체의 주소값을 구할 수 있다.(10진수)
		System.out.println("s1 address : " + System.identityHashCode(s1));
	}
}