import java.awt.*;
import java.awt.geom.*;
/**
 * Class Oval draws an oval in a graphics 2D object
 * 
 * @author Carlo Mendoza
 */
public class Oval implements Shape
{
    private double x,y,width,height;
    private Paint fillColor,strokeColor;
    private Stroke stroke;

    public Oval(double x, double y, double width, double height, Paint fc, Paint sc, Stroke st)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        fillColor = fc;
        strokeColor = sc;
        stroke = st;
    }

    public void draw(Graphics2D g2d)
    {
		Ellipse2D.Double oval = new Ellipse2D.Double(x,y,width,height);
		g2d.setPaint(fillColor);
		g2d.fill(oval);
		g2d.setPaint(strokeColor);
		g2d.setStroke(stroke);
		g2d.draw(oval);
    }
    
    public void animate()
    {
        
    }
}
