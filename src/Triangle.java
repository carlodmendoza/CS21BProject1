import java.awt.*;
import java.awt.geom.*;
/**
 * Class Triangle draws a triangle in a graphics 2D object
 * 
 * @author Carlo Mendoza
 */
public class Triangle implements Shape
{
    private double x1,y1,x2,y2,x3,y3;
    private Paint fillColor,strokeColor;
    private Stroke stroke;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Paint fc, Paint sc, Stroke st)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        fillColor = fc;
        strokeColor = sc;
        stroke = st;
    }

    public void draw(Graphics2D g2d)
    {
		Path2D.Double triangle = new Path2D.Double();
		triangle.moveTo(x1,y1);
		triangle.lineTo(x2,y2);
		triangle.lineTo(x3,y3);
		triangle.lineTo(x1,y1);
		triangle.closePath();
		g2d.setPaint(fillColor);
		g2d.fill(triangle);
		g2d.setPaint(strokeColor);
		g2d.setStroke(stroke);
		g2d.draw(triangle);
    }
    
    public void animate()
    {
        
    }
}
