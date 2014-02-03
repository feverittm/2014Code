/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PersonaClassesl;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author 997robotics4
 */
public class Joystick997 extends Joystick {
    private Joystick myJoystick;
    public Joystick997(int slot){
            super(slot);
        myJoystick = new Joystick(slot);
    }
    public double get() {
        return -super.getY();
    }
    
}
