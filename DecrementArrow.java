import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DecrementArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecrementArrow extends Actor
{
    /**
     * Act - do whatever the DecrementArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean clicked = false;
    public void act() 
    {
        GreenfootImage image = getImage();
        //image.scale(50, 50);
        setImage(image);


        if (Greenfoot.mouseClicked(this)== true){
            //increase number count
            //number = number + 1;
            //setNumber(number); //does not work
            clicked = true;
        }
    }    

    public boolean clicked(){
        boolean returnClicked = clicked;
        clicked = false;
        return returnClicked;
    }
}
