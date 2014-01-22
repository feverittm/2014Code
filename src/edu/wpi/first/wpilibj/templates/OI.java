
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.SetGear;
import edu.wpi.first.wpilibj.templates.commands.ShooterCock;
import edu.wpi.first.wpilibj.templates.commands.ShooterRelease;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererAngle;
import edu.wpi.first.wpilibj.templates.commands.ToggleGathererOnOff;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
   private Button ShooterButton1;
   private Button ShooterButton2;
   private Button CockShooterButton; 
   private Button ToggleOnOffButton;
   private Button ToggleGathererButton;
   private Button SetGearQuarterButton;
   private Button SetGearHalfButton;
   private Button SetGear75Button;
   private Button SetGearFullButton;
   
    
    
    private Joystick Leftstick;
    private Joystick Rightstick ;   
    private Joystick Utilitystick;
    
   
    public OI(){
        //Joystick layout
        Leftstick = new Joystick(1);
        Rightstick = new Joystick(2);
        Utilitystick = new Joystick(3);
        
        
        //Button layout
       ShooterButton1 = new JoystickButton(Leftstick, 1);
       ShooterButton2 = new JoystickButton(Rightstick, 1);
       CockShooterButton = new JoystickButton(Utilitystick, 1);
       ToggleOnOffButton = new JoystickButton(Leftstick, 2);
       ToggleGathererButton = new JoystickButton(Utilitystick, 2);
       SetGearQuarterButton = new JoystickButton(Utilitystick, 4);
       SetGearHalfButton = new JoystickButton(Utilitystick, 5);
       SetGear75Button = new JoystickButton(Utilitystick, 6);
       SetGearFullButton = new JoystickButton(Utilitystick, 7);
        
        //Button Ports
        CockShooterButton.whenPressed(new ShooterCock());
        ShooterButton1.whenPressed(new ShooterRelease());
        ShooterButton2.whenPressed(new ShooterRelease());
        ToggleOnOffButton.whenPressed(new ToggleGathererOnOff());
        ToggleGathererButton.whenPressed(new ToggleGathererAngle());
        SetGearQuarterButton.whenPressed(new SetGear(0.25));
        SetGearFullButton.whenPressed(new SetGear(.5));
        SetGear75Button.whenPressed(new SetGear(.75));
        SetGearFullButton.whenPressed(new SetGear(1));
        
        //SmartDashboard Buttons
        SmartDashboard.putData("SetGearQuater: ", new SetGear(.25));
        SmartDashboard.putData("SetGearHalf: ", new SetGear(.5));
        SmartDashboard.putData("SetGear3/4: ", new SetGear(.75));
        SmartDashboard.putData("setGearFull: ", new SetGear(1));
        SmartDashboard.putData("CockShooter: ", new ShooterCock());
        SmartDashboard.putData("RelesaseShooter: ", new ShooterRelease());
        SmartDashboard.putData("ToggleGathererAngle: ", new ToggleGathererAngle());
        SmartDashboard.putData("ToggleGathererOnOff: ", new ToggleGathererOnOff());
}
     
   
    
    
    //Joystick Get y angle
    public double getLeftSpeed(){
       return Leftstick.getY();
    
        
    }
    public double getRightSpeed(){
          return Rightstick.getY();
    }
          
}

