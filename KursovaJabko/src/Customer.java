import java.util.ArrayList;
import java.util.Comparator;

public class Customer extends Person{

	public Customer(long id, String nameString, int age) {
		super(id, nameString, age);
		
	}
	
	
	
	//отримуємо загальну ціну одного замовлення
		//повертаємо загальну ціну для всіх проданих книг в замовлені
		public static double getPriceOfSoldBooksInOrder(Order order) {
			double price = 0;
			for(long bookId: order.getBooks()) {
				Book book = Main.getBookById(bookId);
				if(book != null) {
				price+= book.getPrice();
				}
			}
			return price;
		}
		
		//отримати найбільш популярний жанр книг для покупців до віку #age
		public static BookGenre getMostPopularBookGenreLessThenAge(int age) {
			ArrayList<Long> customersIds = new ArrayList<>();
			
			for(Customer customer : Main.customers) {
				if(customer.getAge() < age) {
					customersIds.add(customer.getId());
				}
			}
			return getMostPopularBookGenre(customersIds);
		}
		
		
		
		//отримати найбільш популярний жанр книг для покупців старших віку #age
		public static BookGenre getMostPopularBookGenreMoreThenAge(int age) {
			ArrayList<Long> customersIds = new ArrayList<>();
			
			for(Customer customer : Main.customers) {
				if(customer.getAge() > age) {
					customersIds.add(customer.getId());
				}
			}
			return getMostPopularBookGenre(customersIds);
		}



		private static BookGenre getMostPopularBookGenre(ArrayList<Long> customersIds) {
			int countArt = 0,countProg = 0,countPsyh = 0, countBiol = 0, countEnglish = 0,countHist = 0;
			
			for(Order order : Main.orders) {
				if(customersIds.contains(order.getCustomerId())) {
					countArt += Book.getCountOfSoldByGenre(order, BookGenre.Art);
					countProg += Book.getCountOfSoldByGenre(order, BookGenre.Programming);
					countPsyh += Book.getCountOfSoldByGenre(order, BookGenre.Psychology);
					countBiol += Book.getCountOfSoldByGenre(order, BookGenre.Biology);
					countEnglish += Book.getCountOfSoldByGenre(order, BookGenre.English);
					countHist += Book.getCountOfSoldByGenre(order, BookGenre.History);
				}
			}
			//створюємо ще один список додаємо туди жанри і їх кількість
			ArrayList<BookAdditional> resultArrayList = new ArrayList<>();
			resultArrayList.add(new BookAdditional(BookGenre.Art, countArt));
			resultArrayList.add(new BookAdditional(BookGenre.Programming, countProg));
			resultArrayList.add(new BookAdditional(BookGenre.Psychology, countPsyh));
			resultArrayList.add(new BookAdditional(BookGenre.Biology, countBiol));
			resultArrayList.add(new BookAdditional(BookGenre.English, countEnglish));
			resultArrayList.add(new BookAdditional(BookGenre.History, countHist));
			//сортуємо масив
			resultArrayList.sort(new Comparator<BookAdditional>() {
				@Override
				public int compare(BookAdditional left,BookAdditional right) {
					return right.getCount() - left.getCount(); // сортування від найбільшого до найменшого
				}
			});
			
			return resultArrayList.get(0).getGenre(); // повертаємо перший в списку елемент. Тобто
			//самий популярний
		}
		
	
	
	
	

}
