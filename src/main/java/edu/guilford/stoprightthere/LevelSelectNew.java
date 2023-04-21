/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.stoprightthere;

import java.awt.Color;
import java.awt.Font;
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
public class LevelSelectNew {

    JFrame frame = new JFrame("Level Select");
    JLabel background = new JLabel();
    JButton song1 = new JButton("Flower Dance - 100 BPM");
    JButton song2 = new JButton("The Stains of Time - 100 BPM");
    JButton song3 = new JButton("Dynamite -  120 BPM");
    JButton song4 = new JButton("placeholder - 120 BPM");
    JButton song5 = new JButton("placeholder - 125 BPM");
    JButton hardcore = new JButton("Hardcore");
    private static boolean hardcoreDiff = false;
    JLabel hardcoreStatus = new JLabel("Hardcore: OFF");
    
    Font bigFont = new Font("Dialog", Font.BOLD, 16);
    Font normalFont = new Font("Dialog", Font.BOLD, 12);

    LevelSelectNew() {
        song1.setBounds(20, 20, 300, 40);
        song1.setFocusable(false);
        song1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                song1MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                song1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                song1MouseExited(evt);
            }
        });
        frame.add(song1);
        
        song2.setBounds(20, 70, 300, 40);
        song2.setFocusable(false);
        song2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                song2MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                song2MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                song2MouseExited(evt);
            }
        });
        frame.add(song2);
        
        song3.setBounds(20, 120, 300, 40);
        song3.setFocusable(false);
        song3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                song3MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                song3MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                song3MouseExited(evt);
            }
        });
        frame.add(song3);
        
        song4.setBounds(20, 170, 300, 40);
        song4.setFocusable(false);
        song4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                song4MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                song4MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                song4MouseExited(evt);
            }
        });
        frame.add(song4);
        
        song5.setBounds(20, 220, 300, 40);
        song5.setFocusable(false);
        song5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                song5MouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                song5MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                song5MouseExited(evt);
            }
        });
        frame.add(song5);

        hardcore.setBounds(460, 275, 100, 40);
        hardcore.setFocusable(false);
        hardcore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hardcoreMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hardcoreMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                hardcoreMouseExited(evt);
            }
        });
        frame.add(hardcore);

        hardcoreStatus.setBounds(465, 245, 100, 40);
        hardcoreStatus.setForeground(new Color(220,220,220));
        frame.add(hardcoreStatus);

        ImageIcon image = new ImageIcon(LevelSelectNew.class.getResource("/LevelSelectBackground.jpg"));
        background.setBounds(0, 0, 585, 360);
        background.setIcon(image);
        background.setVisible(true);
        frame.add(background);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(585, 360);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void song1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        playHitSound();
        frame.dispose();
        new firstGame();
    }

    private void song1MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        song1.setBounds(20, 15, 350, 45);
        song1.setFont(bigFont);
        playMouseoverSound();
    }

    private void song1MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
         song1.setBounds(20, 20, 300, 40);
         song1.setFont(normalFont);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    private void song2MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        playHitSound();
        frame.dispose();
        new secondGame();
    }

    private void song2MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        song2.setBounds(20, 65, 350, 45);
        song2.setFont(bigFont);
        playMouseoverSound();
    }

    private void song2MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
         song2.setBounds(20, 70, 300, 40);
         song2.setFont(normalFont);
    }

    ////////////////////////////////////////////////////////////////////////////
    
    private void song3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        playHitSound();
        frame.dispose();
        new thirdGame();
    }

    private void song3MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        song3.setBounds(20, 115, 350, 45);
        song3.setFont(bigFont);
        playMouseoverSound();
    }

    private void song3MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
         song3.setBounds(20, 120, 300, 40);
         song3.setFont(normalFont);
    }
        
    ////////////////////////////////////////////////////////////////////////////
    
    private void song4MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        playHitSound();
        // frame.dispose();
        // new secondGame();
    }

    private void song4MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        song4.setBounds(20, 165, 350, 45);
        song4.setFont(bigFont);
        playMouseoverSound();
    }

    private void song4MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
         song4.setBounds(20, 170, 300, 40);
         song4.setFont(normalFont);
    }
        
    ////////////////////////////////////////////////////////////////////////////
    
    private void song5MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        playHitSound();
        // frame.dispose();
        // new secondGame();
    }

    private void song5MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        song5.setBounds(20, 215, 350, 45);
        song5.setFont(bigFont);
        playMouseoverSound();
    }

    private void song5MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
         song5.setBounds(20, 220, 300, 40);
         song5.setFont(normalFont);
    }
        
    ////////////////////////////////////////////////////////////////////////////
    
    private void hardcoreMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        playHitSound();
        if (hardcoreDiff == false) {
            hardcoreDiff = true;
            hardcoreStatus.setText("Hardcore: ON");
            System.out.println("Hardcore diff change: " + hardcoreDiff);
        } else if (hardcoreDiff == true) {
            hardcoreDiff = false;
            hardcoreStatus.setText("Hardcore: OFF");
            System.out.println("Hardcore diff change: " + hardcoreDiff);
        }
    }

    private void hardcoreMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void hardcoreMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void playHitSound() {
        File hitFile = new File(LevelSelectNew.class.getResource("/hitsound.wav").getFile());
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
    
    private void playMouseoverSound() {
        File hitFile = new File(LevelSelectNew.class.getResource("/mouseoverSound.wav").getFile());
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
        LevelSelectNew.hardcoreDiff = hardcoreDiff;
    }

}
