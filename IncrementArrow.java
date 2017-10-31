import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IncrementArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IncrementArrow extends Actor
{
    /**
     * Act - do whatever the IncrementArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean clicked = false;
    public void act() 
    {
        
        GreenfootImage image = getImage();
        //image.scale(50, 50);
        setImage(image);
        //int number;
        //number = getNumber(); //works
        //System.out.println(number);
        

        if (Greenfoot.mouseClicked(this)== true){
            //increase number count
            //number = number + 1;
            //setNumber(number); //does not work
            clicked = true;
        }
        
    }   
    
    //needs to set it to false again otherwise it will keep going. to register it as clicked again, the user must click the object again
    public boolean clicked(){
        boolean returnClicked = clicked;
        clicked = false;
        return returnClicked;
    }
  
}
