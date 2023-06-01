
public class Profit {
	private int count; // кількість проданого товару
	private double price;//загальна сума
	
	public Profit(int count, double price) {
		super();
		this.count = count;
		this.price = price;
	}
	
	
	
	public Profit(int count) {
		super();
		this.count = count;
	}



	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	//переоприділили toString()
	@Override
	public String toString() {
		return " загалом " + count + ", книг на суму: " + price;
	}
	
	
	
	
}
