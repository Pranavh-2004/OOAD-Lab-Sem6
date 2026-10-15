// This program will find common elements from the integer array.

import java.util.Arrays;

public class ArrayCommonInteger
{
	public static void main(String[] args) 
	{
		// take default integer value.
		int[] array1 = {1993,1995,2000,2006,2017,2020};
		int[] array2 = {1990,1993,1995,2010,2016,2017};

		// print the entered value.
		System.out.println("Array1 : "+Arrays.toString(array1));
		System.out.println("Array2 : "+Arrays.toString(array2));


		for (int i = 0; i < array1.length; i++)
		{
			for (int j = 0; j < array2.length; j++)
			{
				if(array1[i] == (array2[j]))
				{
					// return common integer value.
					System.out.println("Common element is : "+(array1[i]));
				}
			}
		}
	}
}
