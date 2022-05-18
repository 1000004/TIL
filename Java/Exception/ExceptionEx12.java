class Human {
	private String name;
	private boolean mintLike;

	public Human(String name, boolean mintLike) {
		setName(name);
		setMintLike(mintLike);
	}

	public String getName() {
		return name;
	}
	public boolean isMintLike() {
		return mintLike;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setMintLike(boolean mintLike) {
		this.mintLike = mintLike;
	}
	// 전가한다.
	public void eat(Mint m) throws NoMintException {
		if(mintLike) {
			System.out.println("맛있어");
		} else {
			// 발생시킨다.
			throw new NoMintException("반민초단");
		}
	}
}
class Mint{
}
class MintIceCream extends Mint{
}
class NoMintException extends Exception {
	public NoMintException() {
		super("민초를 싫어합니다");
	}
	public NoMintException(String msg) {
		super(msg);
	}
}
class ExceptionEx12 {
	public static void main(String[] args) {
		Human h1 = new Human("A", true);
		Human h2 = new Human("B", false);
		Human h3 = new Human("C", false);
		MintIceCream m = new MintIceCream();
		try {
			h1.eat(m);
		} catch(NoMintException e) {
			System.out.println(e.getMessage());
		}
		try {
			h2.eat(m);
		} catch(NoMintException e) {
			e.printStackTrace();
		}
		try {
			h3.eat(m);
		} catch(NoMintException e) {
			System.out.println("먹을 수 있어");
		}
	}
}