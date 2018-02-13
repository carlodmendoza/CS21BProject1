import java.awt.*;
import java.awt.geom.*;
/**
 * Class Smoke draws a smoke in a graphics 2D object
 * 
 * @author Carlo Mendoza
 */
public class Smoke implements Shape
{
    private int x,y;
    private Paint strokeColor;
    private Stroke stroke;

    public Smoke(int x, int y)
    {
        this.x = x;
        this.y = y;
        strokeColor = Color.darkGray;
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        Path2D.Double smoke = new Path2D.Double();
        smoke.moveTo(375,360);
        smoke.curveTo(380,355,370,350,375,345);
        g2d.setPaint(strokeColor);
        g2d.setStroke(stroke);
        g2d.draw(smoke);
    }
    
    public void animate()
    {
        y--;
        if (y == -70)
        {
            y = 0;
        }
    }
}
