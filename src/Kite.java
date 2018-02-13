import java.awt.*;
import java.awt.geom.*;
/**
 * Class Kite draws a kite in a graphics 2D object made out of Quadrilateral, Path, Lines, and Triangles
 * 
 * @author Carlo Mendoza
 */
public class Kite implements Shape
{
    private int x,y;
    private double rot,k;
    private Paint kiteColor, ribbonColor1, ribbonColor2, ribbonColor3, tailColor, strokeColor;
    private Stroke stroke;
    
    public Kite(int x, int y, Paint kc, Paint rc1, Paint rc2, Paint rc3)
    {   this.x = x;
        this.y = y;
        rot = 0.2;
        k = 0;
        kiteColor = kc;
        ribbonColor1 = rc1;
        ribbonColor2 = rc2;
        ribbonColor3 = rc3;
        tailColor = Color.WHITE;
        strokeColor = Color.BLACK;
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        //string
        Path2D.Double string = new Path2D.Double();
        string.moveTo(500,435);
        string.curveTo(560,380,700,450,750,330);
        g2d.setPaint(strokeColor);
        g2d.setStroke(stroke);
        g2d.draw(string);
        g2d.rotate(rot*Math.sin(k),750,330);
        //tail
        Path2D.Double tail = new Path2D.Double();
        tail.moveTo(600,435);
        tail.curveTo(660,380,650,430,700,370);
        g2d.setPaint(tailColor);
        g2d.setStroke(stroke);
        g2d.draw(tail);
        //ribbons
        Triangle t1 = new Triangle(690,385,705,390,695,400,ribbonColor1,strokeColor,stroke);
        t1.draw(g2d);
        Triangle t2 = new Triangle(690,385,685,370,675,380,ribbonColor1,strokeColor,stroke);
        t2.draw(g2d);
        Triangle t3 = new Triangle(670,400,685,410,675,415,ribbonColor2,strokeColor,stroke);
        t3.draw(g2d);
        Triangle t4 = new Triangle(670,400,665,385,655,390,ribbonColor2,strokeColor,stroke);
        t4.draw(g2d);
        Triangle t5 = new Triangle(650,405,665,415,655,425,ribbonColor3,strokeColor,stroke);
        t5.draw(g2d);
        Triangle t6 = new Triangle(650,405,645,390,635,400,ribbonColor3,strokeColor,stroke);
        t6.draw(g2d);
        //kite
        Quadrilateral kite = new Quadrilateral(700,370,730,310,770,310,770,350,kiteColor,strokeColor,stroke);
        kite.draw(g2d);
        Line l1 = new Line(730,310,770,350,strokeColor,stroke);
        l1.draw(g2d);
        Line l2 = new Line(700,370,770,310,strokeColor,stroke);
        l2.draw(g2d);
    }
    
    public void animate()
    {
        k+=0.07;
    }
}
