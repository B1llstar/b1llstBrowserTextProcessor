package com.b1llstnntotwitch;
import com.google.cloud.translate.*;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        try {
        String temp = TranslateText.translateText();
        System.out.println("We returned a string: " + temp + "!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


