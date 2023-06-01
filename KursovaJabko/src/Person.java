

public class Person {
	private long id; // унікальний номер
	private String nameString; // ім'я людини
	private int age;//вік людини
	//конструктор
	public Person(long id, String nameString, int age) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.age = age;
	}
	
	//getter and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	

}
