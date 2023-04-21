/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.stoprightthere;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author kevin
 */
public class thirdGame {

    JFrame frame = new JFrame("Dynamite");
    JButton startButton = new JButton("Start");
//    StopRightThereSongThread songThread = new StopRightThereSongThread();
//    songThread.start();

    JButton earlyNote1 = new JButton("1");
    JButton perfectNote1 = new JButton("1");
    JButton lateNote1 = new JButton("1");

    JButton earlyNote2 = new JButton("2");
    JButton perfectNote2 = new JButton("2");
    JButton lateNote2 = new JButton("2");

    JButton missNote = new JButton();

    JLabel scoreLabel = new JLabel("Score: " + score);
    JLabel hitLabel = new JLabel();

    Font buttonFont = new Font("Arial", Font.BOLD, 32);
    Border emptyBorder = BorderFactory.createEmptyBorder();

    Random rand = new Random();
    MusicPlayerThread3 songThread = new MusicPlayerThread3();

    public static int BPM = 120; // change to corresponding BPM
    private int noteGap = 60000 / BPM; // calculates the # ms / beat
    private int songOffset = 70; // notes may feel off beat without correct offset;
    public static int[] xLoc = new int[BPM * 5]; // BPM * 5 used so it calculates a number for each beat assuming
    public static int[] yLoc = new int[BPM * 5];        // the song is 5 minutes long (shouldn't be longer anyways)
    private double secondsPassed = 0;
    public static double songLength = 197; // change this variable to length of song in seconds
    // public static double songLength = 5; // used for testing how game ends
    public static boolean stop = false;
    public static int score = 0;
    private int startDelay = 25; // set to how many beats u wana skip before notes start spawning
    // private int startDelay = 4; // used for testing game mechanics
    private int delay = MusicPlayerThread3.getDelay();
    private static int perfectCount = 0;
    private static int earlyCount = 0;
    private static int lateCount = 0;
    public static int missCount = 0;
    public static boolean miss1 = true;
    public static boolean miss2 = true; // 2 miss booleans so that game doesn't start with automatic miss when second note spawns
    public static boolean hit1 = false;
    public static boolean hit2 = false;
    private boolean hardcore;

    thirdGame() {

        scoreLabel.setBounds(1000, 0, 250, 100);
        scoreLabel.setForeground(new Color(200, 200, 200));
        frame.add(scoreLabel);

        perfectNote1.setBounds(400, 550, 100, 100);
        perfectNote1.setFocusable(false);
//        perfectNote1.addActionListener(this);
        perfectNote1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                perfectNote1MousePressed(evt);
            }
        });
        perfectNote1.setBackground(Color.GREEN);
        perfectNote1.setVisible(false);
        perfectNote1.setFont(buttonFont);
        frame.add(perfectNote1);

        perfectNote2.setBounds(400, 550, 100, 100);
        perfectNote2.setFocusable(false);
//       perfectNote2.addActionListener(this);
        perfectNote2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                perfectNote2MousePressed(evt);
            }
        });
        perfectNote2.setBackground(Color.GREEN);
        perfectNote2.setVisible(false);
        perfectNote2.setFont(buttonFont);
        frame.add(perfectNote2);

        earlyNote1.setBounds(400, 550, 100, 100);
        earlyNote1.setFocusable(false);
//        earlyNote1.addActionListener(this);
        earlyNote1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                earlyNote1MousePressed(evt);
            }
        });
        earlyNote1.setBackground(Color.CYAN);
        earlyNote1.setVisible(false);
        frame.add(earlyNote1);

        lateNote1.setBounds(400, 550, 100, 100);
        lateNote1.setFocusable(false);
//        lateNote1.addActionListener(this);
        lateNote1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lateNote1MousePressed(evt);
            }
        });
        lateNote1.setBackground(Color.RED);
        lateNote1.setVisible(false);
        frame.add(lateNote1);

        earlyNote2.setBounds(400, 550, 100, 100);
        earlyNote2.setFocusable(false);
//        earlyNote2.addActionListener(this);
        earlyNote2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                earlyNote2MousePressed(evt);
            }
        });
        earlyNote2.setBackground(Color.CYAN);
        earlyNote2.setVisible(false);
        frame.add(earlyNote2);

        lateNote2.setBounds(400, 550, 100, 100);
        lateNote2.setFocusable(false);
