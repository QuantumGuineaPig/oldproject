import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.FontMetrics;
import java.awt.font.TextLayout;

public class Label extends Actor
{
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.BLACK;
    private final Color transparent = new Color(0,0,0,0);
    private int number;
    private double num;
     
    public Label(String value, int fontSize)
    {
        this.value = value;
        this.fontSize = fontSize;
        updateImage();
    }

    public int getNumber(){
        return number; 
    }
    
    public double getNum(){
        return num;
    }

    public void setNum(String newNum){
        this.num = Double.parseDouble(newNum); //converts newNum from String to a double
        value = newNum;
        updateImage();
    }
    
        public void setNumber(String newNumber){
        this.number = Integer.parseInt(newNumber);
        value = newNumber;
        updateImage();
    }

    private void updateImage()
    {
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
}