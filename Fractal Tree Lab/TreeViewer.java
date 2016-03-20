

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** This class allows the user to see the fractal tree :)
 *
 *@author Saahil Rastogi
 *@version 3/20/16
 */
public class TreeViewer 
{
    private final int WIDTH = 2000;
    private final int HEIGHT = 2000;
    //creates a drawing variable for the TreeComponent Class
    private TreeComponent drawing;
    //creats a frame variable so we can see the drawings
    private JFrame frame;

   //creates a viewer so we can wun the program
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }
    // A constructor for my viewer class
    public TreeViewer()
    {
        frame = new JFrame();
        frame.setTitle("MY AWESOME TREE... at least in my opinion; also very very funky as well");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        drawing = new TreeComponent(10);
        frame.add(drawing);
        frame.setVisible(true);
    }
}