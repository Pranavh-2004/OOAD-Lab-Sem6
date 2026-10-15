public class FinalizeExample 
{
	@Override
	protected void finalize() throws Throwable 
	{
		System.out.println("Finalize method called");
		// Cleanup code
	}

	public static void main(String[] args) 
	{
		FinalizeExample obj = new FinalizeExample();
		obj = null;
		System.gc(); // Requesting garbage collection
	}
}