//        lateNote2.addActionListener(this);
        lateNote2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lateNote2MousePressed(evt);
            }
        });
        lateNote2.setBackground(Color.RED);
        lateNote2.setVisible(false);
        frame.add(lateNote2);

        startButton.setBounds(550, 250, 100, 100);
        startButton.setFocusable(false);
//        startButton.addActionListener(this);
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        startButton.setBackground(Color.red);
        startButton.setVisible(true);
        frame.add(startButton);

        missNote.setBounds(0, 0, 3000, 3000);
        missNote.setFocusable(false);
//        missNote.addActionListener(this);
        missNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                missNoteMousePressed(evt);
            }
        });
        // missNote.setBackground(Color.BLACK);
        missNote.setContentAreaFilled(false);
        missNote.setBorder(emptyBorder);
        missNote.setVisible(false);
        frame.add(missNote);

        hitLabel.setBounds(0, 0, 120, 120);
        hitLabel.setFocusable(false);
        ImageIcon check = new ImageIcon(thirdGame.class.getResource("/greenCheckMarkRescaled-removebg-preview.png"));
        hitLabel.setIcon(check);
        hitLabel.setVisible(false);
        frame.add(hitLabel);
        // ^ this doesn't work but doesn't hurt program might figure out how to fix later
        // Update: It works now!

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(1250, 650);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void perfectNote1MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
            playHitSound();
            perfectNote1.setVisible(false);
            backgroundChange();
            System.out.println("Win");
            score = score + 100;
            scoreLabel.setText("Score: " + score);
            perfectCount = perfectCount + 1;
            miss1 = false;
            miss2 = false;
            hit1 = true;
    }

    private void perfectNote2MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
            playHitSound();
            perfectNote2.setVisible(false);
            backgroundChange();
            System.out.println("Win");
            score = score + 100;
            scoreLabel.setText("Score: " + score);
            perfectCount = perfectCount + 1;
            miss1 = false;
            miss2 = false;
            hit2 = true;
    }

    private void earlyNote1MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        //note1.setVisible(false);
            playHitSound();
            System.out.println("too early");
            score = score + 50;
            scoreLabel.setText("Score: " + score);
            earlyCount = earlyCount + 1;
            miss1 = false;
            miss2 = false;
    }

    private void lateNote1MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
            playHitSound();
            System.out.println("too late");
            score = score + 50;
            scoreLabel.setText("Score: " + score);
            lateCount = lateCount + 1;
            miss1 = false;
            miss2 = false;

    }

    private void earlyNote2MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
            playHitSound();
            System.out.println("too early");
            score = score + 50;
            scoreLabel.setText("Score: " + score);
            earlyCount = earlyCount + 1;
            miss1 = false;
            miss2 = false;
    }

    private void lateNote2MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
            playHitSound();
            System.out.println("too late");
            score = score + 50;
            scoreLabel.setText("Score: " + score);
            lateCount = lateCount + 1;
            miss1 = false;
            miss2 = false;
    }

    private void missNoteMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
            playMissSound();
            System.out.println("MISS!");
            score = score - 50;
            scoreLabel.setText("Score: " + score);
            playMissSound();
            missCount = missCount + 1;
            miss1 = false;
            miss2 = false;
            // miss booleans set to false so u dont get a double miss
            //      if you miss the note by pressing outside the note
            if (hardcore) {
                gameEnd();
            }
    }
    
    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        for (int i = 0; i < xLoc.length; i++) {
                xLoc[i] = rand.nextInt(1000) + 25;
                System.out.println(xLoc[i]);
            }

            for (int i = 0; i < yLoc.length; i++) {
                yLoc[i] = rand.nextInt(500) + 25;
                System.out.println(yLoc[i]);
            }

            System.out.println("Started");
            playHitSound();
            startButton.setVisible(false);
            initTasks();
            songThread.start();
            swingTimer.start();
            System.out.println(delay);
            miss1 = false; // makes so first note spawn doesn't count as miss
            miss2 = false;
            hardcore = LevelSelectNew.isHardcoreDiff();
            // System.out.println("Hardcore is: " + hardcore);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == startButton) {
