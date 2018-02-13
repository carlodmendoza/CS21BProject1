import java.awt.*;
import java.awt.geom.*;
/**
 * Class Square draws a square in a graphics 2D object
 * 
 * @author Carlo Mendoza
 */
public class Square implements Shape
{
    private double x,y,side;
    private Paint fillColor,strokeColor;
    private Stroke stroke;

    public Square(double x, double y, double s, Paint fc, Paint sc, Stroke st)
    {
        this.x = x;
        this.y = y;
        side = s;
        fillColor = fc;
        strokeColor = sc;
        stroke = st;
    }

    public void draw(Graphics2D g2d)
    {
		Rectangle2D.Double square = new Rectangle2D.Double(x,y,side,side);
		g2d.setPaint(fillColor);
		g2d.fill(square);
		g2d.setPaint(strokeColor);
		g2d.setStroke(stroke);
		g2d.draw(square);
    }
    
    public void animate()
    {
        
    }
}
