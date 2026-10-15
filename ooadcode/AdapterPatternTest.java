class Volt 
{

	private int volts;
	
	public Volt(int v)
        {
		this.volts=v;
	}

	public int getVolts() 
        {
		return volts;
	}

	public void setVolts(int volts) 
        {
		this.volts = volts;
	}
	
}

class Socket 
{
	public Volt getVolt()
        {
		return new Volt(120);
	}
}

// Now we want to build an adapter that can produce 3 volts, 12 volts and 
// default 120 volts. 
// So first of all we will create an adapter interface with these methods.

interface SocketAdapter 
{

	public Volt get120Volt();
		
	public Volt get12Volt();
	
	public Volt get3Volt();
}


//Using inheritance for adapter pattern
class SocketClassAdapterImpl extends Socket implements SocketAdapter{

	@Override
	public Volt get120Volt() 
        {
		return getVolt();
	}

	@Override
	public Volt get12Volt() 
        {
		Volt v= getVolt();
		return convertVolt(v,10);
	}

	@Override
	public Volt get3Volt() 
        {
		Volt v= getVolt();
		return convertVolt(v,40);
	}
	
	private Volt convertVolt(Volt v, int i) 
        {
		return new Volt(v.getVolts()/i);
	}

}

// Adapter Design Pattern - Object Adapter Implementation
// Here is the Object adapter implementation of our adapter.

class SocketObjectAdapterImpl implements SocketAdapter
{

	//Using Composition for adapter pattern
	private Socket sock = new Socket();
	
	@Override
	public Volt get120Volt() 
        {
		return sock.getVolt();
	}

	@Override
	public Volt get12Volt() 
	{
		Volt v= sock.getVolt();
		return convertVolt(v,10);
	}

	@Override
	public Volt get3Volt() 
	{
		Volt v= sock.getVolt();
		return convertVolt(v,40);
	}
	
	private Volt convertVolt(Volt v, int i) 
	{
		return new Volt(v.getVolts()/i);
	}
}

/*
Notice that both the adapter implementations are almost same and they implement the SocketAdapter interface. The adapter interface can also be an abstract class. Here is a test program to consume our adapter design pattern implementation.
*/

public class AdapterPatternTest 
{

	public static void main(String[] args) 
	{
		
		testClassAdapter();
		testObjectAdapter();
	}

	private static void testObjectAdapter() 
	{
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(sockAdapter,3);
		Volt v12 = getVolt(sockAdapter,12);
		Volt v120 = getVolt(sockAdapter,120);
		System.out.println("v3 volts using Object Adapter="+v3.getVolts());
		System.out.println("v12 volts using Object Adapter="+v12.getVolts());
		System.out.println("v120 volts using Object Adapter="+v120.getVolts());
	}

	private static void testClassAdapter() 
	{
		SocketAdapter sockAdapter = new SocketClassAdapterImpl();
		Volt v3 = getVolt(sockAdapter,3);
		Volt v12 = getVolt(sockAdapter,12);
		Volt v120 = getVolt(sockAdapter,120);
		System.out.println("v3 volts using Class Adapter="+v3.getVolts());
		System.out.println("v12 volts using Class Adapter="+v12.getVolts());
		System.out.println("v120 volts using Class Adapter="+v120.getVolts());
	}
	
	private static Volt getVolt(SocketAdapter sockAdapter, int i) 
	{
		Volt tmpVolt;
		switch (i)
		{
			case 3: 
				tmpVolt = sockAdapter.get3Volt();
			break;

			case 12: 
				tmpVolt = sockAdapter.get12Volt();
			break;

			case 120: 
				tmpVolt = sockAdapter.get120Volt();
			break;

			default: 
				tmpVolt = sockAdapter.get120Volt();
		}
		return tmpVolt;
	}
	
}