import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class BlackBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackBall extends RedBall
{
    public BlackBall()
    {
        super(Color.BLACK);
    }

    int radius;
    /**
     * Act - do whatever the CueBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();

        if (this.isAtEdge()){
            World world;
            world = getWorld();
            world.removeObject(this);
        }

        // MouseInfo info = Greenfoot.getMouseInfo();
        /*
        if (info != null && Greenfoot.mouseClicked(null))
        {
        double angle = Math.atan2(info.getY() - getY(), info.getX() - getX());
        double cueSpeed = 8;
        setMove(Math.cos(angle) * cueSpeed, Math.sin(angle) * cueSpeed);
        }*/

    }    

    @Override
    public void drawLine(){
        getWorld().getBackground().setColorAt(getX(), getY(), Color.BLACK);
    }

    public void StartMoving(){
        System.out.println("Test Movement");
    }

    public void elastic(double horizontalVelocity, double verticalVelocity){

        setMove(horizontalVelocity,verticalVelocity);

    }

    public void inelastic(double mass1, double mass2, double horizontalVelocity, double verticalVelocity){

        // setMove(fHVelocity, fVVelocity);/System.out.println("Inelastic Test" + fHVelocity);
    }
}
