// Abstract product interfaces

interface Button 
{
    void paint();
}

interface Checkbox 
{
    void paint();
}

// Concrete produts

class WindowsButton implements Button 
{
    public void paint() 
    {
        System.out.println("Rendered Windows Button");
    }
}

class MacButton implements Button 
{
    public void paint() 
    {
        System.out.println("Rendered Mac Button");
    }
}

class WindowsCheckbox implements Checkbox 
{
    public void paint() 
    {
        System.out.println("Rendered Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox 
{
    public void paint() 
    {
        System.out.println("Rendered Mac Checkbox");
    }
}

// Abstract factory
interface GUIFactory 
{
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factories
class WindowsFactory implements GUIFactory 
{
    public Button createButton() 
    {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory 
{
    public Button createButton() 
    {
        return new MacButton();
    }

    public Checkbox createCheckbox() 
    {
        return new MacCheckbox();
    }
}


// The client code
class Application 
{
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) 
    {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() 
    {
        button.paint();
        checkbox.paint();
    }
}

// Application Runner
public class AbsFactoryDemo 
{
    public static void main(String[] args) 
    {
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) 
        {
            factory = new MacFactory();
        } 
        else 
        {
            factory = new WindowsFactory();
        }

        Application app = new Application(factory);
        app.render();
    }
}