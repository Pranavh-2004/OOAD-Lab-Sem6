import java.util.Scanner;

// Create a class Currency that will store the amount to dispense and used by the 
// chain implementations. 

class Currency 
{

	private int amount;
	
	public Currency(int amt)
	{
		this.amount=amt;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
}

/* The base interface should have a method to define the next processor in the chain and the method that will process the request. Our ATM Dispense interface will look like below.
*/
interface DispenseChain 
{

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}

/* need to create different processor classes that will implement the DispenseChain interface and provide implementation of dispense methods. Since we are developing our system to work with three types of currency bills - 50$, 20$ and 10$, we will create three concrete implementations.
*/

class Dollar50Dispenser implements DispenseChain 
{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) 
	{
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) 
	{
		if(cur.getAmount() >= 50)
		{
			int num = cur.getAmount()/50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing "+num+" 50$ note");
			if(remainder !=0) 
				this.chain.dispense(new Currency(remainder));
		}
		else
		{
			this.chain.dispense(cur);
		}
	}

}

class Dollar20Dispenser implements DispenseChain
{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) 
	{
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) 
	{
		if(cur.getAmount() >= 20)
		{
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" 20$ note");
			if(remainder !=0) 
				this.chain.dispense(new Currency(remainder));
		}
		else
		{
			this.chain.dispense(cur);
		}
	}

}

class Dollar10Dispenser implements DispenseChain 
{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) 
	{
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) 
	{
		if(cur.getAmount() >= 10)
		{
			int num = cur.getAmount()/10;
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing "+num+" 10$ note");
			if(remainder !=0) 
				this.chain.dispense(new Currency(remainder));
		}
		else
		{
			this.chain.dispense(cur);
		}
	}

}

/* The important point to note here is the implementation of dispense method. You will notice that every implementation is trying to process the request and based on the amount, it might process some or full part of it. If one of the chain not able to process it fully, it sends the request to the next processor in chain to process the remaining request. If the processor is not able to process anything, it just forwards the same request to the next chain.
*/

public class ATMDispenseChain 
{

	private DispenseChain c1;

	public ATMDispenseChain() 
	{
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) 
	{
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while (true) 
		{
			int amount = 0;
			System.out.print("Enter amount to dispense: ");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) 
			{
				System.out.println("Amount should be in multiples of 10s.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}

	}

}