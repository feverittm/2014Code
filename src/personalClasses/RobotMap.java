/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personalClasses;

/**
 *
 * @author 997robotics4
 */
public class RobotMap {
    
    
    //Use these arrays to further clarify what electrical 
    //slots are actually used. a call of Analog[1] will result
    //in a integer of 1. while functionally no different it will increase
    //organization considerably. so please use these! the only draw back is you 
    //must call Init() in RobotTemplate's RobotInit(), so don't forget that.
    //AnalogChannels 1-8
    int[] Analog = new int[9];
    //Pneumatics
    int[] Pnuematics = new int[5];
    //PWMs 1-10
    int[] PWM = new int[11];
    //Relays 1-8
    int[] Relay = new int[9];
    //Digital IOs 1-14
    int[] IO = new int[15]; 
   public void Init() {
        for(int i = 0; i<=9; i++){
            Analog[i]=i;
        }
        for(int i = 0; i<=5; i++){
            Pnuematics[i]=i;
        }
        for(int i = 0; i<=11; i++){
            PWM[i]=i;
        }
        for(int i = 0; i<=9; i++){
            Relay[i]=i;
        }
        for(int i = 0; i<=15; i++){
            IO[i]=i;
        }
        
    }
}
