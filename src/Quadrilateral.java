import java.awt.*;
import java.awt.geom.*;
/**
 * Class Quadrilateral draws a quadrilateral in a graphics 2D object
 * 
 * @author Carlo Mendoza
 */
public class Quadrilateral implements Shape
{
    private double x1,y1,x2,y2,x3,y3,x4,y4;
    private Paint fillColor,strokeColor;
    private Stroke stroke;

    public Quadrilateral(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, Paint fc, Paint sc, Stroke st)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        fillColor = fc;
        strokeColor = sc;
        stroke = st;
    }

    public void draw(Graphics2D g2d)
    {
		Path2D.Double quadrilateral = new Path2D.Double();
		quadrilateral.moveTo(x1,y1);
		quadrilateral.lineTo(x2,y2);
		quadrilateral.lineTo(x3,y3);
		quadrilateral.lineTo(x4,y4);
		quadrilateral.closePath();
		g2d.setPaint(fillColor);
		g2d.fill(quadrilateral);
		g2d.setPaint(strokeColor);
		g2d.setStroke(stroke);
		g2d.draw(quadrilateral);
    }
    
    public void animate()
    {
        
    }
}
