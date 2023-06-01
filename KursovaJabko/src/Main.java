
import java.util.ArrayList;
import java.util.HashMap;



public class Main {
	
	static ArrayList<Book> books = new ArrayList<>();
	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<Employee> employees = new ArrayList<>();
	static ArrayList<Order> orders = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		setUpArray();
		
		for(Employee employee : employees) {
			System.out.println(employee.getNameString() + " продав(ла)" + Employee.getProfitEmployee(employee.getId()).toString());
		}
		
		
		System.out.println("Загальна кількість проданих книг :" + Book.getCountOfSoldBooks());
		System.out.println("Загальна сума всіх замовлень : " + getAllPricedBook());
		
		ArrayList<BookAdditional> soldBooksCount = getCountOfSoldBooksByGenre();
		HashMap<BookGenre, Double> soldBookPrices = getPriceOfSoldBooksByGenre();
		
		String soldBookString = "По жанру: %s продано %d книг загальною вартісю %f";
		
		for(BookAdditional bookAdditional : soldBooksCount) {
			double price = soldBookPrices.get(bookAdditional.getGenre());
			System.out.println(String.format(soldBookString, bookAdditional.getGenre().name(), bookAdditional.getCount(), price));
		}
		
		String analyzeGenre = "Покупці молодше %d років вибрають жанр %s";
		System.out.println(String.format(analyzeGenre, 30,Customer.getMostPopularBookGenreLessThenAge(30)));
		
		String analyzeGenre2 = "Покупці старше %d років вибрають жанр %s";
		System.out.println(String.format(analyzeGenre2, 30,Customer.getMostPopularBookGenreMoreThenAge(30)));
		
		
		
	}
	//отримали загальні кількість проданих книг по жанрах
	public static ArrayList<BookAdditional> getCountOfSoldBooksByGenre(){
		ArrayList<BookAdditional> resultArrayList = new ArrayList<>();
		int countArt = 0, countProg = 0, countPsyh = 0, countBiol = 0, countEnglish = 0, countHist = 0;
		for(Order order : orders) {
			countArt += Book.getCountOfSoldByGenre(order, BookGenre.Art);
			countProg += Book.getCountOfSoldByGenre(order, BookGenre.Programming);
			countPsyh += Book.getCountOfSoldByGenre(order, BookGenre.Psychology);
			countBiol += Book.getCountOfSoldByGenre(order, BookGenre.Biology);
			countEnglish += Book.getCountOfSoldByGenre(order, BookGenre.English);
			countHist += Book.getCountOfSoldByGenre(order, BookGenre.History);
		}
		resultArrayList.add(new BookAdditional(BookGenre.Art, countArt));
		resultArrayList.add(new BookAdditional(BookGenre.Programming, countProg));
		resultArrayList.add(new BookAdditional(BookGenre.Psychology, countPsyh));
		resultArrayList.add(new BookAdditional(BookGenre.Biology, countBiol));
		resultArrayList.add(new BookAdditional(BookGenre.English, countEnglish));
		resultArrayList.add(new BookAdditional(BookGenre.History, countHist));
		
		return resultArrayList;
	}
	
	
	//1/1отримати ціну проданих книжок по жанрах
	public static HashMap<BookGenre, Double> getPriceOfSoldBooksByGenre(){
		HashMap<BookGenre, Double> resultHashMap = new HashMap<>();
		double priceArt = 0, priceProg = 0, pricePsyh = 0, priceBiol = 0, priceEnglish = 0, priceHist = 0;
		
		for(Order order : orders) {
			priceArt += Book.getPriceOfSoldByGenre(order, BookGenre.Art);
			priceProg += Book.getPriceOfSoldByGenre(order, BookGenre.Programming);
			pricePsyh += Book.getPriceOfSoldByGenre(order, BookGenre.Psychology);
			priceBiol += Book.getPriceOfSoldByGenre(order, BookGenre.Biology);
			priceEnglish += Book.getPriceOfSoldByGenre(order, BookGenre.English);
			priceHist += Book.getPriceOfSoldByGenre(order, BookGenre.History);
			
		}
		resultHashMap.put(BookGenre.Art, priceArt);
		resultHashMap.put(BookGenre.Programming, priceProg);
		resultHashMap.put(BookGenre.Psychology, pricePsyh);
		resultHashMap.put(BookGenre.Biology, priceBiol);
		resultHashMap.put(BookGenre.English, priceEnglish);
		resultHashMap.put(BookGenre.History, priceHist);
		
		return resultHashMap;
	}
	//отримати загальну кількість  і загальну ціну проданого товару для продавця
