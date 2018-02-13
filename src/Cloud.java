import java.awt.*;
import java.awt.geom.*;
/**
 * Class Cloud draws a cloud in a graphics 2D object made out of Circles and Ovals
 * 
 * @author Carlo Mendoza
 */
public class Cloud implements Shape
{
    private int x,y;
    private Paint strokeColor;
    private Stroke stroke;
  
    public Cloud(int x, int y)
    {
        this.x = x;
        this.y = y;
        strokeColor = Color.WHITE;
        stroke = new BasicStroke(0);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        Oval o1 = new Oval(235,50,100,50,new Color(255,255,255,120),strokeColor,stroke);
        o1.draw(g2d);
        Oval o2 = new Oval(370,55,80,45,new Color(255,255,255,120),strokeColor,stroke);
        o2.draw(g2d);
        Circle c1 = new Circle(275,30,25,new Color(255,255,255,160),strokeColor,stroke);
        c1.draw(g2d);
        Circle c2 = new Circle(285,60,28,new Color(255,255,255,160),strokeColor,stroke);
        c2.draw(g2d);
        Circle c3 = new Circle(355,40,35,new Color(255,255,255,160),strokeColor,stroke);
        c3.draw(g2d);
        Circle c4 = new Circle(300,10,50,new Color(255,255,255,210),strokeColor,stroke);
        c4.draw(g2d);
    }
    
    public void animate()
    {
        x++;
        if (x == 560)
        {
            x=-500;
        }
    }
}
