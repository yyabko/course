
public class Book extends Main{
	private long id; // унікальний номер
	private String title; // назва книжки
	private String authorString;// автор книги
	private double price; // ціна книжки
	private BookGenre genre; // жанри книжок
	//конструктор
	public Book(long id, String title, String authorString, double price, BookGenre genre) {
		super();
		this.id = id;
		this.title = title;
		this.authorString = authorString;
		this.price = price;
		this.genre = genre;
	}
	
	public Book() {
		
	}
	// отримуємо кількість всіх проданих книг
	public static int getCountOfSoldBooks() {
		int count = 0;
		for(Order order : orders) {
			count+=order.getBooks().length;
		}
		return count;
		
	}
	
	//1/1отримати загальну кількість  книг в одному замовленні по одному жанрі
		//кількість книг
		public static int getCountOfSoldByGenre(Order order, BookGenre genre) {
			int count = 0;
			for(long bookId: order.getBooks()) {
				Book book = getBookById(bookId);
				if(book != null && book.getGenre() == genre) {
				count++;
				}
			}
			return count;
		}
	
	
	
	//1/1отримати загальну суму книг в одному замовленні по одному жанрі
	//отримуємо загальну ціну
	public static double getPriceOfSoldByGenre(Order order, BookGenre genre) {
		double price = 0;
		for(long bookId: order.getBooks()) {
			Book book = getBookById(bookId);
			if(book != null && book.getGenre() == genre) {
			price+= book.getPrice();
			}
		}
		return price;
	}
	
	
	
	public void printBookInfo(Book book) {
		System.out.println("Інформація про книгу : " + " ||id - " + book.getId() + "|| " + "||Назва : " + book.getTitle() + "|| " + " ||Автор : " + book.getAuthorString() + "|| " + " || Ціна :" + book.getPrice() +"|| " + " ||Жанр :" + book.getGenre() + "||");
		
	}
	
	
	
	//getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorString() {
		return authorString;
	}
	public void setAuthorString(String authorString) {
		this.authorString = authorString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BookGenre getGenre() {
		return genre;
	}
	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}
	
	
	

}
