package com.b1llstnntotwitch;
import com.b1llstnntotwitch.FileParser;
import com.google.cloud.translate.*;
import java.awt.*;  
import java.awt.event.*;
import java.util.EventListener;  
/**
 * Hello world!
 */
public final class App implements EventListener {
    public static String textContent;
    
    private App() {
    
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
    
        try {
     
       
        Parser parser = new Parser();
        parser.openTextInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleInputText(String s) {
        
        textContent = s;
        try {
        String temp = TranslateText.translateText("ja", textContent);
        System.out.println("Translated text: \n" + temp + "!");
        } catch (Exception e) {

        }   
    }
}


