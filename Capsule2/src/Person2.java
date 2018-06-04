
public class Person2 {
	private String name = null;
	private int age = 0;

	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}

	public Person2(String name,int age){
		this.name = name;
		this.age = age;
	}
}
