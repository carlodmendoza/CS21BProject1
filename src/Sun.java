import java.awt.*;
import java.awt.geom.*;
/**
 * Class Sun draws a sun in a graphics 2D object made out of Circles
 * 
 * @author Carlo Mendoza
 */
public class Sun implements Shape
{
    private int x,y;
    private double k;
    private Paint coreColor,strokeColor,raysColor;
    private Stroke coreStroke,raysStroke;
  
    public Sun(int x, int y)
    {
        this.x = x;
        this.y = y;
        k = 0;
        coreColor = Color.YELLOW;
        strokeColor = Color.BLACK;
        coreStroke = new BasicStroke(2);
        raysColor = new Color(255,165,0,50);
        raysStroke = new BasicStroke(0);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        Circle rays = new Circle(640-5*Math.sin(k),20-5*Math.sin(k),75+5*Math.sin(k),raysColor,raysColor,raysStroke);
        rays.draw(g2d);
        Circle core = new Circle(670,50,45,coreColor,strokeColor,coreStroke);
        core.draw(g2d);
    }
    
    public void animate()
    {
        k+=0.05;
    }
    
    public void toMoon()
    {
        coreColor = Color.WHITE;
        raysColor = new Color(255,255,255,50);
    }
    
    public void toSun()
    {
        coreColor = Color.YELLOW;
        raysColor = new Color(255,165,0,50);
    }
}
