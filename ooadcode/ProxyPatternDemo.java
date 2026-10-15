// Step 1: Define the Subject interface
interface Image 
{
    void display();
}

// Step 2: RealSubject - the actual heavy object
class RealImage implements Image 
{
    private String filename;

    public RealImage(String filename) 
    {
        this.filename = filename;
        loadFromDisk(); // Expensive operation
    }

    private void loadFromDisk() 
    {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() 
    {
        System.out.println("Displaying image: " + filename);
    }
}

// Step 3: Proxy - controls access to RealImage
class ProxyImage implements Image 
{
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) 
    {
        this.filename = filename;
    }

    @Override
    public void display() 
    {
        // Lazy initialization: load only when needed
        if (realImage == null) 
        {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Step 4: Client code
public class ProxyPatternDemo 
{
    public static void main(String[] args) 
    {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded only when display() is called
        image1.display(); // Loads and displays
        image1.display(); // Displays without loading again

        image2.display(); // Loads and displays
    }
}