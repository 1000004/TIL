class Movie{
	private String title;
	private double rating;
	private String director;
	private int koreaReleaseYear;

	//getter
	public String getTitle(){
		return title;
	}
	//setter
	public void setTitle(String title){
		this.title =title;
	}

	public double getRating(){
		return rating;
	}
	public void setRating(double rating){
		this.rating = rating;
	}

	public String getDirector(){
		return director;
	}
	public void setDirector(String director){
		this.director = director;
	}
	
	public int getKoreaReleaseYear(){
		return koreaReleaseYear;
	}
	public void setKoreaReleaseYear(int koreaReleaseYear){
		this.koreaReleaseYear = koreaReleaseYear;
	}
	
	public void print(){
		String info = "Movie title \t: "+ title + "\n";
		info +="rating \t\t: "+rating+"\n";
		info +="director \t: "+director+"\n";
		info +="year \t\t: " + koreaReleaseYear;
		System.out.println(info);
	}
}

public class  JujutsukaisenMovie {
	public static void main(String[] args) {
		
		Movie m = new Movie();
		m.setTitle("jujutsu kaisen 0");
		m.setRating(9.02);
		m.setDirector("Park Sunghoo");
		m.setKoreaReleaseYear(2022);
		m.print();



	}
}