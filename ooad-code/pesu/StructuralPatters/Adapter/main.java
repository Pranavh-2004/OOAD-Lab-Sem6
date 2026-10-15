//Java implementation of Adapter pattern

interface Bird
{
	// birds implement Bird interface that allows
	// them to fly and make sounds adaptee interface
	public void fly();
	public void makeSound();
}

class Sparrow implements Bird
{
	// a concrete implementation of bird
	public void fly()
	{
		System.out.println("Flying");
	}
	public void makeSound()
	{
		System.out.println("Chirp Chirp");
	}
}

interface ToyDuck
{
	// target interface
	// toyducks dont fly they just make
	// squeaking sound
	public void squeak(int i);
}

class PlasticToyDuck implements ToyDuck
{
	
	public void squeak(int i)
	{
		System.out.println("squeak");
		}
}

class BirdAdapter implements ToyDuck
{
	// You need to implement the interface your
	// client expects to use.
	Bird bird;
	public BirdAdapter(Bird bird)
	{
		// we need reference to the object we
		// are adapting
		this.bird = bird;
	}

	public void squeak(int i)
	{
		// translate the methods appropriately
		bird.makeSound();
	}
}

class main
{
	public static void main(String args[])
	{
		Sparrow sparrow = new Sparrow();
		ToyDuck toyDuck = new PlasticToyDuck();

		System.out.println("Sparrow...");
		sparrow.fly();
		sparrow.makeSound();

		System.out.println("ToyDuck...");
		toyDuck.squeak(1);
		//toyDuck.squeak(2);

		// Wrap a bird in a birdAdapter so that it
		// behaves like toy duck
		ToyDuck birdAdapter = new BirdAdapter(sparrow);
		System.out.println("BirdAdapter...");
		birdAdapter.squeak(1);
	}
}


