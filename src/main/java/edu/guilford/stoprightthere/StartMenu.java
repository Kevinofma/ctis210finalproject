/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.stoprightthere;

import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class StartMenu implements ActionListener {

    JFrame frame = new JFrame("SRT");
    JButton startButton = new JButton("Start");
    JButton customButton = new JButton("Information");
    JLabel Title = new JLabel();

    StartMenu() {
        // startButton.setBounds(100,260,200,40);
        startButton.setBounds(120, 228, 160, 60);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setBackground(new Color(255, 255, 255));
        startButton.setBorderPainted(false);
        frame.add(startButton);
        
        // customButton.setBounds(100,325,200,40);
        customButton.setBounds(120, 293, 160, 60);
        customButton.setFocusable(false);
        customButton.addActionListener(this);
        customButton.setBackground(new Color(255, 255, 255));
        customButton.setBorderPainted(false);
        frame.add(customButton);
        
        ImageIcon title = new ImageIcon("stopRightThereLogo.jpg");
        Title.setBounds(-50,0,500,500);
        Title.setIcon(title);
        frame.add(Title);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println(e);
        if(e.getSource()== startButton) {
            playHitSound();
            frame.dispose();
            new LevelSelect();
        }
        // detects if action is performed and finds which button is pressed and
        // executes code to dispose of the current frame and open another frame.
        
        if(e.getSource() == customButton) {
            playHitSound();
            frame.dispose();
            new InformationPage();
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
    
}
