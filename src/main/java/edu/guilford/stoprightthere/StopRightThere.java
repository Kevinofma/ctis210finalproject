/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.guilford.stoprightthere;

/**
 *
 * @author kevin
 */
public class StopRightThere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new StopRightThere();
        new StartMenuNew();
        // new StartMenu();
        // new testFrame();
    }
    
}
// Notes for when adding a new song/level:
//      remember to:
//              change the class name (public class ------)
//              change the frame name to song name (JFrame frame = new JFrame("------"))
//              change songThread class (MusicPlayerThread# songThread = new MusicPlayerThread#())
//              change bpm to bpm of song (public static int BPM = ###)
//              change songLength to length of song in sec (public static double songLength = ###)
//              change start delay (private int startDelay = ##)
//              change getDelay to correct class (private int delay = MusicPlayerThread#.getDelay())
//              change class name for variables (----Game() { )
//              change scoreCard at endGame() (new scoreCard#();)


// issues: 
//          issue where pressing a button but dragging it outside button will not 
//                  register click
//
//          issue where pressing a button but releasing it right after it dissapears 
//                  does not register click
//                  
//                  potential fix: removing late button all together
//                  potential fix 2: replacing ALL action listeners with mouse pressed listeners
//
//              update: Both first and second issue fixed with fix 2!
//
//          Due to the constrants of milliseconds for timers, only BPMs divisible by 60,000
//                  can only be used