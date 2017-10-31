/**
 * Write a description of class ReadFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;
public class ReadFile  
{
    private String path="";
    private int numberOfLines;
    /**
     * Constructor for objects of class ReadFile
     */
    public ReadFile(String path)
    {
        this.path = path;
    }

    public String[] OpenFile() throws IOException{

        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines(); //reads text file
        String[] textData = new String[numberOfLines]; //when reset, numberOfLines changes

        for(int i=0;i<numberOfLines;i++){

            textData[i] += textReader.readLine();

        }

        textReader.close();
        fr.close();
        return textData;

    }
    
    int readLines() throws IOException{
        FileReader file_to_Read = new FileReader(this.path);
        BufferedReader bf = new BufferedReader(file_to_Read);
        String aLine;
        int numberOfLines = 0;
        
        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }

        bf.close();
        file_to_Read.close();
        return numberOfLines;
    }
}
