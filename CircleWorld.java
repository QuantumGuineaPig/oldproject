import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; //(Color)
import java.util.List; //(List)
import java.util.*;  // (List)
import java.awt.image.*; // (BufferedImage)
import java.io.*; // (File)
import javax.imageio.*; // {ImageIO)
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Arrays;    
import java.text.DecimalFormat;
/**
 * Write a description of class CircleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleWorld extends World
{

    /**
     * Constructor for objects of class CircleWorld.
     * 
     */

    int count = 1;
    
    final int BUTTON_X_POSITION = 703;
    final int BALL_Y_POSITION = 160;
    final int LABEL_Y_POSITION = 470;
    final int NAME_Y_POSITION = 430;
    final int INCREMENT_Y_POSITION = 460;
    final int DECREMENT_Y_POSITION = 475;
    final int FONT_SIZE = 25;

    Start elastic = new Start();
    Start inelastic = new Start();
    Start explosion = new Start();
    Start custom = new Start();
    Start iMom1 = new Start();
    Start iMom2 = new Start();
    Start fMom1 = new Start();
    Start fMom2 = new Start();
    Slider slider = new Slider();

    boolean start1 = false;
    boolean start2 = false;
    boolean start3 = false;
    boolean start4 = false;
    boolean explode = false;

    BlackBall blackball = new BlackBall();
    RedBall redball = new RedBall(Color.RED);

    double momentumInitial1;
    double momentumInitial2 = 0;
    double momentum1;
    double momentum2;
    double finalVelocity1;
    double finalVelocity2;

    double actualResultant1;
    double actualResultant2;

    Label velocity;
    Label l;
    Label a;
    Label height;
    Label he;
    Label m1;
    Label m2;
    Label labelm1;
    Label labelm2;
    Label iMomen1;
    Label iMomen2;
    Label fMomen1;
    Label fMomen2;

    IncrementArrow i = new IncrementArrow();
    DecrementArrow d = new DecrementArrow();

    IncrementArrow i2 = new IncrementArrow();
    DecrementArrow d2 = new DecrementArrow();

    IncrementArrow i3 = new IncrementArrow();
    DecrementArrow d3 = new DecrementArrow();

    IncrementArrow i4 = new IncrementArrow();
    DecrementArrow d4 = new DecrementArrow();

    IncrementArrow i5 = new IncrementArrow();
    DecrementArrow d5 = new DecrementArrow();

    int v = 5;
    int mass1 = 1;
    int mass2 = 1;
    int h = 0;
    double actualHeight;
    String question;
    PrintWriter writeQuestion;
    PrintWriter writeAnswer;
    String[] file1,file2;
    double length;

    public CircleWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.

        super(800, 600, 1, false);

        addObject(blackball, 200, BALL_Y_POSITION);

        Start vLabel = new Start();
        Start hLabel = new Start();
        Start mb1Label = new Start();
        Start mb2Label = new Start();
        Start elasticity = new Start();

        addObject(elastic, BUTTON_X_POSITION, 422);
        addObject(inelastic, BUTTON_X_POSITION, 446);
        addObject(explosion, BUTTON_X_POSITION, 470);
        addObject(custom, BUTTON_X_POSITION, 494);

        //Sets Label image
        elastic.setElastic();
        inelastic.setInelastic();
        explosion.setExplosion();
        custom.setCustom();

        //Label for velocity number
        velocity = new Label(Integer.toString(v), FONT_SIZE); //converts integer to String
        velocity.setNumber(Integer.toString(v)); //setNumber takes in a String (this string should be then be converted to an integer)

        he = new Label(Integer.toString(h), FONT_SIZE);
        he.setNumber(Integer.toString(h));

        m1 = new Label(Integer.toString(mass1), FONT_SIZE);
        m1.setNumber(Integer.toString(mass1));

        m2 = new Label(Integer.toString(mass2), FONT_SIZE);
        m2.setNumber(Integer.toString(mass2));

        iMomen1 = new Label(Double.toString(momentumInitial1), FONT_SIZE);
        iMomen1.setNum(Double.toString(momentumInitial1));
        addObject(iMomen1, 110 , 270);

        iMomen2 = new Label(Double.toString(momentumInitial2), FONT_SIZE);
        iMomen2.setNum(Double.toString(momentumInitial2));
        addObject(iMomen2, 110 , 300);

        fMomen1 = new Label(Double.toString(momentum1), FONT_SIZE);
        fMomen1.setNum(Double.toString(momentum1));
        addObject(fMomen1, 110 , 330);

        fMomen2 = new Label(Double.toString(momentum2), FONT_SIZE);
        fMomen2.setNum(Double.toString(momentum2));
        addObject(fMomen2, 110 , 360);

        //Label for height
        //height = new Label("Height", FONT_SIZE);
        //addObject(height, 179, 279);
        addObject(he, 285, LABEL_Y_POSITION);
        addObject(i3, 342, INCREMENT_Y_POSITION);
        addObject(d3, 342, DECREMENT_Y_POSITION);

        //l = new Label("Velocity", FONT_SIZE);
        //addObject(l, 52, 279);

        //Label for velocity
        addObject(velocity, 160, LABEL_Y_POSITION);
        addObject(i, 200, INCREMENT_Y_POSITION);
        addObject(d, 200, DECREMENT_Y_POSITION);

        //Label for the mass of ball1
        //labelm1 = new Label("Mass of ball 1", FONT_SIZE);
        addObject(m1, 420, LABEL_Y_POSITION);
        addObject(i4, 513, INCREMENT_Y_POSITION);
        addObject(d4, 513, DECREMENT_Y_POSITION);
        //addObject(labelm1, 315, 279);

        //Label for the mass of ball2
        //labelm2 = new Label("Mass of ball 2", FONT_SIZE);
        addObject(m2, 565, LABEL_Y_POSITION);
        addObject(i5, 604, INCREMENT_Y_POSITION);
        addObject(d5, 604, DECREMENT_Y_POSITION);
        //addObject(labelm2, 493, 279);

        //Other labels
        addObject(hLabel, 285, NAME_Y_POSITION);
        addObject(vLabel, 160, NAME_Y_POSITION);
        addObject(mb1Label, 420, NAME_Y_POSITION);
        addObject(mb2Label, 565, NAME_Y_POSITION);
        addObject(iMom1, 50, 270);
        addObject(iMom2, 50, 300);
        addObject(fMom1, 50, 330);
        addObject(fMom2, 50, 360);

        vLabel.setVelocityLabel();
        hLabel.setHeightLabel();
        mb1Label.setMB1Label();
        mb2Label.setMB2Label();
        elasticity.setElasticityLabel();
        iMom1.setInitialMomentum1Label();
        iMom2.setInitialMomentum2Label();
        fMom1.setFinalMomentum1();
        fMom2.setFinalMomentum2();

        boolean start1 = false;

        //addObject(new PoolBall(Color.RED), 500, 300);
        addObject(redball, 600, BALL_Y_POSITION);

        addObject(elasticity, 380, 530);
        addObject(slider, 400, 550);

        length = redball.getX() - blackball.getX();
        int len1,len2;
        
        
        
        try{

            ReadFile fileReader=new ReadFile("Questions.txt");
            ReadFile fileReader2=new ReadFile("Answers.txt");
            String[] readFile=fileReader.OpenFile();
            String[] readFile2=fileReader2.OpenFile();

            file1=readFile;
            file2=readFile2;
            len1=readFile.length;
            len2=readFile2.length;
            
            writeQuestion = new PrintWriter("Questions.txt", "UTF-8");
            writeAnswer = new PrintWriter("Answers.txt", "UTF-8");

            for ( int i=0; i < len1; i++ ) {
                writeQuestion.println(readFile[i].replace("null",""));
                System.out.println(readFile[i].replace("null",""));
            } 

            for (int  i=0; i < len2; i++ ) {
                writeAnswer.println(readFile2[i].replace("null",""));
                System.out.println(readFile2[i].replace("null",""));
            } 

            writeQuestion.close();
            writeAnswer.close();

        }
        catch(Exception e){
            System.out.println(e);
        }


        final int radiusPlus = 27;
        for (int row = 0; row < 4; row++)
        {
            int startY = 300 - row * radiusPlus;
            int x = 500 + (int)(row * (Math.sqrt(3) * (double)radiusPlus));
            for (int ball = 0; ball < row + 1; ball++)
            {
                //addObject(new PoolBall(Color.RED), x, startY + ball * (2 * radiusPlus));
            }
        }

        //momentumInitial1 = m1.getNumber()*velocity.getNumber();

    }
    double tempmomentum1;
    double tempmomentum2;

    public void act()
    {
        
        DecimalFormat df = new DecimalFormat("#.###");
       
        iMomen1.setNum(df.format(momentumInitial1));
        
        iMomen2.setNum(df.format(momentumInitial2));
        // fMomen1.setNum(Double.toString(Math.round((m1.getNumber())*finalVelocity1*100.0)/100.0));
        //fMomen1.setNum(Double.toString(m1.getNumber()*finalVelocity1));
        //fMomen2.setNum(Double.toString(m2.getNumber()*finalVelocity2));
        //fMomen2.setNum(Double.toString(Math.round((m2.getNumber())*finalVelocity2*100.0)/100.0));

        /* System.out.println("Momentum 1 Initial: "+ momentumInitial1);
        System.out.println("Momentum 2 Initial: "+ momentumInitial2);      

        System.out.println("Momentum 1 Final: " + momentum1);
        System.out.println("Momentum 2 Final: " + momentum2);

        System.out.println("Final Velocity of Ball 1: " + finalVelocity1);
        System.out.println("Final Velocity of Ball 2: " + finalVelocity2);
         */

        if((start1 || start2 || start3 || start4) && blackball.getX() < 800 && blackball.getY() <600){
            blackball.drawLine();
        }

        if((start1 || start2 || start3 || start4) && redball.getX() < 800 && redball.getY() <600){
            redball.drawLine();
        }

        /**
        if(start1 || start2 || start3){
        blackball.drawLine();
        redball.drawLine();
        }**/

        //gets the resultant velocity of the blackball and redball
        //momentum1 = (double) (m1.getNumber()*Math.hypot(blackball.getMoveX(), blackball.getMoveY()));
        //momentum2 = (double) (m2.getNumber()*Math.hypot(redball.getMoveX(), redball.getMoveY()));

        momentum1 = (double) (m1.getNumber()*Math.hypot(blackball.getMoveX(), blackball.getMoveY()));
        momentum2 = (double) (m2.getNumber()*Math.hypot(redball.getMoveX(), redball.getMoveY()));

        /**INCREMENT ARROWS**/

        if(i.clicked() && velocity.getNumber()>0 && velocity.getNumber()<10){
            velocity.setNumber(Integer.toString(velocity.getNumber()+1)); //CONVERTED TO STRING
        }

        if(d.clicked() && velocity.getNumber()>1 && velocity.getNumber()<11){
            velocity.setNumber(Integer.toString(velocity.getNumber()-1)); //CONVERTED TO STRING
        }

        if(i3.clicked() && he.getNumber()> -51 && he.getNumber()<50){
            he.setNumber(Integer.toString(he.getNumber()+1)); //CONVERTED TO STRING
            // blackball.setLocation(200, BALL_Y_POSITION - 2);
            blackball.setLocation(200,blackball.getY()-1);
            actualHeight = he.getNumber();
            //momentumInitial1 = m1.getNumber()*velocity.getNumber()/(Math.cos(Math.atan(he.getNumber()/Math.abs(redball.getExactX() - blackball.getExactX()))));
        }

        if(d3.clicked() && he.getNumber()> -50 && he.getNumber()<51){
            he.setNumber(Integer.toString(he.getNumber()-1)); //CONVERTED TO STRING
            //blackball.setLocation(200, BALL_Y_POSITION +2);
            blackball.setLocation(200,blackball.getY()+1);
            actualHeight = he.getNumber();
            //momentumInitial1 = m1.getNumber()*velocity.getNumber()/(Math.cos(Math.atan(he.getNumber()/Math.abs(redball.getExactX() - blackball.getExactX()))));
        }

        if(i4.clicked() && m1.getNumber()>0 && m1.getNumber()<10){
            m1.setNumber(Integer.toString(m1.getNumber()+1)); //CONVERTED TO STRING
        }

        if(d4.clicked() && m1.getNumber()>1 && m1.getNumber()<11){
            m1.setNumber(Integer.toString(m1.getNumber()-1)); //CONVERTED TO STRING
        }

        if(i5.clicked() && m2.getNumber()>0 && m2.getNumber()<10){
            m2.setNumber(Integer.toString(m2.getNumber()+1)); //CONVERTED TO STRING
        }

        if(d5.clicked() && m2.getNumber()>1 && m2.getNumber()<11){
            m2.setNumber(Integer.toString(m2.getNumber()-1)); //CONVERTED TO STRING
        }

        for (RedBall b : (List<RedBall>)getObjects(Circle.class))
        {
            //  applyFriction(b);
        }

        boolean playBall = false;

        /**CHECKS IF COLLIDED**/
        boolean altered = true;
        while (altered)
        {
            altered = false;
            for (RedBall b : (List<RedBall>)getObjects(Circle.class))
            {
                boolean ball = collideBalls(b);
            }
        }

        /**WAITS UNTIL COLLISION THEN RUNS**/
        elastic();
        inelastic();
        explosion();
        custom();
    }

    public void applyFriction(RedBall b)
    {
        double vx = b.getMoveX() * 0.99;
        double vy = b.getMoveY() * 0.99;
        if (Math.hypot(vx, vy) < 0.05)
        {
            b.setMove(0, 0);
        }
        else
        {
            b.setMove(vx, vy);
        }
    }

    public void elastic(){
        if(elastic.clicked()){
            start1=true;
            start2=false;
            start3=false;
            start4 = false;

            initialVelocity = velocity.getNumber()/(Math.cos(Math.atan(he.getNumber()/Math.abs(redball.getExactX() - blackball.getExactX()))));
            double velocityAlongY = velocity.getNumber()*(he.getNumber()/(redball.getExactX() - blackball.getExactX()));
            double resultantVelocityi = Math.hypot(velocity.getNumber(), velocityAlongY);
            momentumInitial1 = m1.getNumber()*resultantVelocityi;
            blackball.elastic((double)velocity.getNumber(), 0);     
            write();
            //removeObject(inelastic);
            //removeObject(elastic);
            //removeObject(explosion);
            //removeObject(custom);
        }
    }

    public void inelastic(){ //controls inelastic collisions
        if(inelastic.clicked()){
            start1=false;
            start2=true;
            start3=false;
            start4 = false;
            initialVelocity= velocity.getNumber()/(Math.cos(Math.atan(he.getNumber()/Math.abs(redball.getExactX() - blackball.getExactX()))));
            double velocityAlongY = velocity.getNumber()*(he.getNumber()/(redball.getExactX() - blackball.getExactX()));
            double resultantVelocityi = Math.hypot(velocity.getNumber(), velocityAlongY);
            momentumInitial1 = m1.getNumber()*resultantVelocityi;

            blackball.elastic((double)velocity.getNumber(), 0);   
            write();
            // blackball.inelastic((double)m1.getNumber(),(double)m2.getNumber(),(double)velocity.getNumber(), 0);
            //removeObject(inelastic);
            //removeObject(elastic);
            //removeObject(explosion);
            //removeObject(custom);
        }
    }

    public void custom(){
        if(custom.clicked()){
            start1 = false;
            start2 = false;
            start3 = true;
            start4 = false;
            initialVelocity= velocity.getNumber()/(Math.cos(Math.atan(he.getNumber()/Math.abs(redball.getExactX() - blackball.getExactX()))));
            double velocityAlongY = velocity.getNumber()*(he.getNumber()/(redball.getExactX() - blackball.getExactX()));
            double resultantVelocityi = Math.hypot(velocity.getNumber(), velocityAlongY);
            momentumInitial1 = m1.getNumber()*resultantVelocityi;

            blackball.elastic((double)velocity.getNumber(), 0);
            write();

            //removeObject(inelastic);
            //removeObject(elastic);
            // removeObject(explosion);
            // removeObject(custom);
        }
    }

    public void explosion(){
        if(explosion.clicked()){
            start1 = false;
            start2 = false;
            start3 = false;
            start4 = true;

            write();
            //blackball.elastic((double)velocity.getNumber(), 0);

            blackball.setLocation(375, BALL_Y_POSITION - he.getNumber());
            redball.setLocation(425, BALL_Y_POSITION);

            //double vEx1 = (double)velocity.getNumber();
            //double vEx2 = (m1.getNumber()*vEx1)/(-m2.getNumber());

            //blackball.setMove(vEx1, 0);
            //redball.setMove(vEx2, 0);

            //removeObject(inelastic);
            //removeObject(elastic);
            //removeObject(explosion);
            //removeObject(custom);
            if(start4){
                double v = velocity.getNumber();
                double h = he.getNumber();
                double l = redball.getX() - blackball.getX();
                double diameter = redball.getRadius()*2;
                double massA = m1.getNumber(); 
                double massB = m2.getNumber();

                double vyInitial = v*(h/diameter);
                double vxInitial = v*(l/diameter);

                double vyFinal = (massA*vyInitial)/(-massB);
                double vxFinal = (massA*vxInitial)/(-massB);

                redball.setMove(vxInitial, vyInitial);
                blackball.setMove(vxFinal, vyFinal);

                double va_resultant = Math.hypot(vxInitial, vyInitial);
                double vb_resultant = Math.hypot(vxFinal, vyFinal);

                fMomen1.setNum(Double.toString((-1.00)*Math.round(va_resultant*100.0)/100.0));
                fMomen2.setNum(Double.toString(Math.round(vb_resultant*100.0)/100.0));

            }
        }
    }

    double initialVelocity;

    // Returns true if moveX or moveY was altered
    public boolean collideBalls(RedBall b)
    {
        DecimalFormat df = new DecimalFormat("#.###");

        if (b.getMoveX() == 0 && b.getMoveY() == 0)
            return false; //stationary ball

        double newX = b.getNewX();
        double newY = b.getNewY();

        for (RedBall c : (List<RedBall>)getObjects(Circle.class))
        {
            if (c == b)
                continue; 

            double distX = c.getNewX() - newX;
            double distY = c.getNewY() - newY;
            double dist = Math.sqrt(distX * distX + distY * distY);

            if (dist <= b.getRadius() + c.getRadius())
            {

                double height = redball.getY() - blackball.getY();

                double massA= (double) m1.getNumber();
                double massB= (double) m2.getNumber();

                if(start1){

                    double cor = 1;

                    double inputVelocity = velocity.getNumber();
                    //VELOCITY IS THE INITIAL XVELOCITY OF BALL1
                    double vax = (double)((massA*inputVelocity) - (massB*cor*inputVelocity))/(massA+massB);
                    System.out.println("vax"+String.valueOf(vax));
                    double vaxVISUAL = (double)((massA*inputVelocity) - (massB*cor*inputVelocity))/(massA+massB);
                    System.out.println("vaxVisual"+String.valueOf(vaxVISUAL));
                    double vbx = (double)((massA*inputVelocity) + (massA*cor*inputVelocity))/(massA+massB);
                    System.out.println("vbx"+String.valueOf(vbx));
                    
                    
                    
                    //double h = (double) he.getNumber();
                    // double h = (double) -1*(b.getExactY()-c.getExactY());
                    // double vay = (massA*(((-1)*h/length)*initialVelocity) - (massB*cor*initialVelocity))/(massA+massB);

                    //INITIAL VY
                    double vay = (double)((massA*inputVelocity*(actualHeight/length))-(massB*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    System.out.println("vay"+String.valueOf(vay));
                    double vayVISUAL = (double)((massA*inputVelocity*(actualHeight/length))-(massB*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    System.out.println("vayVISUAL"+String.valueOf(vayVISUAL));
                    //double vay = ((-1)*h/length)*velocity.getNumber()/(Math.cos(Math.atan(he.getNumber()/Math.abs(redball.getExactX() - blackball.getExactX()))));

                    // double vby = (massA*(h/length)*initialVelocity + (massA*cor*initialVelocity))/(massA+massB);   
                    double vby = (double)((massA*inputVelocity*(actualHeight/length))+(massA*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    System.out.println("Actual Height: " + actualHeight);
                    System.out.println("Actual Length: " + length);
                    System.out.println("vby"+String.valueOf(vby));

                    
                    //System.out.println(cor);
                    finalVelocity1 = Math.hypot(vax, vay);
                    //finalVelocity1 = Math.hypot(b.getMoveX(), b.getMoveY());

                    // = Math.hypot(c.getMoveX(),c.getMoveY());
                    finalVelocity2 = Math.hypot(vbx, vby);

                    momentum1 = (double) (m1.getNumber()*Math.hypot(blackball.getMoveX(), blackball.getMoveY()));

                     
                    momentum2 = (double) (m2.getNumber()*Math.hypot(redball.getMoveX(), redball.getMoveY()));

                    
                    
                     
                    // tempmomentum1x-=initialMassOffset;
                    //  tempmomentum1y-=initialMassOffset;

                   
                    double resultantV1 = Math.hypot(vax,vay);
                    double resultantV2 = Math.hypot(vbx,vby);
                    if(m2.getNumber()>m1.getNumber()){
                        resultantV1 = -1*resultantV1;
                    }

                    fMomen1.setNum(df.format(m1.getNumber()*resultantV1));
                    fMomen2.setNum((df.format(m2.getNumber()*resultantV2)));
                    //fMomen1.setNum(Double.toString((m1.getNumber()*resultantV1)));
                    //fMomen2.setNum(Double.toString((m2.getNumber()*resultantV2)));                     

                    b.setMove(vaxVISUAL,-1*vay);
                    c.setMove(vbx,vby);
                    /**
                    b.setMove(towardsMe * distX + myOrtho * distY,
                        towardsMe * distY + myOrtho * -distX);

                    c.setMove(towardsThem * distX + theirOrtho * distY,
                        towardsThem * distY + theirOrtho * -distX);
                        **/
                    //write();    
                    /**
                    double vax = (double)((massA*initialVelocity) - (massB*1.00*initialVelocity))/(massA+massB);
                    double vbx = (double)((massA*initialVelocity) + (massB*1.00*initialVelocity))/(massA+massB);
                    double h = (double) he.getNumber();
                    // double vay = (massA*(((-1)*h/length)*initialVelocity) - (massB*cor*initialVelocity))/(massA+massB);
                    double vay = (double)((massA*initialVelocity*((-1)*h/length))-(massB*1.00*initialVelocity*(h/length)))/(massA+massB);
                    // double vby = (massA*(h/length)*initialVelocity + (massA*cor*initialVelocity))/(massA+massB);   
                    double vby = (double)(massA*initialVelocity*(h/length)+(massA*1.00*initialVelocity*(h/length)))/(massA+massB);
                    //System.out.println(cor);
                    b.setMove(vax,vay);
                    c.setMove(vbx,vby);**/

                }
                if(start2){
                    //COEFFICIENT OF RESTITUTION
                    double cor = 0;

                    //X-VELOCITIES
                    double inputVelocity = velocity.getNumber();
                    double vax = (double)((massA*inputVelocity) - (massB*cor*inputVelocity))/(massA+massB);
                    double vaxVISUAL = (double)((massA*inputVelocity) - (massB*cor*inputVelocity))/(massA+massB);
                    double vbx = (double)((massA*inputVelocity) + (massA*cor*inputVelocity))/(massA+massB);

                    //Y-VELOCITIES
                    double vay = (double)((massA*inputVelocity*(actualHeight/length))-(massB*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    double vayVISUAL = (double)((massA*inputVelocity*(actualHeight/length))-(massB*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    double vby = (double)((massA*inputVelocity*(actualHeight/length))+(massA*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    
                    //RESULTANT VELOCITIES
                    finalVelocity1 = Math.hypot(vax, vay);
                    finalVelocity2 = Math.hypot(vbx, vby);
                    double resultantV1 = Math.hypot(vax,vay);
                    double resultantV2 = Math.hypot(vbx,vby);

                    //MOMENTUM
                    momentum1 = (double) (m1.getNumber()*Math.hypot(blackball.getMoveX(), blackball.getMoveY()));
                    momentum2 = (double) (m2.getNumber()*Math.hypot(redball.getMoveX(), redball.getMoveY()));
                    fMomen1.setNum(df.format(m1.getNumber()*resultantV1)); //LABELS
                    fMomen2.setNum((df.format(m2.getNumber()*resultantV2)));              

                    //BALL MOVEMENT
                    b.setMove(vaxVISUAL,-1*vay);
                    c.setMove(vbx,vby);
                    
                    //CHECKS
                    System.out.println("vay"+String.valueOf(vay));
                    System.out.println("vayVISUAL"+String.valueOf(vayVISUAL));
                    System.out.println("vbx"+String.valueOf(vbx));
                    System.out.println("vaxVisual"+String.valueOf(vaxVISUAL));
                    System.out.println("vax"+String.valueOf(vax));
                    System.out.println("Actual Height: " + actualHeight);
                    System.out.println("Actual Length: " + length);
                    System.out.println("vby"+String.valueOf(vby));
                }
                if(start3){
                    double cor = (double) 0.010*slider.getValue();

                    double inputVelocity = velocity.getNumber();
                    //VELOCITY IS THE INITIAL XVELOCITY OF BALL1
                    double vax = (double)((massA*inputVelocity) - (massB*cor*inputVelocity))/(massA+massB);
                    System.out.println("vax"+String.valueOf(vax));
                    double vaxVISUAL = (double)((massA*inputVelocity) - (massB*cor*inputVelocity))/(massA+massB);
                    System.out.println("vaxVisual"+String.valueOf(vaxVISUAL));
                    double vbx = (double)((massA*inputVelocity) + (massA*cor*inputVelocity))/(massA+massB);
                    System.out.println("vbx"+String.valueOf(vbx));
                    //double h = (double) he.getNumber();
                    // double h = (double) -1*(b.getExactY()-c.getExactY());
                    // double vay = (massA*(((-1)*h/length)*initialVelocity) - (massB*cor*initialVelocity))/(massA+massB);

                    //INITIAL VY
                    double vay = (double)((massA*inputVelocity*(actualHeight/length))-(massB*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    System.out.println("vay"+String.valueOf(vay));
                    double vayVISUAL = (double)((massA*inputVelocity*(actualHeight/length))-(massB*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    System.out.println("vayVISUAL"+String.valueOf(vayVISUAL));
                    //double vay = ((-1)*h/length)*velocity.getNumber()/(Math.cos(Math.atan(he.getNumber()/Math.abs(redball.getExactX() - blackball.getExactX()))));

                    // double vby = (massA*(h/length)*initialVelocity + (massA*cor*initialVelocity))/(massA+massB);   
                    double vby = (double)((massA*inputVelocity*(actualHeight/length))+(massA*cor*inputVelocity*(actualHeight/length)))/(massA+massB);
                    System.out.println("Actual Height: " + actualHeight);
                    System.out.println("Actual Length: " + length);
                    System.out.println("vby"+String.valueOf(vby));

                    
                    //System.out.println(cor);
                    finalVelocity1 = Math.hypot(vax, vay);
                    //finalVelocity1 = Math.hypot(b.getMoveX(), b.getMoveY());

                    // = Math.hypot(c.getMoveX(),c.getMoveY());
                    finalVelocity2 = Math.hypot(vbx, vby);

                    momentum1 = (double) (m1.getNumber()*Math.hypot(blackball.getMoveX(), blackball.getMoveY()));

                     
                    momentum2 = (double) (m2.getNumber()*Math.hypot(redball.getMoveX(), redball.getMoveY()));

                    
                    
                     
                    // tempmomentum1x-=initialMassOffset;
                    //  tempmomentum1y-=initialMassOffset;

                   
                    double resultantV1 = Math.hypot(vax,vay);
                    double resultantV2 = Math.hypot(vbx,vby);
                    if(m2.getNumber()>m1.getNumber() && cor != 0.00){
                        resultantV1 = -1*resultantV1;
                    }

                    fMomen1.setNum(df.format(m1.getNumber()*resultantV1));
                    fMomen2.setNum((df.format(m2.getNumber()*resultantV2)));
                    //fMomen1.setNum(Double.toString((m1.getNumber()*resultantV1)));
                    //fMomen2.setNum(Double.toString((m2.getNumber()*resultantV2)));                     

                    b.setMove(vaxVISUAL,-1*vay);
                    c.setMove(vbx,vby);
                    // write();

                    //TRY TO INCORPORATE THIS SOLUTION
                    /**
                    if(cor == 1.00){
                    b.setMove(massA * cor * towardsMe * distX + myOrtho * distY,  towardsMe * distY + myOrtho * -distX);
                    c.setMove(massB * (cor) * towardsThem * distX + theirOrtho * distY, towardsThem * distY + theirOrtho * -distX);

                    }
                    else if (cor == 0.00){
                    b.setMove(massA * cor * towardsMe * distX + myOrtho * distY,  towardsMe * distY + myOrtho * -distX);
                    c.setMove(massB * (1-cor) * towardsThem * distX + theirOrtho * distY, towardsThem * distY + theirOrtho * -distX);
                    }
                    else{
                    b.setMove(massA * cor * towardsMe * distX + myOrtho * distY,  towardsMe * distY + myOrtho * -distX);
                    c.setMove(massB * (cor) * towardsThem * distX + theirOrtho * distY, towardsThem * distY + theirOrtho * -distX);
                    }**/

                    //b.setMove(massA * cor * towardsMe * distX + myOrtho * distY,  towardsMe * distY + myOrtho * -distX);
                    //c.setMove(massB * (cor) * towardsThem * distX + theirOrtho * distY, towardsThem * distY + theirOrtho * -distX);

                }
                return true;
            }
        }
        return false;
    }

    private double distAlong(double x, double y, double xAlong, double yAlong)
    {
        return (x * xAlong + y * yAlong) / Math.hypot(xAlong, yAlong);
    }

    public void write(){

        try{

            writeQuestion = new PrintWriter("Questions.txt", "UTF-8");
            writeAnswer = new PrintWriter("Answers.txt", "UTF-8");
        }catch(IOException e){
            
        }
        int difficulty;

        for ( int i=0; i < file1.length; i++ ) {
            writeQuestion.println(file1[i].replace("null",""));
            System.out.println(file1[i].replace("null",""));
        } 

        for (int  i=0; i < file2.length; i++ ) {
            writeAnswer.println(file2[i].replace("null",""));
            System.out.println(file2[i].replace("null",""));
        } 
        
        if(start1){    
            question = "Ball 1 has a mass of " + m1.getNumber() + " and a velocity of " + velocity.getNumber() + ". Ball 1 collides elastically with a stationary Ball 2 which has a mass of " + m2.getNumber() + ". What is the final velocity of Ball 1?";
            writeQuestion.println(question);
            writeQuestion.println();
        }

        else if(start2){
            question = "Ball 1 has a mass of " + m1.getNumber() + "and collides inelastically at a velocity of " + velocity.getNumber() + " with Ball 2 which has a mass of " + m2.getNumber() + ". What is the final velocity of Ball 1?";
            writeQuestion.println(question);
            writeQuestion.println();
        }

        else if (start3){

            /**question = "Mass of Ball 1: " + m1.getNumber() + " " +
            "\nMass of Ball 2: " + m2.getNumber() + " " +
            "\nInitial Velocity of Ball 1: " + velocity.getNumber() + " " +
            "\nCoefficient of restitution: " + 0.01*slider.getValue()+ 
            "\nHeight: " + he.getNumber() +  " " + "\nHorizontal Distance: " + (blackball.getX() - redball.getX()) + " " + "\nWhat is the final velocity of Ball 1?" ;
             **/

            writeQuestion.println("Mass of Ball 1: " + m1.getNumber());
            writeQuestion.println("Mass of Ball 2: " + m2.getNumber());
            writeQuestion.println("Initial Velocity of Ball 1: " + velocity.getNumber());
            writeQuestion.println("Height: " + he.getNumber());
            writeQuestion.println("Horizontal Distance from Ball 1 to Ball 2: " + length);
            writeQuestion.println("Coefficient of Restitution: " + 0.01*slider.getValue());
            writeQuestion.println("What is the final velocity of Ball 1?");
            writeQuestion.println();
            writeAnswer.println(count + ".) " + Math.round(finalVelocity1*100.0)/100.0);
        }

        else if(start4){
            question = "Ball 1 has a mass of " + m1.getNumber() + " and explodes " + " with Ball 2 which has a mass of " + m2.getNumber() + ". What is the final velocity of Ball 1?" ;
            writeQuestion.println(question);
            writeQuestion.println();
        }

        writeQuestion.close();
        writeAnswer.close();

    }

    @Override
    public void  stopped(){

        count = count + 1;
        writeQuestion.close();
        writeAnswer.close();
        System.out.println("Stopped World");

    }

}
