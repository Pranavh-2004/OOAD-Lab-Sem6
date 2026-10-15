public class RemoveCharFromString 
{

	public static void main(String[] args) 
	{
		if (args.length == 2)
		{
			String srceStr = args[0];
			char remChar = args[1].charAt (0);
			removeCharFromString(srceStr, remChar);
		}
		else
			System.out.println ("You need to pass string and the character as arguments");
	}

	private static void removeCharFromString(String input, char c) 
	{
		String result = input.replaceAll(String.valueOf(c), "");
		System.out.println(result);
	}

}