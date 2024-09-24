package SuperclassAnimalAndItsSubclasses4_6ex;

public class Main {
	public static void main(String[] args) {
		// Testing Animal class
		Animal animal = new Animal("Generic Animal");
		System.out.println(animal); // Output: Animal[name=Generic Animal]

		// Testing Mammal class
		Mammal mammal = new Mammal("Generic Mammal");
		System.out.println(mammal); // Output: Mammal[Animal[name=Generic Mammal]]

		// Testing Cat class
		Cat cat = new Cat("Whiskers");
		System.out.println(cat); // Output: Cat[Mammal[Animal[name=Whiskers]]]
		cat.greets(); // Output: Meow

		// Testing Dog class
		Dog dog1 = new Dog("Buddy");
		Dog dog2 = new Dog("Rex");
		System.out.println(dog1); // Output: Dog[Mammal[Animal[name=Buddy]]]
		dog1.greets(); // Output: Woof
		dog1.greets(dog2); // Output: Woooof
	}
}

class Animal {
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Animal[name=" + name + "]";
	}

}

class Mammal extends Animal {

	public Mammal(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Mammal[Animal[name=" + super.getName() + "]]";
	}

}

class Cat extends Mammal {

	public Cat(String name) {
		super(name);
	}

	public void greets() {
		System.out.println("Meow");
	}

	@Override
	public String toString() {
		return "Cat[Mammal[Animal[name=" + super.getName() + "]]]";
	}

}

class Dog extends Mammal {

	public Dog(String name) {
		super(name);
	}

	public void greets() {
		System.out.println("Woof");
	}

	public void greets(Dog another) {
		System.out.println("Woooof");
	}

	@Override
	public String toString() {
		return "Dog[Mammal[Animal[name=" + super.getName() + "]]]";
	}
}