import java.util.*;
class VectorEx2 {
	public static void findAndPrint(Vector<String> temp, String element) {
		// temp에 존재하는 모든 element의 index를 출력한다.
		/*
		int idex = 0;
		for(int i=0;i<temp.size();i++){
			int result = temp.indexOf("x",i);
			if(idex!=result){
				idex = result;
				System.out.println(idex);
			}
		}
		*/
		int index = 0;
		while(index != -1){
			index = temp.indexOf("x",index);
			if(index != -1){
				System.out.println(index);
				index++;
			}
		}
		/*
		for(int index=0;index<temp.size();index++){
			if(temp.get(index).equals(element)){
				System.out.println(index);
			}
		}
		*/
	}

	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();

		vec.add("a");
		vec.add("b");
		vec.add("x");
		vec.add("c");
		vec.add("x");
		vec.add("d");
		vec.add("e");
		vec.add("x");
		vec.add("f");
		vec.add("g");
		vec.add("h");
		vec.add("x");
		vec.add("i");
		vec.add("j");
		vec.add("k");
		vec.add("x");
		vec.add("x");
		
		findAndPrint(vec, "x");
	}
}