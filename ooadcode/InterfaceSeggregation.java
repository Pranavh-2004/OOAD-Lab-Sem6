public interface UPIPayment
{
	public void payMoney();
	public void getScratchCard ();	
	public void getCashBackAsCreditBalance ();
}

// Google Pay supports all these features

public class GooglePay implements UPIPayment
{
	// Provide the bodies of all three methods
}

public class Paytm implements UPIPayment
{

	// Paytm does not support "getCashBackAsCreditBalance" feature
	// We might be forcing Paytm to implement this feature even though not required
}

// Same holds good for Phonepe



// To overcome this, we define another interface called CashBackManager
public interface UPIPayment
{
	public void payMoney();
	public void getScratchCard ();	
}

public interface CashBackManager
{
	public void getCashBackAsCreditBalance ();
}

public class GooglePay implements UPIPayment, CashBackManager
{
	// Provide the bodies of all three methods
}

public class Paytm implements UPIPayment
{
	// Provide the bodies of all three methods
}

public class Phonepe implements UPIPayment
{
	// Provide the bodies of all three methods
}
