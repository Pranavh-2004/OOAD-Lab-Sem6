public class PalindromeString 
{

	public static void main(String[] args) 
	{
		if (args.length > 0)
		{
			for (int i = 0; i < args.length; i ++)
				checkPalindromeString(args[i]);
		}
		else
			System.out.println ("Please pass strings as arguments");
	}

	private static void checkPalindromeString(String input) 
	{
		boolean result = true;
		int length = input.length();
		for(int i=0; i < length/2; i++) 
		{
			if(input.charAt(i) != input.charAt(length-i-1)) 
			{
				result = false;
				break;
			}
		}
		System.out.println(input + " is palindrome = "+result);
		
	}

}