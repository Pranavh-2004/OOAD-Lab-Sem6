import java.util.*;  
import java.io.IOException;

interface IMobileShop 
{
    /**
     * Mobile Model Number
     */
    public void getMobileModelNumber();

    /**
     * Mobile Price
     */
    public void getMobilePrice();
}

// Create an implementation class for the iPhone that implements the 
// IMobileShop interface.

class Iphone implements IMobileShop 
{
    @Override
    public void getMobileModelNumber() 
    {
        System.out.println("The model is: IPhone 13");
    }

    @Override
    public void getMobilePrice() 
    {
        System.out.println("The price is: 75000INR ");
    }
}

// Create an implementation class for Samsung that implements the 
// IMobileShop interface.
class Samsung implements IMobileShop 
{
    @Override
    public void getMobileModelNumber() 
    {
        System.out.println("The model is: Galaxy 11");
    }

    @Override
    public void getMobilePrice() 
    {
        System.out.println("The price is: 85000INR ");
    }
}

// Create an implementation class for Nokia that implements the IMobileShop 
// interface.

class Nokia implements IMobileShop 
{
    @Override
    public void getMobileModelNumber() 
    {
        System.out.println("The model is: Nokia 1100");
    }

    @Override
    public void getMobilePrice() 
    {
        System.out.println("The price is: 1500INR ");
    }
}

// Finally, create a concrete ShopKeeper class that uses the IMobileShop interface.

class ShopKeeper 
{
    private IMobileShop iphone;
    private IMobileShop samsung;
    private IMobileShop nokia;

    /**
     * no args constructor
     */
    public ShopKeeper() 
    {
        iphone = new Iphone();
        samsung = new Samsung();
        nokia = new Nokia();
    }

    public void iphonePhoneSale() 
    {
        iphone.getMobileModelNumber();
        iphone.getMobilePrice();
    }

    public void samsungPhoneSale() 
    {
        samsung.getMobileModelNumber();
        samsung.getMobilePrice();
    }

    public void nokiaPhoneSale() 
    {
        nokia.getMobileModelNumber();
        nokia.getMobilePrice();
    }
}



public class FacadePatternClient1 
{
    private static int choice;
    public static void main(String args[]) throws NumberFormatException, IOException
    {
	Scanner in = new Scanner(System.in);  
        do 
        {
            System.out.print("========= Mobile Shop ============ \n");
            System.out.print("1. IPHONE.              \n");
            System.out.print("2. SAMSUNG.              \n");
            System.out.print("3. NOKIA.                 \n");
            System.out.print("4. Exit.                   \n");
            System.out.print("Enter your choice: ");

            choice = in.nextInt();
            ShopKeeper shopKeeper = new ShopKeeper();

            switch (choice) 
            {
                case 1:
                    shopKeeper.iphonePhoneSale();
                break;
                case 2:
                    shopKeeper.samsungPhoneSale();
                break;
                case 3:
                    shopKeeper.nokiaPhoneSale();
                break;
                default:
                    System.out.println("You purchased nothing");
                return;
            }
        } while (choice != 4);
        in.close ();
    }
}