//
//            for (int i = 0; i < xLoc.length; i++) {
//                xLoc[i] = rand.nextInt(1000) + 25;
//                System.out.println(xLoc[i]);
//            }
//
//            for (int i = 0; i < yLoc.length; i++) {
//                yLoc[i] = rand.nextInt(500) + 25;
//                System.out.println(yLoc[i]);
//            }
//
//            System.out.println("Started");
//            playHitSound();
//            startButton.setVisible(false);
//            initTasks();
//            songThread.start();
//            swingTimer.start();
//            System.out.println(delay);
//            miss1 = false; // makes so first note spawn doesn't count as miss
//            miss2 = false;
//            hardcore = LevelSelectNew.isHardcoreDiff();
//            // System.out.println("Hardcore is: " + hardcore);
//
//        }
//        if (e.getSource() == earlyNote1) {
//            //note1.setVisible(false);
//            playHitSound();
//            System.out.println("too early");
//            score = score + 50;
//            scoreLabel.setText("Score: " + score);
//            earlyCount = earlyCount + 1;
//            miss1 = false;
////            miss2 = false;
//
//        }
//        if (e.getSource() == perfectNote1) {
//            //note2.setVisible(false);
//            playHitSound();
//            backgroundChange();
//            System.out.println("Win");
//            score = score + 100;
//            scoreLabel.setText("Score: " + score);
//            perfectCount = perfectCount + 1;
//            miss1 = false;
//            miss2 = false;
//            hit1 = true;
//
//        }
//        if (e.getSource() == lateNote1) {
//            //note3.setVisible(false);
//            playHitSound();
//            System.out.println("too late");
//            score = score + 50;
//            scoreLabel.setText("Score: " + score);
//            lateCount = lateCount + 1;
//            miss1 = false;
//            miss2 = false;
//        }
//        if (e.getSource() == earlyNote2) {
//            //note1.setVisible(false);
//            playHitSound();
//            System.out.println("too early");
//            score = score + 50;
//            scoreLabel.setText("Score: " + score);
//            earlyCount = earlyCount + 1;
//            miss1 = false;
//            miss2 = false;
//
//        }
//        if (e.getSource() == perfectNote2) {
//            //note2.setVisible(false);
//            playHitSound();
//            backgroundChange();
//            System.out.println("Win");
//            score = score + 100;
//            scoreLabel.setText("Score: " + score);
//            perfectCount = perfectCount + 1;
//            miss1 = false;
//            miss2 = false;
//            hit2 = true;
//
//        }
//        if (e.getSource() == lateNote2) {
//            //note3.setVisible(false);
//            playHitSound();
//            System.out.println("too late");
//            score = score + 50;
//            scoreLabel.setText("Score: " + score);
//            lateCount = lateCount + 1;
//            miss1 = false;
//            miss2 = false;
//        }
//        if (e.getSource() == missNote) {
//            playMissSound();
//            System.out.println("MISS!");
//            score = score - 50;
//            scoreLabel.setText("Score: " + score);
//            playMissSound();
//            missCount = missCount + 1;
//            miss1 = false;
//            miss2 = false;
//            // miss booleans set to false so u dont get a double miss
//            //      if you miss the note by pressing outside the note
//            if (hardcore) {
//                gameEnd();
//            }
//        }
//
//    }
    
