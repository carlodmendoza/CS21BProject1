import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Class Greeting declares a JFrame variable and instantiates a DrawingComponent object
 * 
 * @author Carlo Mendoza
 */
public class Greeting
{
    public static void main(String[]args)
    {   
        int x = 800;
        int y = 600;
        
        JFrame f = new JFrame();
        DrawingComponent dc = new DrawingComponent(x,y);
   
        f.setResizable(false);
        f.setTitle("Animated Greeting Card by Carlo Mendoza");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setPreferredSize(new Dimension(x,y));
        f.add(dc);
        f.pack();
        f.revalidate();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}