//	public static Profit getProfitEmployee(long employeeId) {
//		int count = 0;
//		double price = 0;
//		for(Order order : orders) {
//			if(order.getEmployeeId() == employeeId) {
//				price += getPriceOfSoldBooksInOrder(order);
//				count += order.getBooks().length;
//			}
//		}
//		return new Profit(count,price); // повертаємо кількість проданого і ціну
//	}
	
	
	
	// отримуємо загальну суму всіх замовлень
	public static double getAllPricedBook() {
		double price = 0;
		for(Order order : orders) {
			price+=Customer.getPriceOfSoldBooksInOrder(order);
		}
		return price;
	}
	
	//отримуємо загальну ціну одного замовлення
	//повертаємо загальну ціну для всіх проданих книг в замовлені
//	public static double getPriceOfSoldBooksInOrder(Order order) {
//		double price = 0;
//		for(long bookId: order.getBooks()) {
//			Book book = getBookById(bookId);
//			if(book != null) {
//			price+= book.getPrice();
//			}
//		}
//		return price;
//	}
	
	
	// отримуємо кількість всіх проданих книг
//	public static int getCountOfSoldBooks() {
//		int count = 0;
//		for(Order order : orders) {
//			count+=order.getBooks().length;
//		}
//		return count;
//		
//	}
	
	//отримати книгу по її ід
	public static Book getBookById(long id) {
		Book current = null;
		
		for(Book book : books) {
			if(book.getId() == id) {
				current = book;
				break;
			}
		}
		return current;
		
	}
	
	
	public static void setUpArray() {
		//продавці
		employees.add(new Employee(1, "Максим", 22));
		employees.add(new Employee(2, "Вероніка", 17));
		employees.add(new Employee(3, "Мирослав", 42));
		
		//покупці
		customers.add(new Customer(1, "Володимир", 27));
		customers.add(new Customer(2, "Інна", 18));
		customers.add(new Customer(3, "Андрій", 23));
		customers.add(new Customer(4, "Маркіян", 37));
		customers.add(new Customer(5, "Дмитро", 27));
		
		System.out.println("********************Інформація про книги********************");
		//книжки
		Book book1 = new Book(1, "Як ходити до музею", "Йохан Идема", 450, BookGenre.Art);
		book1.printBookInfo(book1);
		books.add(book1);
		
		Book book2 = new Book(2, "Авангардне мистецтво в Україні", "Мирослава Шкандій", 550, BookGenre.Art);
		book2.printBookInfo(book2);
		books.add(book2);
		
		Book book3 = new Book(3, "Досконалий код", "Стів Макконел", 995, BookGenre.Programming);
		book3.printBookInfo(book3);
		books.add(book3);
		
		Book book4 = new Book(4, "Мистецтво програмування", "Дональт Кнут", 825, BookGenre.Programming);
		book4.printBookInfo(book4);
		books.add(book4);
		
		Book book5 = new Book(5, "Ігри в які грають люди", "Ерік Берн", 265, BookGenre.Psychology);
		book5.printBookInfo(book5);
		books.add(book5);
		
		Book book6 = new Book(6, "Витончене мистецтво забивати на все", "Ерік Берн", 202, BookGenre.Psychology);
		book6.printBookInfo(book6);
		books.add(book6);
		
		Book book7 = new Book(7, "Біологія поведінки. Причини доброго і поганого в нас", "Роберта Моріса Сапольскі", 140, BookGenre.Biology);
		book7.printBookInfo(book7);
		books.add(book7);
		
		Book book8 = new Book(8, "Походження видів", "Чарлз Дарвін", 549, BookGenre.Biology);
		book8.printBookInfo(book8);
		books.add(book8);
		
		Book book9 = new Book(9, "English Grammar in Use", "Раймонд Мерфі", 910, BookGenre.English);
		book9.printBookInfo(book9);
		books.add(book9);
		
		Book book10 = new Book(10, "Англійська мова. Граматика. Збірник вправ", " Юрій Голіцинський", 74, BookGenre.English);
		book10.printBookInfo(book10);
		books.add(book10);
		
		Book book11 = new Book(11, "Брама Європи", "Плохій Сергій Миколайович", 350, BookGenre.History);
		book11.printBookInfo(book11);
		books.add(book11);
		
		Book book12 = new Book(12, "Історія України від діда Свирида", " Свирид Опанасович", 355, BookGenre.History);
		book12.printBookInfo(book12);
		books.add(book12);
		System.out.println("********************Інформація про замовлення********************");
		
		
		
		Order order1 = new Order(1, 1, 1, new long[] {8,9,10,11});
		order1.printOrderInfo(order1);
		orders.add(order1);
		
		Order order2 = new Order(2, 2, 1, new long[] {1});
		order2.printOrderInfo(order2);
		orders.add(order2);
		
		Order order3 = new Order(3, 3, 2, new long[] {5,6,7});
		order3.printOrderInfo(order3);
		orders.add(order3);
		
		Order order4 = new Order(4, 4, 2, new long[] {1,2,3,4});
		order4.printOrderInfo(order4);
		orders.add(order4);
		
		Order order5 = new Order(5, 5, 2, new long[] {2,5,9});
		order5.printOrderInfo(order5);
		orders.add(order5);
		
		  
		
		
		
	}

}