private void playHitSound() {
    File hitFile = new File(firstGame.class.getResource("/hitsound.wav").getFile());
    AudioInputStream audioStream;
    try {
        audioStream = AudioSystem.getAudioInputStream(hitFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        Logger.getLogger(MusicPlayerThread.class
                .getName()).log(Level.SEVERE, null, ex);
    }
}

private void playMissSound() {
    File missFile = new File(firstGame.class.getResource("/misssound.wav").getFile());
    AudioInputStream audioStream;
    try {
        audioStream = AudioSystem.getAudioInputStream(missFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        Logger.getLogger(MusicPlayerThread.class
                .getName()).log(Level.SEVERE, null, ex);
    }
}

    private void backgroundChange() {
        int r = rand.nextInt(151);
        int g = rand.nextInt(151);
        int b = rand.nextInt(151);
        // values only generate from 0 to 150 because contrast is bad at higher values
        //      contrast still bad at times but less worse.
        Color randColor = new Color(r, g, b);
        frame.getContentPane().setBackground(randColor);
    }

    private void initTasks() {
        TimerTask task1 = new MyTimerTask1();
        TimerTask task2 = new MyTimerTask2();
        TimerTask task3 = new MyTimerTask3();

        TimerTask task4 = new MyTimerTask4();
        TimerTask task5 = new MyTimerTask5();
        TimerTask task6 = new MyTimerTask6();
        Timer noteTimer = new Timer();

        noteTimer.schedule(task1, delay - 355 + songOffset + (startDelay * noteGap), noteGap * 2); // time for early note
        noteTimer.schedule(task2, delay - 10 + songOffset + (startDelay * noteGap), noteGap * 2); // time for just right note
        noteTimer.schedule(task3, delay + 355 + songOffset + (startDelay * noteGap), noteGap * 2); // time for late note
        // Index: (values are in milliseconds)
        // delay: time between when start button pressed and song starts
        // Number: time before the beat where button appears
        //          ex: -10 means about* 10 milliseconds before the beat, button appears
        // *songOffset: Delay for button spawns dependent on the song and user feel
        //          ^ (not based on anything, adjusted to what FEELS right)
        // startDelay: number of BEATS you want to wait before notes spawn
        //          ^ dependent on song, this song has long intro so long startDelay
        // noteGap: calculated with BPM, time in milliseconds between each BEAT
        //          ^ multiply with startDelay to get time before song starts
        // additional info: first 3 tasks deal with spawning the button on every odd beat 
        //          ex: (beat 1, beat 3, beat 5, etc.)
        //      The next 3 tasks deal with spawning the button on every even beat
        //          ex: (beat 2, beat 4, beat 6, etc.)
        //      This allows for 2 buttons on the screen at a time, alternating every beat

        // Second note that appears on screen
        noteTimer.schedule(task4, delay - 355 + songOffset + (startDelay * noteGap) + noteGap, noteGap * 2); // time for early note
        noteTimer.schedule(task5, delay - 10 + songOffset + (startDelay * noteGap) + noteGap, noteGap * 2); // time for perfect note
        noteTimer.schedule(task6, delay + 355 + songOffset + (startDelay * noteGap) + noteGap, noteGap * 2); // time for late note
    }

    int index1 = 0;
    int index2 = 0;
    int index3 = 0;
    int index4 = 1;
    int index5 = 1;
    int index6
            = 1;

    class MyTimerTask1 extends TimerTask {

        public void run() {
            if (!stop) {
                if (miss1 == true) {
                    missNote.setVisible(true); // makes so you can only miss after notes appear
                    int xLoc1 = (int) Array.get(xLoc, index1);
                    int yLoc1 = (int) Array.get(yLoc, index1);
                    earlyNote1.setBounds(xLoc1 + 10, yLoc1 + 10, 80, 80);
                    System.out.println("Note spawns");
                    earlyNote1.setVisible(true);
                    lateNote1.setVisible(false);
                    index1 = index1 + 2;
                    miss1 = true;
                    playMissSound();
                    missCount = missCount + 1;
                    score = score - 50;
                    scoreLabel.setText("Score: " + score);
                    hitLabel.setVisible(false);
                    if (hardcore) {
                        gameEnd();
                    }
                } else if (miss1 == false) {
                    missNote.setVisible(true);
                    int xLoc1 = (int) Array.get(xLoc, index1);
                    int yLoc1 = (int) Array.get(yLoc, index1);
                    earlyNote1.setBounds(xLoc1 + 10, yLoc1 + 10, 80, 80);
                    System.out.println("Note spawns");
                    earlyNote1.setVisible(true);
                    lateNote1.setVisible(false);
                    index1 = index1 + 2;
                    miss1 = true;
                }
            } else {
                Thread.currentThread().stop();
            }

        }
    }

    class MyTimerTask2 extends TimerTask {

        public void run() {
            if (!stop) {
                int xLoc2 = (int) Array.get(xLoc, index2);
                int yLoc2 = (int) Array.get(yLoc, index2);
                perfectNote1.setBounds(xLoc2, yLoc2, 100, 100);
                System.out.println("Note is optimal!!!!!!!!!!!!!!!!!!!");
                perfectNote1.setVisible(true);
                earlyNote1.setVisible(false);
                index2 = index2 + 2;
            } else {
                Thread.currentThread().stop();
            }
        }
    }

    class MyTimerTask3 extends TimerTask {

        public void run() {
            if (!stop) {
                if (hit1 == true) {
                    int xLoc3 = (int) Array.get(xLoc, index3);
                    int yLoc3 = (int) Array.get(yLoc, index3);
                    lateNote1.setBounds(xLoc3, yLoc3, 100, 100);

                    hitLabel.setBounds(xLoc3, yLoc3, 100, 100);
                    hitLabel.setVisible(true);

                    System.out.println("Note despawns");
                    lateNote1.setVisible(false);
                    perfectNote1.setVisible(false);
                    index3 = index3 + 2;
                    hit1 = false;
                } else if (hit1 == false) {
                    int xLoc3 = (int) Array.get(xLoc, index3);
                    int yLoc3 = (int) Array.get(yLoc, index3);
                    lateNote1.setBounds(xLoc3, yLoc3, 100, 100);
                    System.out.println("Note despawns");
                    lateNote1.setVisible(true);
                    perfectNote1.setVisible(false);
                    index3 = index3 + 2;
                }
            } else {
                Thread.currentThread().stop();
            }
        }
    }

    class MyTimerTask4 extends TimerTask {

        public void run() {
            if (!stop) {
                if (miss2 == true) {
                    int xLoc4 = (int) Array.get(xLoc, index4);
                    int yLoc4 = (int) Array.get(yLoc, index4);
                    earlyNote2.setBounds(xLoc4 + 10, yLoc4 + 10, 80, 80);
                    System.out.println("Note spawns");
                    earlyNote2.setVisible(true);
                    lateNote2.setVisible(false);
                    index4 = index4 + 2;
                    miss2 = true;
                    playMissSound();
                    missCount = missCount + 1;
                    score = score - 50;
                    scoreLabel.setText("Score: " + score);
                    hitLabel.setVisible(false);
                    if (hardcore) {
                        gameEnd();
                    }
                } else if (miss2 == false) {
                    missNote.setVisible(true);
                    int xLoc4 = (int) Array.get(xLoc, index4);
                    int yLoc4 = (int) Array.get(yLoc, index4);
                    earlyNote2.setBounds(xLoc4 + 10, yLoc4 + 10, 80, 80);
                    System.out.println("Note spawns");
                    earlyNote2.setVisible(true);
                    lateNote2.setVisible(false);
                    index4 = index4 + 2;
                    miss2 = true;
                }
            } else {
                Thread.currentThread().stop();
            }

        }
    }

    class MyTimerTask5 extends TimerTask {

        public void run() {
            if (!stop) {
                int xLoc5 = (int) Array.get(xLoc, index5);
                int yLoc5 = (int) Array.get(yLoc, index5);
                perfectNote2.setBounds(xLoc5, yLoc5, 100, 100);
                System.out.println("Note is optimal!!!!!!!!!!!!!!!!!");
                perfectNote2.setVisible(true);
                earlyNote2.setVisible(false);
                index5 = index5 + 2;
            } else {
                Thread.currentThread().stop();
            }
        }
    }

    class MyTimerTask6 extends TimerTask {

        public void run() {
            if (!stop) {
                if (hit2 == true) {
                    int xLoc6 = (int) Array.get(xLoc, index6);
                    int yLoc6 = (int) Array.get(yLoc, index6);
                    lateNote2.setBounds(xLoc6, yLoc6, 100, 100);

                    hitLabel.setBounds(xLoc6, yLoc6, 100, 100);
                    hitLabel.setVisible(true);

                    System.out.println("Note despawns");
                    lateNote2.setVisible(false);
                    perfectNote2.setVisible(false);
                    index6 = index6 + 2;
                    hit2 = false;
                } else if (hit2 == false) {
                    int xLoc6 = (int) Array.get(xLoc, index6);
                    int yLoc6 = (int) Array.get(yLoc, index6);
                    lateNote2.setBounds(xLoc6, yLoc6, 100, 100);
                    System.out.println("Note despawns");
                    lateNote2.setVisible(true);
                    perfectNote2.setVisible(false);
                    index6 = index6 + 2;
                }
            } else {
                Thread.currentThread().stop();
            }
        }
    }

    javax.swing.Timer swingTimer = new javax.swing.Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (secondsPassed > songLength || stop) {
                gameEnd();
            } else {
                secondsPassed = secondsPassed + 0.1;
                // may add label displaying time left later
            }
        }

    });

    private void gameEnd() {
        stop = true; // stops timertasks with false conditional
        swingTimer.stop();
        frame.dispose();
        new scoreCard3();
        Thread.currentThread().stop(); // might not be nessecary
    }

    // getters for the score card after game ends
    public static int getScore() {
        return score;
    }

    public static int getPerfectCount() {
        return perfectCount;
    }

    public static int getEarlyCount() {
        return earlyCount;
    }

    public static int getLateCount() {
        return lateCount;
    }

    public static int getMissCount() {
        return missCount;
    }

    // getter so that the music can stop when game ends
    public static boolean isStop() {
        return stop;
    }

}
