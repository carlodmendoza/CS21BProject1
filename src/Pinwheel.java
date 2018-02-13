import java.awt.*;
import java.awt.geom.*;
/**
 * Class Pinwheel draws a pinwheel in a graphics 2D object made out of Line, Circle, and Triangles
 * 
 * @author Carlo Mendoza
 */
public class Pinwheel implements Shape
{
    private int x,y,rot;
    private double k;
    private Paint t1FillColor, t2FillColor, strokeColor;
    private Stroke stroke;
    
    public Pinwheel(int x, int y, Paint t1fc, Paint t2fc)
    {   this.x = x;
        this.y = y;
        rot = 1;
        k = 0;
        t1FillColor = t1fc;
        t2FillColor = t2fc;
        strokeColor = Color.BLACK;
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y-15*Math.sin(k));
        g2d.rotate(Math.toRadians(rot), 50, 85);
        Triangle t1 = new Triangle(50,50,65,70,50,85,t1FillColor,strokeColor,stroke);
        t1.draw(g2d);
        Triangle t2 = new Triangle(50,85,65,70,65,85,t2FillColor,strokeColor,stroke);
        t2.draw(g2d);
        g2d.rotate(Math.toRadians(90), 50, 85);
        t1.draw(g2d);
        t2.draw(g2d);
        g2d.rotate(Math.toRadians(90), 50, 85);
        t1.draw(g2d);
        t2.draw(g2d);
        g2d.rotate(Math.toRadians(90), 50, 85);
        t1.draw(g2d);
        t2.draw(g2d);
        Circle c = new Circle(45,80,5,Color.YELLOW,Color.BLACK,stroke);
        c.draw(g2d);
    }
    
    public void animate()
    {
       rot+=3;
       k+=0.04;
    }
}
