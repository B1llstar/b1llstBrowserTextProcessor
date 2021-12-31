package com.b1llstnntotwitch;
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
        
        String charsAfterNewline = s.substring(s.indexOf("\n")+1);

        charsAfterNewline.trim();
        System.out.println("Chars after newline: ");
System.out.println(charsAfterNewline);
        try {
        String temp = TranslateText.translateText("en", charsAfterNewline);
        System.out.println("Translated text: \n" + temp + "!");
        } catch (Exception e) {

        }   
    }
}


