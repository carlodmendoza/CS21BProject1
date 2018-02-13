import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
/**
 * Class DrawingComponent serves as main drawing area
 * 
 * @author Carlo Mendoza 
 */
public class DrawingComponent extends JComponent
{
    private int width,height,delay;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Hill hill;
    private Sun sun;
    private Airplane plane;
    private AffineTransform at;
    private javax.swing.Timer timer;
    private Color skyColor1, skyColor2;
    private boolean isAnimated, isNight, showInstructions;

    public DrawingComponent(int w, int h)
    {
        width = w;
        height = h;
        delay = 0;
        hill = new Hill(0,0);
        sun = new Sun(0,0);
        plane = new Airplane(250,-50,Color.RED,Color.CYAN,Color.YELLOW,new Color(0,250,154));
        shapes.add(hill);
        shapes.add(sun);
        shapes.add(new Cloud(0,0));
        shapes.add(new Cloud(320,100));
        shapes.add(new Cloud(-300,70));
        shapes.add(new Tree(100,-20));
        shapes.add(new Tree(500,20));
        shapes.add(new Line(140,520,140,590,Color.BLACK,new BasicStroke(2)));
        shapes.add(new Pinwheel(90,435,new Color(255,215,0),new Color(152,251,152)));
        shapes.add(new Line(540,460,540,540,Color.BLACK,new BasicStroke(2)));
        shapes.add(new Pinwheel(490,375,new Color(238,130,238),new Color(255,165,0)));
        shapes.add(new Smoke(0,0));
        shapes.add(new Smoke(-10,0));
        shapes.add(new Smoke(-10,30));
        shapes.add(new Smoke(0,30));
        shapes.add(new House(0,0,Color.YELLOW,new Color(255,20,147),Color.CYAN,new Color(160,32,240),Color.YELLOW,new Color(178,34,34)));
        shapes.add(new Kite(0,0,new Color(255,69,0),Color.MAGENTA,Color.GREEN,Color.YELLOW));
        shapes.add(plane);
        skyColor1 = new Color(173,216,230);
        skyColor2 = new Color(0,191,255);
        this.addMouseListener(new Mouse());
        this.addKeyListener(new ArrowKeys());
        ActionListener taskPerformer = e -> animateAll();
        timer = new javax.swing.Timer(delay, taskPerformer);
        timer.stop();
        isAnimated = false;
        isNight = false;
        showInstructions = true;
    }

    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));
        at = g2d.getTransform();
       
        GradientPaint sky = new GradientPaint(0,0,skyColor1,0,height+200,skyColor2);
        g2d.setPaint(sky);
        g2d.fillRect(0,0,width,height);
        
        if (isNight)
        {
            sun.toMoon();
            hill.toNight();
            skyColor1 = new Color(0,24,72);
            skyColor2 = new Color(96,72,120);
            g2d.setFont(new Font("Courier New",Font.BOLD,25)); 
            g2d.setPaint(Color.WHITE);
            g2d.drawString("NIGHT MODE",330,45);
        }
        else
        {
            sun.toSun();
            hill.toDay();
            skyColor1 = new Color(173,216,230);
            skyColor2 = new Color(0,191,255);
            g2d.setFont(new Font("Courier New",Font.BOLD,25)); 
            g2d.setPaint(Color.BLACK);
            g2d.drawString("DAY MODE",340,45);
            if (showInstructions)
            {
                g2d.setFont(new Font("Courier New",Font.PLAIN,20)); 
                g2d.drawString("Press SPACE to start/stop the animation",155,250);
                g2d.drawString("While animated, press UP/DOWN to control the plane",95,270);
                g2d.drawString("Press LEFT/RIGHT CLICK to enter day or night mode",100,290);
                showInstructions = false;
            }
        }
               
        for (Shape s : shapes) {s.draw(g2d); g2d.setTransform(at);}
    }
    
    public void animateAll()
    {
        for (Shape s : shapes) {s.animate(); repaint();}
    }

    class Mouse implements MouseListener 
    {
        public void mouseClicked(MouseEvent e) 
        {
            if ((e.getButton() == 1))
            {
                isNight = false;
            }
            else if ((e.getButton() == 3))
            {
                isNight = true;
            }
        }
        public void mouseEntered(MouseEvent e) 
        {
            requestFocus(); 
        }
        public void mouseExited(MouseEvent e) 
        {
        }
        public void mousePressed(MouseEvent e) 
        {
        }
        public void mouseReleased(MouseEvent e) 
        {
        }
    }
    
    class ArrowKeys implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_UP)
             plane.moveUp();
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
             plane.moveDown();
            else if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                if (isAnimated==false)
                {
                    timer.start();
                    isAnimated = true;
                }
                else
                {   timer.stop();
                    isAnimated = false;
                }
            }
        }
        public void keyReleased(KeyEvent e)
        {
        }
        public void keyTyped(KeyEvent e)
        {
        }
    }
}