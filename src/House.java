import java.awt.*;
import java.awt.geom.*;
/**
 * Class House draws a house in a graphics 2D object made out of Triangle, Quadrilateral, Circle, Squares, and Lines
 * 
 * @author Carlo Mendoza
 */
public class House implements Shape
{
    private int x,y;
    private Paint houseColor, roofColor, windowColor, doorColor, doorKnobColor, chimneyColor, strokeColor;
    private Stroke stroke;
    
    public House(int x, int y, Paint hc, Paint rc, Paint wc, Paint dc, Paint dkc, Paint cc)
    {   this.x = x;
        this.y = y;
        houseColor = hc;
        roofColor = rc;
        windowColor = wc;
        doorColor = dc;
        doorKnobColor = dkc;
        chimneyColor = cc;
        strokeColor = Color.BLACK;
        stroke = new BasicStroke(2);
    }

    public void draw(Graphics2D g2d)
    {
        g2d.translate(x,y);
        //chimney
        Quadrilateral chimney = new Quadrilateral(360,370,360,340,380,340,380,370,chimneyColor,strokeColor,stroke);
        chimney.draw(g2d);
        //roof
        Triangle roof = new Triangle(350,380,410,320,470,380,roofColor,strokeColor,stroke);
        roof.draw(g2d);
        //house
        Square house = new Square(350,380,120,houseColor,strokeColor,stroke);
        house.draw(g2d);
        //windows
        Square window1 = new Square(365,400,30,windowColor,strokeColor,stroke);
        window1.draw(g2d);
        Line hCross1 = new Line(365,415,395,415,strokeColor,stroke);
        hCross1.draw(g2d);
        Line vCross1 = new Line(380,400,380,430,strokeColor,stroke);
        vCross1.draw(g2d);
        Square window2 = new Square(425,400,30,windowColor,strokeColor,stroke);
        window2.draw(g2d);
        Line hCross2 = new Line(425,415,455,415,strokeColor,stroke);
        hCross2.draw(g2d);
        Line vCross2 = new Line(440,400,440,430,strokeColor,stroke);
        vCross2.draw(g2d);
        //door
        Quadrilateral door = new Quadrilateral(395,500,395,450,425,450,425,500,doorColor,strokeColor,stroke);
        door.draw(g2d);
        Circle doorKnob = new Circle(415,475,3,doorKnobColor,strokeColor,stroke);
        doorKnob.draw(g2d);
    }
    
    public void animate()
    {
    
    }
}
