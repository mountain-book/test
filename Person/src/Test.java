/**
 *
 */

/**
 * @author internousdev
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person kimura = new Person();
		Person suzuki = new Person();
		Person yamamoto = new Person();
		Robot aibo = new Robot();
		Robot asimo = new Robot();
		Robot pepper = new Robot();
		Robot doraemon = new Robot();

		kimura.name = "木村次郎";
		kimura.age = 18;

		suzuki.name = "鈴木花子";
		suzuki.age = 16;

		yamamoto.name = "山本哲平";
		yamamoto.age = 24;

		aibo.name = "aibo";

		asimo.name = "asimo";

		pepper.name = "pepper";

		doraemon.name = "doraemon";

		System.out.println(kimura.name);
		System.out.println(kimura.age);
		kimura.talk();
		kimura.walk();
		kimura.run();

		System.out.println(suzuki.name);
		System.out.println(suzuki.age);
		suzuki.talk();
		suzuki.walk();
		suzuki.run();

		System.out.println(yamamoto.name);
		System.out.println(yamamoto.age);
		yamamoto.talk();
		yamamoto.walk();
		yamamoto.run();

		aibo.talk();
		aibo.walk();
		aibo.run();

		asimo.talk();
		asimo.walk();
		asimo.run();

		pepper.talk();
		pepper.walk();
		pepper.run();

		doraemon.talk();
		doraemon.walk();
		doraemon.run();
	}

}
