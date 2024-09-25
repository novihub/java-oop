package AbstractSuperclassAnimalAndItsImplementationSubclasses6_6ex;

public class Main {
	public static void main(String[] args) {
		Animal a = new Animal("Pluto") {
			@Override
			public void greets() {
				System.out.println("Animal greets");
			}
		};
		a.greets();

		Dog d = new Dog("Fido");
		d.greets();
		d.greets(d);

		BigDog e = new BigDog("Max");
		e.greets();
		e.greets(d);
		e.greets(e);

		Animal a1 = new Dog("A");
		a1.greets();
		Animal a2 = new BigDog("B");
		a2.greets();
		Animal a3 = new Cat("C");
		a3.greets();
	}
}

abstract class Animal {
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public abstract void greets();
}

class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public void greets() {
		System.out.println("Meow");
	}
}

class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void greets() {
		System.out.println("Woof");
	}

	public void greets(Dog another) {
		System.out.println("Woooof");
	}

}

class BigDog extends Dog {


	public BigDog(String name) {
		super(name);
	}

	@Override
	public void greets() {
		System.out.println("Wooow");
	}

	public void greets(Dog another) {
		System.out.println("Wooooooow");
	}

	public void greets(BigDog another) {
		System.out.println("Woooooooooooow");
	}
}