
public class Person3 {
	public String name = null;
	public int age = 0;

	public Person3(){}

	public Person3(String name, int age){
		this.name = name;
		this.age = age;
	}
	public Person3(int age){
		this.name = "名前なし";
		this.age = age;
	}
	public Person3(int age, String name){
		this.name = name;
		this.age = age;
	}
}