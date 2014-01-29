/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PersonaClassesl;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 997robotics4
 */
public class SuperSpeedController {
    private double desiredSpeed;
    private double currentSpeed;
    private SpeedController mySpeedController;
    
    
    
  public SuperSpeedController(SpeedController a) {
      mySpeedController = a;
      myTimer.scheduleAtFixedRate(myTimerTask, 0, 5);
  }
    
  public void set(double a) {
      desiredSpeed = a;
  }
  
    private Timer myTimer = new Timer ();
    private TimerTask myTimerTask = new TimerTask() {

        public void run() {
         if (desiredSpeed > currentSpeed){
             if(desiredSpeed - currentSpeed> .01){
                 currentSpeed +=.01;
             } else {
                 currentSpeed = desiredSpeed;
             }
            
         } else if (desiredSpeed < currentSpeed) {
             if (currentSpeed - desiredSpeed>.1){
                 currentSpeed -= .01;
             }
         }
         mySpeedController.set(currentSpeed);
        }
    };
    
}
