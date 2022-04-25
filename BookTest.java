  class Book{
        private String title;
        private String author;
    
        public String getTitle(){
            return title;
        }
        public String getAuthor(){
            return author;
        }
    
        public void setTitle(String title ){
            this.title = title;
        }
        public void setAuthor(String author){
            this.author = author;
        }
        
        public String toString(){
            return "Title : "+title+"\nAuthor: "+author+"\n";
        }
    }
    
    public class  BookTest {
        public static void main(String[] args) {
            Book b = new Book();
            b.setTitle("Third Humanity cycle");
            b.setAuthor("Bernard Werber");
            System.out.print(b);
            
    
    
        }
    }
