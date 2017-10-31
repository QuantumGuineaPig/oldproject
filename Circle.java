import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Actor
{
    private int radius;
    private double x;
    private double y;

    public Circle(int radius, Color c)
    {
        this.radius = radius;
        GreenfootImage img = new GreenfootImage(radius * 2 + 1, radius * 2 + 1);
        img.setColor(c);
        img.fillOval(0, 0, 2*radius, 2*radius);
        setImage(img);
    }
    
    public int getRadius()
    {
        return radius;
    }
    
    public double getExactX()
    {
        return x;
    }
    
    public double getExactY()
    {
        return y;
    }
    
    public void setExactLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
        
        super.setLocation((int)x, (int) y);
    }
    
    public void setLocation(int x, int y)
    {
        setExactLocation(x, y);
    }
}
