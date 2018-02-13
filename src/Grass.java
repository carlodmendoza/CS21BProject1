import java.awt.*;
import java.awt.geom.*;
/**
 * Class Grass draws a grass in a graphics 2D object
 * 
 * @author Carlo Mendoza
 */
public class Grass implements Shape
{
    private int x,y;
    private Paint fillColor, strokeColor;
    private Stroke stroke;

    public Grass(int x, int y)
    {
        this.x = x;
        this.y = y;
        strokeColor = new Color(1,166,17);
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
		Path2D.Double grass = new Path2D.Double();
		grass.moveTo(185,550);
		grass.lineTo(180,540);
		grass.lineTo(190,550);
		grass.lineTo(195,540);
		grass.lineTo(195,550);
		g2d.setPaint(strokeColor);
		g2d.setStroke(stroke);
		g2d.draw(grass);
    }
    
    public void animate()
    {
    
    }
}
