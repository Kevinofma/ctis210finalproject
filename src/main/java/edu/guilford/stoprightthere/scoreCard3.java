/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.stoprightthere;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class scoreCard3 {
    JFrame frame = new JFrame("Stop Right There");
    JLabel scoreLabel = new JLabel();
    JLabel earlyLabel = new JLabel();
    JLabel perfectLabel = new JLabel();
    JLabel lateLabel = new JLabel();
    JLabel missLabel = new JLabel();
    
    scoreCard3() {
        
        scoreLabel.setBounds(25,200,200,40);
        scoreLabel.setText("Score: " + thirdGame.getScore());
        frame.add(scoreLabel);
        
        earlyLabel.setBounds(25,225,200,40);
        earlyLabel.setText("Early Hits: " + thirdGame.getEarlyCount());
        frame.add(earlyLabel);
        
        perfectLabel.setBounds(25, 250, 200, 40);
        perfectLabel.setText("Perfect Hits!: " + thirdGame.getPerfectCount());
        frame.add(perfectLabel);
        
        lateLabel.setBounds(25, 275, 200, 40);
        lateLabel.setText("Late Hits: " + thirdGame.getLateCount());
        frame.add(lateLabel);
        
        missLabel.setBounds(25, 300, 200, 40);
        missLabel.setText("Missed Hits: " + thirdGame.getMissCount());
        frame.add(missLabel);
         
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

