/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 997robotics4
 */
public class subcompressor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Compressor myCompressor;
    private Timer myTimer;
    private TimerTask onTask = new TimerTask() {
        public void run() {
            startCompressor();
        }
    };

    private TimerTask offTask = new TimerTask() {

        public void run() {
            stopCompressor();
        }
    };
    private boolean isOn;

    public subcompressor(int compressorSwitchSlot, int compressorSpikeSlot) {
        myCompressor = new Compressor(compressorSwitchSlot, compressorSpikeSlot);
        myTimer.scheduleAtFixedRate(onTask, 0, 40000);
        myTimer.scheduleAtFixedRate(offTask, 20000, 40000);

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void startCompressor() {
        myCompressor.start();
        isOn =  true;
    }

    public void stopCompressor() {
        myCompressor.stop();
        isOn = false;
    }
public void SmartDashboard() {
    SmartDashboard.putData("Compressor", this);
    SmartDashboard.putBoolean("compressor is on", isOn);
}
}
