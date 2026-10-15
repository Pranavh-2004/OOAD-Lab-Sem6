import java.util.Scanner;

public class StringContainsSubstring 
{

	public static void main(String[] args) 
	{
		if (args.length == 2)
		{
			String s1 = args[0];
			String s2 = args[1];
			boolean result = stringContainsSubstring(s1, s2);
			System.out.println(s1+" contains "+s2+" = "+result);
		}
		else
			System.out.println ("Please pass two arguments");
	}

	private static boolean stringContainsSubstring(String string, String substring) {
		boolean result = false;
		result = string.contains(substring);
		return result;
	}

}
