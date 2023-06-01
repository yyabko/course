
public class BookAdditional {
//доповнення до книги в ArrayList можна передавати лише один елмент тому юзайм це. А можна було
//через HashMap зробити	
	private BookGenre genre;
	private int count;
	public BookAdditional(BookGenre genre, int count) {
		super();
		this.genre = genre;
		this.count = count;
	}
	
	public BookGenre getGenre() {
		return genre;
	}
	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
