public class CountNumberOfWordsInString 
{

	public static void main(String[] args) 
	{
		if (args.length == 1)
		{
			String inpStr = args[0];
			countNumberOfWords(inpStr);
		}
		else
			System.out.println ("Please pass string as an argument");
	}

	private static void countNumberOfWords(String line) 
	{
		//System.out.println(line.split(" ").length); //won't work with tabs and multiple spaces

		// Remove white spaces from both ends of the string
		
		String trimmedLine = line.trim();
		int count = trimmedLine.isEmpty() ? 0 : 
				trimmedLine.split("\\s+").length;
		
		System.out.println(count);
	}

}