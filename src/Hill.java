import java.awt.*;
import java.awt.geom.*;
/**
 * Class Hill draws a hill in a graphics 2D object made out of Circle, Grasses, and Paths
 * 
 * @author Carlo Mendoza
 */
public class Hill implements Shape
{
    private int x,y;
    private Paint hillColor, roadColor, strokeColor;
    private Stroke stroke;
  
    public Hill(int x, int y)
    {
        this.x = x;
        this.y = y;
        hillColor = new GradientPaint(300,400,new Color(124,252,0),0,1100,Color.BLACK);
        roadColor = new Color(139,95,20);
        strokeColor = Color.BLACK;
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        //hill
        Circle hill = new Circle(-100,425,500,hillColor,strokeColor,stroke);
        hill.draw(g2d);
        //road
        Path2D.Double road = new Path2D.Double();
        road.moveTo(400,610);
        road.quadTo(440,560,388,490);
        road.lineTo(420,490);
        road.quadTo(460,560,440,610);
        road.lineTo(400,610);
        road.closePath();
        g2d.setPaint(roadColor);
        g2d.fill(road);
        g2d.setPaint(strokeColor);
        g2d.setStroke(stroke);
        g2d.draw(road);
        //grasses
        Grass grass1 = new Grass(-110,30);
        grass1.draw(g2d);
        Grass grass2 = new Grass(154,-50);
        grass2.draw(g2d);
        Grass grass3 = new Grass(54,0);
        grass3.draw(g2d);
        Grass grass4 = new Grass(-30,60);
        grass4.draw(g2d);
        Grass grass5 = new Grass(250,-30);
        grass5.draw(g2d);
        Grass grass6 = new Grass(80,-60);
        grass6.draw(g2d);
        Grass grass7 = new Grass(45,70);
        grass7.draw(g2d);
        Grass grass8 = new Grass(55,0);
        grass8.draw(g2d);
    }
    
    public void animate()
    {
      
    }
    
    public void toNight()
    {
        hillColor = new GradientPaint(700,400,new Color(124,252,0),0,1100,Color.BLACK);
    }
    
    public void toDay()
    {
        hillColor = new GradientPaint(300,400,new Color(124,252,0),0,1100,Color.BLACK);
    }
}
