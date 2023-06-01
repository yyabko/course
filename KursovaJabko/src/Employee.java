

public class Employee extends Person{

	public Employee(long id, String nameString, int age) {
		super(id, nameString, age);
		
	}
	
	
	//отримати загальну кількість  і загальну ціну проданого товару для продавця
	public static Profit getProfitEmployee(long employeeId) {
		int count = 0;
		double price = 0;
		for(Order order : Main.orders) {
			if(order.getEmployeeId() == employeeId) {
				price += Customer.getPriceOfSoldBooksInOrder(order);
				count += order.getBooks().length;
			}
		}
		return new Profit(count,price); // повертаємо кількість проданого і ціну
	}
	
	
	

}
