import java.awt.*;
import java.awt.geom.*;
/**
 * Class Tree draws a tree in a graphics 2D object made out of Circles and Paths
 * 
 * @author Carlo Mendoza
 */
public class Tree implements Shape
{
    private int x,y;
    private Paint treeColor, trunkColor, strokeColor;
    private Stroke stroke;
  
    public Tree(int x, int y)
    {
        this.x = x;
        this.y = y;
        treeColor = new Color(30,147,45);
        trunkColor = new Color(98,78,44);
        strokeColor = Color.BLACK;
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        //trunk
        Path2D.Double trunk = new Path2D.Double();
        trunk.moveTo(140,550);
        trunk.quadTo(150,500,140,460);
        trunk.lineTo(180,460);
        trunk.quadTo(170,500,180,550);
        trunk.lineTo(140,550);
        trunk.closePath();
        g2d.setPaint(trunkColor);
        g2d.fill(trunk);
        g2d.setPaint(strokeColor);
        g2d.setStroke(stroke);
        g2d.draw(trunk);
        //leaves
        Circle leaves1 = new Circle(130,360,30,treeColor,treeColor,stroke);
        leaves1.draw(g2d);
        Circle leaves2 = new Circle(110,380,20,treeColor,treeColor,stroke);
        leaves2.draw(g2d);
        Circle leaves3 = new Circle(170,380,20,treeColor,treeColor,stroke);
        leaves3.draw(g2d);
        Circle leaves4 = new Circle(100,400,20,treeColor,treeColor,stroke);
        leaves4.draw(g2d);
        Circle leaves5 = new Circle(180,400,20,treeColor,treeColor,stroke);
        leaves5.draw(g2d);
        Circle leaves6 = new Circle(120,410,27,treeColor,treeColor,stroke);
        leaves6.draw(g2d);
        Circle leaves7 = new Circle(150,410,27,treeColor,treeColor,stroke);
        leaves7.draw(g2d);
    }
    
    public void animate()
    {
      
    }
}
