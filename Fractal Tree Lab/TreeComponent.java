import java.awt.*;
import javax.swing.JPanel;
/**
 * This class draws a singular tree using the recursion we learned in class :DDDDD
 * 
 * @author Saahil Rastogi
 * @version 3/20/2016
 */
public class TreeComponent extends JPanel
{
    //the panel dimensions
    private final int PANEL_WIDTH = 1000;
    private final int PANEL_HEIGHT = 1000;
    //final variables for my angle multiplier and the one I subtract//add from
    private final double MULTIPLIER = .8;
    private final double ANGLE = Math.PI / 6;
    //knows the current order
    private int currOrder;

    /**
     * Default constructor for objects of class FractalTreePanel
     */
    public TreeComponent(int currentOrder)
    {
       // intializes the current order instance variable; set the the color of backround to the intended color; and sets the  size to the previous mentioned variables
        this.setBackground(Color.YELLOW);
        this.currOrder = currentOrder;
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));

    }

    /**
     *This methods uses the ways of recursion to draw the next branch (10) with the angle intended
     *
     * the x and y starting parameters are the starting points for the line
     */
    public void drawBranch(int order, int startX, int startY, int startX2 , int startY2, double angle, Graphics g2)
    {
        double newX;
        double newY; 
        double posX;
        double posY;
        double negX;
        double negY;
        //draws the first line if order is 1
        if (order == 1)
        {
            g2.drawLine(startX, startY, startX2, startY2);
        }
        //draws 2 branches if its greater than 1
        else
        {
            g2.drawLine(startX, startY, startX2, startY2);
            //Creating a new x and y for the new and shorter length of the branch
            newX = startX2 - startX;
            newY = startY2 - startY;
            double length = (Math.sqrt(newX * newX + newY * newY)) * MULTIPLIER;
            //Creates two new angles, one that adds angle, and one that subtract angle( added the .1 for cool effect)
            double newPosAngle = angle + ANGLE +.1;
            double newNegAngle = angle - ANGLE -.1;
            //i used that trig to find that angle 
            posX = startX2 - Math.sin(newPosAngle) * length;
            posY = startY2 - Math.cos(newPosAngle) * length;
            negX = startX2 - Math.sin(newNegAngle) * length;
            negY = startY2 - Math.cos(newNegAngle) * length;
            //used the recursion to go back to the mehtod
            this.drawBranch(order - 1, startX2, startY2, (int) posX, (int) posY, newPosAngle, g2);
            this.drawBranch(order - 1, startX2, startY2, (int) negX, (int) negY, newNegAngle, g2);
        }
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics g2 = (Graphics2D) g;
        super.paintComponent (g2);
        this.drawBranch(currOrder, 600, 800, 600, 600, 0, g2);
    }
    
    public void setOrder(int order)
    {
        this.currOrder = order;
    }
}