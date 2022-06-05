/*
  Object 형으로 받으면 알아서 autoBoxing, unBoxing이 되는듯.
	... 을 사용했기 때문에 파라메터의 갯수는 유동적 0개 이상
	... 파라미터는 반드시 마지막 부분의 인수가 되어야 한다.
*/
class Book {
	private String title;
	private String author;
	private int pages;

	public Book(String title, String author, int pages) {
		setTitle(title);
		setAuthor(author);
		setPages(pages);
	}

	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPages() {
		return pages;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return title + "(" + author + ", " + pages + ")";
	}
}
class Bookcase {
	private Book[] books;
	private String category;

	public Bookcase(String category, Book... books) {
		setCategory(category);
		setBooks(books);
	}

	public Book[] getBooks() {
		return books;
	}
	public String getCategory() {
		return category;
	}
	public void setBooks(Book... books) {
		this.books = books;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		String info = "[" + category + "]\n";
		for(Book temp : books) {
			info += temp + "\n";
		}

		return info;
	}
}
class Bookstore {
	private String name;
	private String tel;
	private Bookcase[] cases;

	public Bookstore(String name, String tel, Bookcase... cases) {
		setName(name);
		setTel(tel);
		setCases(cases);
	}

	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public Bookcase[] getCases() {
		return cases;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setCases(Bookcase... cases) {
		this.cases = cases;
	}

	@Override
	public String toString() {
		String info = "<< " + name + ">>\n";
		info += "- tel : " + tel + "\n";
		for(Bookcase temp : cases) {
			info += temp + "\n";
		}

		return info;
	}
}


class VariableArgumentsEx {
	public static void main(String[] args) {
		Book b1 = new Book("마법소녀 은퇴합니다", "박서련", 120);
		Book b2 = new Book("지구가 죽으면 달은 누굴 돌지?", "김혜순", 70);
		Book b3 = new Book("작별인사", "김영하", 200);

		Bookcase case1 = new Bookcase("소설", b1, b2, b3);
		Bookcase case2 = new Bookcase(
			"IT",
			new Book("파워자바", "천인국", 754),
			new Book("울트라자바", "만인국", 900),
			new Book("슈퍼하이퍼자바", "억인국", 1300)
		);

		Bookstore store = new Bookstore("그린서점", "051-912-1000",	case1, case2);

		System.out.println(store);
	}
}
