import java.awt.*;
import java.awt.geom.*;
/**
 * Class Airplane draws an airplane in a graphics 2D object made out of Circle, Ovals, Lines, and Paths
 * 
 * @author Carlo Mendoza
 */
public class Airplane implements Shape
{
    private int x,y;
    private Paint planeColor, windowColor, bannerColor, textColor, strokeColor;
    private Stroke stroke;
    
    public Airplane(int x, int y, Paint pc, Paint wc, Paint bc, Paint tc)
    {   this.x = x;
        this.y = y;
        planeColor = pc;
        windowColor = wc;
        bannerColor = bc;
        textColor = tc;
        strokeColor = Color.BLACK;
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        //banner
        Line string1 = new Line(740,275,780,235,strokeColor,stroke);
        string1.draw(g2d);
        Line string2 = new Line(740,275,780,315,strokeColor,stroke);
        string2.draw(g2d);
        Path2D.Double banner = new Path2D.Double();
        banner.moveTo(780,235);
        banner.curveTo(970,205,1030,275,1210,235);
        banner.lineTo(1210,315);
        banner.curveTo(1030,355,970,285,780,315);
        banner.lineTo(780,235);
        banner.closePath();
        g2d.setPaint(bannerColor);
        g2d.fill(banner);
        g2d.setPaint(strokeColor);
        g2d.setStroke(stroke);
        g2d.draw(banner);
        //greeting
        g2d.setFont(new Font("Showcard Gothic",Font.PLAIN,50)); 
        g2d.setPaint(strokeColor);
        g2d.drawString("HAPPY ",787,293);
        g2d.drawString(" SUMMER!",962,303);
        g2d.setPaint(textColor);
        g2d.drawString("HAPPY ",790,290);
        g2d.drawString(" SUMMER!",965,300);
        //airplane
        Oval blade1 = new Oval(570,235,10,40,Color.DARK_GRAY,strokeColor,stroke);
        blade1.draw(g2d);
        Oval blade2 = new Oval(570,270,10,40,Color.DARK_GRAY,strokeColor,stroke);
        blade2.draw(g2d);
        Circle c1 = new Circle(570,267,8,Color.ORANGE,strokeColor,stroke);
        c1.draw(g2d);
        Oval chassis = new Oval(580,250,150,50,planeColor,strokeColor,stroke);
        chassis.draw(g2d);
        Oval window1 = new Oval(615,255,30,15,windowColor,strokeColor,stroke);
        window1.draw(g2d);
        Oval window2 = new Oval(660,255,30,15,windowColor,strokeColor,stroke);
        window2.draw(g2d);
        Oval tailWing1 = new Oval(710,230,35,55,planeColor,strokeColor,stroke);
        tailWing1.draw(g2d);
        g2d.rotate(Math.toRadians(-45));
        Oval tailWing2 = new Oval(300,690,35,55,planeColor,strokeColor,stroke);
        tailWing2.draw(g2d);
        g2d.rotate(Math.toRadians(90));
        Oval mainWing = new Oval(640,-270,100,50,planeColor,strokeColor,stroke);
        mainWing.draw(g2d);
    }
    
    public void animate()
    {
       x-=2;
       if (x == -1230)
       {
          x = 230;
       }
    }
    
    public void moveUp()
    {
        y-=5;
    }
    
    public void moveDown()
    {
        y+=5;
    }
}
