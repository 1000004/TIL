class Student{
	private String name;
	private int id;
	private String department;
	private int grade;
	private int completeCredits;

	public Student(String name, int id, String department, int grade, int completeCredits){
		setName(name);
		setID(id);
		setDepartment(department);
		setGrade(grade);
		setCompleteCredits(completeCredits);
	}

	public String getName(){
		return name;
	}
	public int getID(){
		return id;
	}
	public String getDepartment(){
		return department;
	}
	public int getGrade(){
		return grade;
	}
	public int getCompleteCredits(){
		return completeCredits;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setID(int id) {
		this.id = id;
	}
	public void setDepartment(String major) {
		this.department = department;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setCompleteCredits(int completeCredits) {
		this.completeCredits = completeCredits;	
	}

	@Override
	public String toString() {
		String info = "name : " + name + "\n";
		info += "id : " + id + "\n";
		info += "department : " + department + "\n";
		info += "grade : " + grade + "\n";
		info += "completeCredits : " + completeCredits + "\n";

		return info;
	}
}

class UderGraduate extends Student{
	private String ciclesName;

	public UderGraduate(String name, int id, String department, int grade, int completeCredits, String ciclesName){
		super(name, id, department, grade, completeCredits);
		setCiclesName(ciclesName);
	}

	public String getCiclesName(){
		return ciclesName;
	}
	public void setCiclesName(String ciclesName){
		this.ciclesName = ciclesName;
	}

	@Override
	public String toString(){
		return super.toString() + "cicle: " + ciclesName + "\n";
	}


	

}

class Graduate extends Student {
	public static final int EDU_TYPE = 0;
	public static final int RND_TYPE = 1;

	public static final double MIN_RATE = 0.0;
	public static final double MAX_RATE = 1.0;

	private int assType;
	private double sRate;

	public Graduate(String name, int id, String major, int grade, int credits, int assType, double sRate) {
		super(name, id, major, grade, credits);
		setAssType(assType);
		setSRate(sRate);
	}

	public int getAssType() {
		return assType;
	}
	public double getSRate() {
		return sRate;
	}
	public void setAssType(int assType) {
		if(assType != EDU_TYPE) {
			assType = RND_TYPE;
		}
		this.assType = assType;
	}
	public void setSRate(double sRate) {
		if(sRate >= MIN_RATE && sRate <= MAX_RATE) {
			this.sRate = sRate;
		}
	}

	@Override
	public String toString() {
		String info = super.toString() + "\n";
		String type = (assType == EDU_TYPE) ? "교육조교" : "연구조교";
		info += "assType : " + type + "\n";
		info += "sRate : " + sRate;

		return info;
	}
}

public class ExtendsEx4 {
	public static void main(String[] args) {
		//Student(String name, int id, String department, int grade, int completeCredits)
		System.out.println(new Student("춘식", 200000, "컴퓨터", 1, 20));
		//UderGrauate(String name, int id, String department, int grade, int completeCredits, String ciclesName)
		System.out.println(new UderGraduate("라이언", 97101147, "컴퓨터공학", 4, 140, "봉사"));
		//Grauate(tring name, int id, String department, int grade, int completeCredits, int assType, int scholarshipRate)
		System.out.println(new Graduate("아이유", 10041004, "싱어송라이터", 2, 2000, Graduate.RND_TYPE, 1.0));
	}
}