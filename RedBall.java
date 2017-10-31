import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;

/**
 * Write a description of class PoolBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBall extends Circle
{
    private double moveX;
    private double moveY;

    public RedBall(Color c)
    {
        super(25, c);
    }

    public void act()
    {
        setExactLocation(getExactX() + moveX, getExactY() + moveY);
    }

    public void drawLine(){
        getWorld().getBackground().setColorAt(getX(), getY(), Color.RED);
    }

    protected double getMoveX() { return moveX; }

    protected double getMoveY() { return moveY; }

    public double getNewX() { return getExactX() + getMoveX(); }

    public double getNewY() { return getExactY() + getMoveY(); }

    // If they are both close enough to zero, will be set to zero
    protected void setMove(double vx, double vy)
    {
        moveX = vx;
        moveY = vy;
        /*
        if (Math.hypot(moveX, moveY) < 0.05)
        {
        moveX = 0;
        moveY = 0;
        }
         */
    }

    public String toString()
    {
        return getClass().toString() + " @ (" + getExactX() + ", " + getExactY() + ")";
    }
}
