class Movie{
	String title;
	double rating;
	String director;
	int koreaReleaseYear;

	void print(){
		String info = "Movie title : \t" + title + "\n";
		info +="rating : \t"+rating+"\n";
		info +="director : \t"+director+"\n";
		info +="year :    \t"+koreaReleaseYear+"\n";
		System.out.println(info);
	}
}

public class  JujutsukaisenMovie {
	public static void main(String[] args) {
		
		Movie m = new Movie();
		m.title = "jujutsu kaisen 0";
		m.rating = 9.02;
		m.director = "Park Sunghoo";
		m.koreaReleaseYear = 2022;
		m.print();



	}
}