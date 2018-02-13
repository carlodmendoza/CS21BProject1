import java.awt.*;
import java.awt.geom.*;
/**
 * Class Line draws a line in a graphics 2D object
 * 
 * @author Carlo Mendoza
 */
public class Line implements Shape
{
    private double x1,y1,x2,y2,k;
    private Paint strokeColor;
    private Stroke stroke;

    public Line(double x1, double y1, double x2, double y2, Paint sc, Stroke st)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        k = 0;
        strokeColor = sc;
        stroke = st;
    }

    public void draw(Graphics2D g2d)
    {
		Line2D.Double line = new Line2D.Double(x1,y1-15*Math.sin(k),x2,y2);
		g2d.setPaint(strokeColor);
		g2d.setStroke(stroke);
		g2d.draw(line);
    }
    
    public void animate()
    {
        k+=0.04;
    }
}
