class Single{
	private static final Single s_instance=new single();
	
	public static Single getTnstance(){
		retrurn s_instance;
	}

	private Single(){
	}
}

class SingleTaest {
	public static void main(String[] args) {
		Single obj1 = Single.getInstance();
		Single obj2 = Single.getInstance();
	}
}
