class SwitchString
{

    public static void main (String args[])
    {
	String result;
	for (int i = 0; i < args.length; i ++)
        {
	    result = exampleOfSwitch (args[i]);
	    System.out.println (result);
	}
    }
		
    static String exampleOfSwitch(String animal) 
    {
        String result;
        switch (animal) 
        {
            case "DOG":
                result = "domestic animal"; 
            break;
            case "CAT":
                result = "domestic animal";
            break;
            case "TIGER":
                result = "wild animal";
            break;
            default:
                result = "unknown animal";
            break;
        }
        return result;
    }
}