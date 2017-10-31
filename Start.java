import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.FontMetrics;
import java.awt.font.TextLayout;
/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.BLACK;
    private final Color transparent = new Color(0,0,0,0);
    boolean clicked = false;
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)== true){
            clicked = true;
        }
    }    

    public boolean clicked(){
        boolean returnClicked = clicked;
        clicked = false;
        return returnClicked;
    }

    public void setElastic(){
        setImage("ElasticUI.PNG");
    }

    public void setInelastic(){
        setImage("InelasticUI.PNG");
    }

    public void setExplosion(){
        setImage("ExplosionUI.PNG");
    }

    public void setCustom(){
        setImage("custom.PNG");
    }

    public void setVelocityLabel(){
        setImage("V.png");
    }

    public void setHeightLabel(){
        setImage("H.png");
    }

    public void setMB1Label(){
        setImage("MB1.png");
    }

    public void setMB2Label(){
        setImage("MB2.png");
    }

    public void setElasticityLabel(){
        setImage("Elasticity.png");
    }

    public void setInitialMomentum1Label(){
        setImage("Initial Momentum 1.png");
    }

    public void setInitialMomentum2Label(){
        setImage("Initial Momentum 2.png");
    }
    
    public void setFinalMomentum1(){
        setImage("Final Momentum 1.png");
    }
    
    public void setFinalMomentum2(){
        setImage("Final Momentum 2.png");
    }
}
