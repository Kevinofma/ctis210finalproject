/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.stoprightthere;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author kevin
 */
public class MusicPlayerThread extends Thread {

    public static int delay = 500;

    public static int getDelay() {
        return delay;
    }


    // delays starting the song so that I can have "negative delay" on the timers
    //          redundant currently.
    @Override
    public void run() {
        try {
            this.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(MusicPlayerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        // File file = new File("SRT_feat._Kyaru.wav");
        // This was the original song but the bpm caused issues with floating point 
        //          milliseconds so song was changed to the one under.
        // File file = new File("The_Stains_of_Time.wav");
        // File file = new File("100BPMMetro.wav");
        File file = new File(MusicPlayerThread.class.getResource("/FlowerDance.wav").getFile());
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            boolean stop = firstGame.isStop();
            System.out.println("Start Song Now!");
            while(stop == false) {
                stop = firstGame.isStop();
                System.out.print("");
                // for some BIZARRE reason, if theres no print statement, music wont stop
                //      when I want it to; I accidently found out it made the code work
                //      probably a better way to stop the music, but this took way to long
                //      to figure out.
                if(stop == true) {
                    System.out.println("STOP NOW!");
                    clip.flush();
                    clip.stop();
                    Thread.currentThread().stop();
                }
            }
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(MusicPlayerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
             

             
        // I have no clue what these catch lines do, it was recommended by netbeans and it
        // makes the program work so I don't really care.

    }

}
