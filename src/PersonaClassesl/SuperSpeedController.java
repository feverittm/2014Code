/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PersonaClassesl;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 997robotics4
 */
public class SuperSpeedController implements SpeedController{
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
  public SpeedController getSpeedController() {
      return mySpeedController;
  }
  
    private Timer myTimer = new Timer ();
    private TimerTask myTimerTask = new TimerTask() {
        private double maxAccel = .01;
        public void run() {
         if (desiredSpeed > currentSpeed){
             if(desiredSpeed - currentSpeed> maxAccel){
                 currentSpeed +=maxAccel;
             } else {
                 currentSpeed = desiredSpeed;
             }
            
         } else if (desiredSpeed < currentSpeed) {
             if (currentSpeed - desiredSpeed>maxAccel){
                 currentSpeed -= maxAccel;
             }
         }
         mySpeedController.set(currentSpeed);
        }
    };

    public double get() {
        return currentSpeed;
    }

    public void set(double d, byte b) {
        mySpeedController.set(d, b);
    }

    public void disable() {
    mySpeedController.disable();
    }

    public void pidWrite(double d) {
        mySpeedController.pidWrite(d);
    }
    
}
