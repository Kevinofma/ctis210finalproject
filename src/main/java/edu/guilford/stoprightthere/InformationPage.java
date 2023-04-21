/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.stoprightthere;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */

public class InformationPage implements ActionListener {

    private JFrame frame = new JFrame();
//    private JLabel Controls = new JLabel();
//    private JLabel ControlsText = new JLabel();
//    private JLabel ControlsText2 = new JLabel();
    private JLabel Instructions = new JLabel();
    private JLabel InstructionsText = new JLabel();
    private JLabel InstructionsScore1 = new JLabel();
    private JLabel InstructionsScore2 = new JLabel();
    private JLabel InstructionsScore3 = new JLabel();
    private JLabel ImageSource = new JLabel();
    JButton backButton = new JButton("<-- Back");
//    JButton moreButton = new JButton("More -->");

    InformationPage(){
//        Controls.setBounds(25,20,200,40);
//        Controls.setText("KeyBoard Controls");
//        frame.add(Controls);
//        ControlsText.setBounds(25,40,200,40);
//        ControlsText.setText("b = Start Page");
//        frame.add(ControlsText);       
//        ControlsText2.setBounds(25,60,200,40);
//        ControlsText2.setText("r = Game Menu Page");
//        frame.add(ControlsText2); 
        Instructions.setBounds(25,20,200,40);
        Instructions.setText("How to play: ");
        frame.add(Instructions);
        
        InstructionsText.setBounds(25,40,350,40);
        InstructionsText.setText("Recommended medium: touchscreen");
        frame.add(InstructionsText);        
        
        InstructionsScore1.setBounds(25,80,350,40);
        InstructionsScore1.setText("Too early = +50 point");
        frame.add(InstructionsScore1);   
        
        InstructionsScore2.setBounds(25,100,350,40);
        InstructionsScore2.setText("Just Right = +100 point");
        frame.add(InstructionsScore2);
        
        InstructionsScore3.setBounds(25,120,350,40);
        InstructionsScore3.setText("Too Late = +50 point");
        frame.add(InstructionsScore3); 
        
        ImageSource.setBounds(25, 180, 350, 40);
        ImageSource.setText("Menu Image from SRT album by Atwood");
        frame.add(ImageSource);   
        
        backButton.setBounds(25,280, 300, 40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);
        
//        moreButton.setBounds(25,230, 300, 40);
//        moreButton.setFocusable(false);
//        moreButton.addActionListener(this);
//        frame.add(moreButton);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println(e);
        if(e.getSource()== backButton) {
            frame.dispose();
            new StartMenuNew();
        }
//        if(e.getSource() == moreButton) {
//            frame.dispose();
//            new RickPlayer();
//        }
}
}
