public class Order {
	private long orderId; // унікальний номер
	private long customerId; // ід кому продали товар
	private long employeeId;// ід продавця який продав товар
	private long[] books; // список книг які продали
	//конструктор
	public Order(long id, long customerId, long employeeId, long[] books) {
		super();
		this.orderId = id;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.books = books;
	}
	public void getBook() {
		for(int i = 0; i < books.length;i++){
			System.out.print(books[i] + " ");
		}
	}
	public void printOrderInfo(Order order) {
		System.out.print("Інформація про замовлення  : " + " ||Номер замовлення - " + order.getId() + "|| " + "||Номер продавця : " + order.getEmployeeId() + "|| " + " ||Номер покупця: " + order.getCustomerId()+ "|| ");
		System.out.print("Книги які було куплено : ");
		getBook();
		System.out.println();
		
	}
	
	
	public long getId() {
		return orderId;
	}
	public void setId(long id) {
		this.orderId = id;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long[] getBooks() {
		return books;
	}
	public void setBooks(long[] books) {
		this.books = books;
	}
	
	
	
	
}
