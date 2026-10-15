// Code to explain the Dependency Inversion Principle

public class CreditCard
{
	public void doTransaction (long amount)
	{
		System.out.println ("Payment through CreditCard");
	}
}

public class DebitCard
{
	public void doTransaction (long amount)
	{
		System.out.println ("Payment through DebitCard");
	}
}



public class ShoppingMall
{
	private DebitCard debitCard;
	public ShoppingMall (DebitCard debitCard)
	{
		this.debitCard = debitCard;
	}
	
	public void doPurchaseSomething (long amount)
	{
		debitCard.doTransaction (amount);
	}

	public static void main (String args[])
	{
		DebitCard debitCard = new DebitCard();
		ShoppingMall shoppingMall = new ShoppingMall (debitCard);
		shoppingMall.doPurchaseSomething (5000);
	}
}



// In the above implementation ShoppingMall is tightly coupled with DebitCard


// Now, if we want to use CreditCard, we need to have another implementation

public class ShoppingMall
{
	private CreditCard creditCard;
	public ShoppingMall (CreditCard creditCard)
	{
		this.creditCard = creditCard;
	}
	
	public void doPurchaseSomething (long amount)
	{
		creditCard.doTransaction (amount);
	}

	public static void main (String args[])
	{
		CreditCard creditCard = new CreditCard();
		ShoppingMall shoppingMall = new ShoppingMall (creditCard);
		shoppingMall.doPurchaseSomething (5000);
	}
}

// Just to change the payment method, we need to make lot of changes in the code

// The above code does not follow the Dependency Inversion Principle

// How do you make sure you follow DIP?
public interface BankCard
{
	public void doTransaction (long amount);
}

public class CreditCard implements BankCard
{
	public void doTransaction (long amount)
	{
		System.out.println ("Payment through CreditCard");
	}
}

public class DebitCard implements BankCard
{
	public void doTransaction (long amount)
	{
		System.out.println ("Payment through DebitCard");
	}
}

public class ShoppingMall
{
	private BankCard bankCard;
	public ShoppingMall (BankCard bankCard)
	{
		this.bankCard = bankCard;
	}
	
	public void doPurchaseSomething (long amount)
	{
		bankCard.doTransaction (amount);
	}

	public static void main (String args[])
	{
		BankCard bankCard = new CreditCard(); // or new DebitCard ();
		ShoppingMall shoppingMall = new ShoppingMall (bankCard);
		shoppingMall.doPurchaseSomething (5000);
	}
}