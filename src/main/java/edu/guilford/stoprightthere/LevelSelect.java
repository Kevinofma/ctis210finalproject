/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.stoprightthere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class LevelSelect implements ActionListener {

    JFrame frame = new JFrame();
    JButton song1 = new JButton("Stop Right There");
    JButton hardcore = new JButton("Hardcore");
    static boolean hardcoreDiff = false;
    JLabel hardcoreStatus = new JLabel("Hardcore: " + hardcoreDiff);

    LevelSelect() {

        song1.setBounds(25, 280, 300, 40);
        song1.setFocusable(false);
        song1.addActionListener(this);
        frame.add(song1);

        hardcore.setBounds(25, 180, 300, 40);
        hardcore.setFocusable(false);
        hardcore.addActionListener(this);
        frame.add(hardcore);
        
        hardcoreStatus.setBounds(25, 225, 300, 40);
        frame.add(hardcoreStatus);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == song1) {
            playHitSound();
            frame.dispose();
            new firstGame();
        }
        if (e.getSource() == hardcore) {
            playHitSound();
            if (hardcoreDiff == false) {
                hardcoreDiff = true;
                hardcoreStatus.setText("Hardcore: " + hardcoreDiff);
                System.out.println("Hardcore diff change: " + hardcoreDiff);
            } else if (hardcoreDiff == true) {
                hardcoreDiff = false;
                hardcoreStatus.setText("Hardcore: " + hardcoreDiff);
                System.out.println("Hardcore diff change: " + hardcoreDiff);
            }
        }
    }

    private void playHitSound() {
        File hitFile = new File("hitsound.wav");
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(hitFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(MusicPlayerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isHardcoreDiff() {
        return hardcoreDiff;
    }

    public static void setHardcoreDiff(boolean hardcoreDiff) {
        LevelSelect.hardcoreDiff = hardcoreDiff;
    }

}
