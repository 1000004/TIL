class StringLoop {
	public static void answer1(String str){
		boolean flag = true;
		int idx = 0;
		while(flag){
			idx = str.indexOf(" ",idx);
			if(idx == -1){
				idx = str.length();
				flag = false;
			}
			System.out.println(str.substring(0, idx));
			idx++;
		}
	}
	public static void answer2(String str){
		boolean flag = true;
		int idx = str.length()-1;
		while(flag){
			idx = str.lastIndexOf(" ",idx);
			if(idx == -1){
				idx = 0;
				flag = false;
			}else{
				idx++;
			}
			System.out.println(str.substring(idx));
			idx -= 2;
		}
	}
	public static void answer3(String str){
		int start = 0;
		int end = 0;
		boolean flag = true;
		while(flag){
			end = str.indexOf(" ",start);
			if(end == -1){
				flag = false;
				end = str.length();
			}
			System.out.println(str.substring(start, end));
			start = end + 1;
		}
	}
	public static void answer4(String str){
		int start = str.length();
		int end = str.length();
		boolean flag = true;
		while(flag){
			start = str.lastIndexOf(" ", start -1);
			if(start == -1){
				flag = false;
			}
			System.out.println(str.substring(start+1,end));
			end = start;
			start--;
		}
	}
	public static void main(String[] args) {
		String str = "태산이 높다하되 하늘 아래 뫼이로다.";
		answer1(str);
		System.out.println();
		answer2(str);
		System.out.println();
		answer3(str);
		System.out.println();
		answer4(str);

	}
}
