/* 
In this example, we are building a Paint Brush application where client can use brushes of three types – THICK, THIN and MEDIUM. All the thick (thin or medium) brushes will draw the content in exact similar fashion – only the content color will be different.
*/

interface Pen 
{
    void setColor(String color);
    void draw(String content);
}

enum BrushSize 
{
    THIN, MEDIUM, THICK
}

class ThickPen implements Pen 
{
    final BrushSize brushSize = BrushSize.THICK; // intrinsic
    private String color;                        // extrinsic

    @Override
    public void setColor(String color) 
    {
        this.color = color;
    }

    @Override
    public void draw(String content) 
    {
        System.out.println("Drawing THICK content in color : " + color);
    }
}

class ThinPen implements Pen 
{
    final BrushSize brushSize = BrushSize.THIN;
    private String color;

    @Override
    public void setColor(String color) 
    {
        this.color = color;
    }

    @Override
    public void draw(String content) 
    {
        System.out.println("Drawing THIN content in color : " + color);
    }
}

class MediumPen implements Pen 
{
    final BrushSize brushSize = BrushSize.MEDIUM;
    private String color;

    @Override
    public void setColor(String color) 
    {
        this.color = color;
    }

    @Override
    public void draw(String content) 
    {
        System.out.println("Drawing MEDIUM content in color : " + color);
    }
}

/**
 * We pre-create pens for each size and reuse them.
 */
class PenFactory 
{
    private static final Pen thickPen = new ThickPen();
    private static final Pen thinPen = new ThinPen();
    private static final Pen mediumPen = new MediumPen();

    public static Pen getPen(BrushSize size, String color) 
    {
        Pen pen;
        switch (size) 
        {
            case THIN:   
		pen = thinPen; 
	    break;
            case MEDIUM: 
	    	pen = mediumPen; 
	    break;
            case THICK:  
	        pen = thickPen; 
	    break;
            default: 
		throw new IllegalArgumentException("Unknown size");
        }
        pen.setColor(color); // extrinsic state supplied by client
        return pen;
    }
}

// Test program
public class PaintBrushClient 
{
    public static void main(String[] args) 
    {
        Pen yellowThickPen1 = PenFactory.getPen(BrushSize.THICK, "YELLOW");
        yellowThickPen1.draw("Hello World !!");

        Pen yellowThickPen2 = PenFactory.getPen(BrushSize.THICK, "YELLOW");
        yellowThickPen2.draw("Hello Again !!");

        Pen blueThickPen = PenFactory.getPen(BrushSize.THICK, "BLUE");
        blueThickPen.draw("Different Color !!");

        System.out.println(yellowThickPen1.hashCode());
        System.out.println(yellowThickPen2.hashCode());
        System.out.println(blueThickPen.hashCode());
    }
}